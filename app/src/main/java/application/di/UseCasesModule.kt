package application.di
import app.DatabaseComponent
import dagger.Module
import dagger.Provides
import domain.di.AuthComponent
import domain.usecases.AddUserToFireStoreUseCase
import domain.usecases.DeleteGmailUserFromDBUseCase
import domain.usecases.DeleteUserFromDBUseCase
import domain.usecases.DeleteUserFromFirebaseUseCase
import domain.usecases.GetAuthCredentialUseCase
import domain.usecases.GetFirebaseUserDataUseCase
import domain.usecases.GetFirebaseUserUseCase
import domain.usecases.GetGmailUserUseCase
import domain.usecases.GetUserFromDatabaseUseCase
import domain.usecases.GetUserNameFromFireStoreByEmail
import domain.usecases.GmailAuthUseCase
import domain.usecases.GmailSignInUseCase
import domain.usecases.GmailSignUpUseCase
import domain.usecases.InsertGmailUserUseCase
import domain.usecases.InsertUserUseCase
import domain.usecases.LoginUseCase
import domain.usecases.ReloadUserUseCase
import domain.usecases.SendEmailVerificationLetterUseCase
import domain.usecases.SendPasswordResetEmailUseCase
import domain.usecases.SignOutWhileUsingEmailPasswordUseCase
import domain.usecases.SignOutWhileUsingGmailAuth
import domain.usecases.SignUpUseCase
import glue.email_verification.di.EmailVerificationComponent
import glue.forgot_password.di.ForgotPasswordComponent
import glue.sign_in.di.SignInComponent
import glue.sign_up.di.SignUpComponent

@Module(
    subcomponents = [
        SignUpComponent::class,
        SignInComponent::class,
        EmailVerificationComponent::class,
        ForgotPasswordComponent::class
    ]
)
class UseCasesModule(
    private val authComponent: AuthComponent,
    private val databaseComponent:DatabaseComponent
) {

    @Provides
    @BinaryUseCases
        fun provideSendEmailVerificationLetterUseCase(): SendEmailVerificationLetterUseCase {
        return SendEmailVerificationLetterUseCase(
            authComponent.getAuthRepository()
        )
    }


    @Provides
    @BinaryUseCases
    fun provideLoginUseCase(): LoginUseCase {
        return LoginUseCase(
            authComponent.getAuthRepository()
        )
    }

    @Provides
    @BinaryUseCases
    fun provideSignUpUseCase(): SignUpUseCase {
        return SignUpUseCase(
            authComponent.getAuthRepository()
        )
    }

    @Provides
    @BinaryUseCases
    fun provideAddUserToFireStoreUseCase(): AddUserToFireStoreUseCase {
        return AddUserToFireStoreUseCase(
            authComponent.getAuthRepository()
        )
    }

    @Provides
    @BinaryUseCases
    fun deleteUserFromFirebaseUseCase(): DeleteUserFromFirebaseUseCase {
        return DeleteUserFromFirebaseUseCase(
            authComponent.getAuthRepository()
        )
    }

    @Provides
    @BinaryUseCases
    fun provideReloadUserUseCase(): ReloadUserUseCase {
        return ReloadUserUseCase(
            authComponent.getAuthRepository()
        )
     }

    @Provides
    @BinaryUseCases
    fun provideGetFirebaseUserDataUseCase(): GetFirebaseUserDataUseCase {
        return GetFirebaseUserDataUseCase(
            authComponent.getAuthRepository()
        )
    }

    @Provides
    @BinaryUseCases
    fun provideSignOutWhileUsingEmailPasswordUseCase(): SignOutWhileUsingEmailPasswordUseCase {
        return SignOutWhileUsingEmailPasswordUseCase(
            authComponent.getAuthRepository()
        )
    }

    @Provides
    @BinaryUseCases
    fun provideSignOutWhileUsingGmailAuth(): SignOutWhileUsingGmailAuth {
        return SignOutWhileUsingGmailAuth(
            authComponent.getAuthRepository()
        )
    }

    @Provides
    @BinaryUseCases
    fun provideGetUserNameFromFireStoreByEmail(): GetUserNameFromFireStoreByEmail {
        return GetUserNameFromFireStoreByEmail(
            authComponent.getAuthRepository()
        )
    }

    @Provides
    @BinaryUseCases
    fun provideSendPasswordResetEmailUseCase(): SendPasswordResetEmailUseCase {
        return SendPasswordResetEmailUseCase(
            authComponent.getAuthRepository()
        )
    }

    @Provides
    @BinaryUseCases
    fun provideGmailSignInUseCase(): GmailSignInUseCase {
        return GmailSignInUseCase(
            authComponent.getAuthRepository()
        )
    }

    @Provides
    @BinaryUseCases
    fun provideGetAuthCredUseCase(): GetAuthCredentialUseCase {
        return GetAuthCredentialUseCase(
            authComponent.getAuthRepository()
        )
    }

    @Provides
    @BinaryUseCases
    fun provideGmailSignUpUseCase(): GmailSignUpUseCase {
        return GmailSignUpUseCase(
            authComponent.getAuthRepository()
        )
    }

    @Provides
    @ApplicationScope
    fun provideGetUserFromUserFromDataBaseUseCase(): GetUserFromDatabaseUseCase {
        return GetUserFromDatabaseUseCase(
            databaseComponent.getRepo()
        )
    }

    @Provides
    @BinaryUseCases
    fun provideInsertUserUseCase(): InsertUserUseCase {
        return InsertUserUseCase(
            databaseComponent.getRepo()
        )
    }

    @Provides
    @BinaryUseCases
    fun provideInsertGmailUserUseCase(): InsertGmailUserUseCase {
        return InsertGmailUserUseCase(
            databaseComponent.getRepo()
        )
    }

    @Provides
    @ApplicationScope
    fun provideGetGmailUserUseCase(): GetGmailUserUseCase {
        return GetGmailUserUseCase(
            databaseComponent.getRepo()
        )
    }

    @Provides
    @BinaryUseCases
    fun provideGmailAuthUseCase(
        getAuthCredentialUseCase: GetAuthCredentialUseCase
    ): GmailAuthUseCase {
        return GmailAuthUseCase(
            repository = authComponent.getAuthRepository(),
            getAuthCredentialUseCase = getAuthCredentialUseCase
        )
    }

    @Provides
    @BinaryUseCases
    fun provideGetFirebaseUserUseCase(): GetFirebaseUserUseCase {
        return GetFirebaseUserUseCase(
             repository = authComponent.getAuthRepository(),
             reloadUserUseCase = authComponent.getReloadUserUseCase()
        )
    }

    @Provides
    @BinaryUseCases
    fun provideDeleteUserFromDBUseCase():DeleteUserFromDBUseCase{
        return DeleteUserFromDBUseCase(
            userDataSource = databaseComponent.getRepo()
        )
    }

    @Provides
    @BinaryUseCases
    fun provideDeleteGmailUserFromDBUseCase():DeleteGmailUserFromDBUseCase{
        return DeleteGmailUserFromDBUseCase(
            userDataSource = databaseComponent.getRepo()
        )
    }
}