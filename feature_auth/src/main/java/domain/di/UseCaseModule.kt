package domain.di
import auth_application.AuthScope
import dagger.Module
import dagger.Provides
import domain.models.user.GmailAuthorizationData
import domain.repository.AuthenticationRepository
import domain.usecase.AddUserToFireStoreUseCase
import domain.usecase.DeleteUserFromFirebaseUseCase
import domain.usecase.GetUserNameFromFireStoreByEmail
import domain.usecase.GetFirebaseUserUseCase
import domain.usecase.GmailAuthUseCase
import domain.usecase.IsUserExistUseCase
import domain.usecase.LoginUseCase
import domain.usecase.ReloadUserUseCase
import domain.usecase.SendEmailVerificationLetterUseCase
import domain.usecase.SendPasswordResetEmailUseCase
import domain.usecase.SignOutWhileUsingEmailPasswordUseCase
import domain.usecase.SignOutWhileUsingGmailAuth
import domain.usecase.SignUpUseCase

@Module
class UseCaseModule {

   @Provides
   @AuthScope
   fun provideAddUserToFireStoreUseCase(
       repository: AuthenticationRepository
   ):AddUserToFireStoreUseCase{
       return AddUserToFireStoreUseCase(
           repository
       )
   }

   @Provides
   @AuthScope
   fun deleteUserFromFirebaseUseCase(
       repository: AuthenticationRepository
   ):DeleteUserFromFirebaseUseCase{
       return DeleteUserFromFirebaseUseCase(
           repository
       )
   }


   @Provides
   @AuthScope
   fun provideLoginUseCase(
       repository: AuthenticationRepository
   ): LoginUseCase {
       return LoginUseCase(
           repository
       )
   }


   @Provides
   @AuthScope
   fun provideReloadUserUseCase(
       repository: AuthenticationRepository
   ):ReloadUserUseCase{
       return ReloadUserUseCase(
           repository
       )
   }


   @Provides
   @AuthScope
   fun provideSendEmailVerificationLetterUseCase(
       repository: AuthenticationRepository
   ): SendEmailVerificationLetterUseCase {
       return SendEmailVerificationLetterUseCase(
           repository
       )
   }

   @Provides
   @AuthScope
   fun provideSignOutWhileUsingEmailPasswordUseCase(
       repository: AuthenticationRepository
   ): SignOutWhileUsingEmailPasswordUseCase {
       return SignOutWhileUsingEmailPasswordUseCase(
           repository
       )
   }

   @Provides
   @AuthScope
   fun provideSignOutWhileUsingGmailAuth(
       repository: AuthenticationRepository
   ): SignOutWhileUsingGmailAuth {
       return SignOutWhileUsingGmailAuth(
           repository
       )
   }

   @Provides
   @AuthScope
   fun provideSignUpUseCase(
       repository: AuthenticationRepository
   ): SignUpUseCase {
       return SignUpUseCase(
           repository
       )

   }

    @Provides
    @AuthScope
    fun provideIsEmailVerifiedUseCase(
        repository: AuthenticationRepository
    ): GetFirebaseUserUseCase{
        return GetFirebaseUserUseCase(
            repository
        )
    }

    @Provides
    @AuthScope
    fun provideGetUserNameFromFireStoreByEmail(
        repository: AuthenticationRepository
    ): GetUserNameFromFireStoreByEmail{
        return GetUserNameFromFireStoreByEmail(
            repository
        )
    }

    @Provides
    @AuthScope
    fun provideGmailAuthUseCase(
        repository: AuthenticationRepository
    ): GmailAuthUseCase{
        return GmailAuthUseCase(
            repository
        )
    }

    @Provides
    @AuthScope
    fun provideSendPasswordResetEmailUseCase(
        repository: AuthenticationRepository
    ): SendPasswordResetEmailUseCase{
        return SendPasswordResetEmailUseCase(
            repository
        )
    }


    @Provides
    @AuthScope
    fun provideIsUserExistUseCase(
        repository: AuthenticationRepository
    ): IsUserExistUseCase{
        return IsUserExistUseCase(
            repository
        )
    }


}