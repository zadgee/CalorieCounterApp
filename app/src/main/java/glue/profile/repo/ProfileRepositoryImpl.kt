package glue.profile.repo
import android.content.Context
import domain.models.GmailUserEntity
import domain.models.UserEntity
import domain.repo.GmailUserToBeDeleted
import domain.repo.ProfileRepository
import domain.repo.ProfileUserDataDefaultAuthModel
import domain.repo.ProfileUserDataGmailAuthModel
import domain.repo.UserToBeDeleted
import domain.usecases.DeleteGmailUserFromDBUseCase
import domain.usecases.DeleteUserFromDBUseCase
import domain.usecases.GetGmailUserUseCase
import domain.usecases.GetUserFromDatabaseUseCase
import domain.usecases.SignOutWhileUsingEmailPasswordUseCase
import domain.usecases.SignOutWhileUsingGmailAuth
import glue.profile.mapper.toProfileUserDataDefaultAuthModel
import glue.profile.mapper.toProfileUserDataGmailAuthModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import presentation.showToast
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val signOutWhileUsingGmailAuthUseCase: SignOutWhileUsingGmailAuth,
    private val signOutWhileUsingEmailPasswordUseCase: SignOutWhileUsingEmailPasswordUseCase,
    private val deleteUserFromDatabaseUseCase:DeleteUserFromDBUseCase,
    private val deleteGmailUserFromDBUseCase: DeleteGmailUserFromDBUseCase,
    private val getUserFromDatabaseUseCase:GetUserFromDatabaseUseCase,
    private val getGmailUserUseCase:GetGmailUserUseCase,
    private val context:Context
):ProfileRepository{
    override suspend fun signOutWhileUsingGmailAuth() {
        return signOutWhileUsingGmailAuthUseCase.signOut()
    }

    override suspend fun signOutWhileUsingEmailPassword() {
        return signOutWhileUsingEmailPasswordUseCase.signOut()
    }

    override suspend fun deleteUserFromLocalDB(user:UserToBeDeleted) {
        return deleteUserFromDatabaseUseCase.deleteUser(
            UserEntity(
                name = user.name,
                email = user.email,
                password = user.password,
                whenAuthorized = user.whenAuthorized
            )
        )
    }

    override suspend fun deleteGmailUserFromDB(user: GmailUserToBeDeleted) {
        return deleteGmailUserFromDBUseCase.deleteUser(
            GmailUserEntity(
                id = user.id,
                name = user.name,
                photoUrl = user.photoUrl,
                whenAuthorized = user.whenAuthorized
            )
        )
    }

    override suspend fun getProfileUserDataGmailAuth(): Flow<ProfileUserDataGmailAuthModel> {
        return flow{
            emit(
                getGmailUserUseCase
                    .execute()?.toProfileUserDataGmailAuthModel()?:throw Exception(
                    "Default user not found"
                )
            )
        }.catch {
            showToast(
                it.message?:"Unknown error",
                context
            )
        }
    }

    override suspend fun getProfileUserDataDefaultAuth(): Flow<ProfileUserDataDefaultAuthModel> {
        return flow{
            emit(
                getUserFromDatabaseUseCase.getUserFromDataBase
                    ()?.toProfileUserDataDefaultAuthModel() ?: throw Exception(
                    "Default user not found"
                    )
            )
        }.catch {
            showToast(
                it.message?:"Unknown error",
                context
            )
        }
    }
}