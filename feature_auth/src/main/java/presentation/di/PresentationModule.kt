package presentation.di
import androidx.work.WorkManager
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.SignInClient
import dagger.Module
import dagger.Provides
import data.annotations.GmailSignIn
import data.annotations.GmailSignUp
import domain.usecase.AddUserToFireStoreUseCase
import domain.usecase.DeleteUserFromFirebaseUseCase
import domain.usecase.GetUserNameFromFireStoreByEmail
import domain.usecase.GetFirebaseUserUseCase
import domain.usecase.GmailAuthUseCase
import domain.usecase.LoginUseCase
import domain.usecase.ReloadUserUseCase
import domain.usecase.SendEmailVerificationLetterUseCase
import domain.usecase.SendPasswordResetEmailUseCase
import domain.usecase.SignOutWhileUsingEmailPasswordUseCase
import domain.usecase.SignOutWhileUsingGmailAuth
import domain.usecase.SignUpUseCase
import domain.usecases.GetGmailUserUseCase
import domain.usecases.GetUserFromDatabaseUseCase
import domain.usecases.InsertGmailUserUseCase
import domain.usecases.InsertUserUseCase
import presentation.viewModels.AuthenticationViewModelFactory

@Module
class PresentationModule {

    @Provides
    fun provideAuthenticationViewModelFactory(
        addUserToFireStoreUseCase: AddUserToFireStoreUseCase,
        deleteUserFromFirebaseUseCase: DeleteUserFromFirebaseUseCase,
        loginUseCase: LoginUseCase,
        reloadUserUseCase: ReloadUserUseCase,
        sendEmailVerificationLetterUseCase: SendEmailVerificationLetterUseCase,
        signOutWhileUsingEmailPasswordUseCase: SignOutWhileUsingEmailPasswordUseCase,
        signOutWhileUsingGmailAuth: SignOutWhileUsingGmailAuth,
        signUpUseCase: SignUpUseCase,
        oneTapClient: SignInClient,
        getFirebaseUserUseCase: GetFirebaseUserUseCase,
        insertUserUseCase: InsertUserUseCase,
        getUserNameFromFireStoreByEmail: GetUserNameFromFireStoreByEmail,
        @GmailSignIn signIn: BeginSignInRequest,
        @GmailSignUp signUp: BeginSignInRequest,
        gmailAuthUseCase: GmailAuthUseCase,
        insertGmailUserUseCase: InsertGmailUserUseCase,
        getGmailUserUseCase: GetGmailUserUseCase,
        getUserFromDatabaseUseCase: GetUserFromDatabaseUseCase,
        sendPasswordResetEmailUseCase: SendPasswordResetEmailUseCase,
        workManager: WorkManager
    ):AuthenticationViewModelFactory{
       return AuthenticationViewModelFactory(
           addUserToFireStoreUseCase,
           deleteUserFromFirebaseUseCase,
           loginUseCase,
           reloadUserUseCase,
           sendEmailVerificationLetterUseCase,
           signOutWhileUsingEmailPasswordUseCase,
           signOutWhileUsingGmailAuth,
           signUpUseCase,
           oneTapClient,
           getFirebaseUserUseCase,
           insertUserUseCase,
           getUserNameFromFireStoreByEmail,
           signIn,
           signUp,
           gmailAuthUseCase,
           insertGmailUserUseCase,
           getGmailUserUseCase,
           getUserFromDatabaseUseCase,
           sendPasswordResetEmailUseCase,
           workManager
       )
    }
}