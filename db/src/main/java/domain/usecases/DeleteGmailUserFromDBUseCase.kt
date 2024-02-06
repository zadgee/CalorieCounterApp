package domain.usecases
import domain.models.GmailUserEntity
import domain.repository.UserDataSource
import javax.inject.Inject

class DeleteGmailUserFromDBUseCase @Inject constructor(
    private val userDataSource: UserDataSource
){

    suspend fun deleteUser(user:GmailUserEntity){
        return userDataSource.deleteGmailUserFromDB(user)
    }

}