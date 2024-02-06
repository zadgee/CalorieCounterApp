package glue.profile.di
import android.content.Context
import dagger.Module
import dagger.Provides
import domain.repo.ProfileRepository
import domain.usecases.DeleteGmailUserFromDBUseCase
import domain.usecases.DeleteUserFromDBUseCase
import domain.usecases.GetGmailUserUseCase
import domain.usecases.GetUserFromDatabaseUseCase
import domain.usecases.SignOutWhileUsingEmailPasswordUseCase
import domain.usecases.SignOutWhileUsingGmailAuth
import glue.navigation.NavigationComponent
import glue.profile.repo.ProfileRepositoryImpl
import presentation.viewModel.ProfileViewModelFactory

@Module
class ProfileModule(
    private val context:Context,
    private val navigationComponent: NavigationComponent
){

    @Provides
    fun provideProfileRepo(
        signOutWhileUsingEmailPasswordUseCase:SignOutWhileUsingEmailPasswordUseCase,
        signOutWhileUsingGmailAuth:SignOutWhileUsingGmailAuth,
        deleteGmailUserFromDBUseCase: DeleteGmailUserFromDBUseCase,
        deleteUserFromDBUseCase: DeleteUserFromDBUseCase,
        getUserFromDatabaseUseCase: GetUserFromDatabaseUseCase,
        getGmailUserUseCase: GetGmailUserUseCase
    ):ProfileRepository{
        return ProfileRepositoryImpl(
           signOutWhileUsingEmailPasswordUseCase = signOutWhileUsingEmailPasswordUseCase,
           signOutWhileUsingGmailAuthUseCase = signOutWhileUsingGmailAuth,
           deleteGmailUserFromDBUseCase = deleteGmailUserFromDBUseCase,
           deleteUserFromDatabaseUseCase = deleteUserFromDBUseCase,
           context = context,
           getGmailUserUseCase = getGmailUserUseCase,
           getUserFromDatabaseUseCase = getUserFromDatabaseUseCase
        )
    }

    @Provides
    fun provideProfileViewModelFactory(
        profileRepository: ProfileRepository,
    ): ProfileViewModelFactory {
        return ProfileViewModelFactory(
            profileRepository = profileRepository,
            profileNavRouter = navigationComponent.getProfileNavRouter()
        )
    }

}