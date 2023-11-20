package presentation.di;

@dagger.Module(subcomponents = {app.DatabaseSubComponent.class}, includes = {data.di.AuthModule.class, domain.di.UseCaseModule.class})
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002Jh\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007\u00a8\u0006\u001d"}, d2 = {"Lpresentation/di/PresentationModule;", "", "()V", "provideAuthenticationViewModelFactory", "Lpresentation/viewModels/AuthenticationViewModelFactory;", "addUserToFireStoreUseCase", "Ldomain/usecase/AddUserToFireStoreUseCase;", "deleteUserFromFirebaseUseCase", "Ldomain/usecase/DeleteUserFromFirebaseUseCase;", "loginUseCase", "Ldomain/usecase/LoginUseCase;", "reloadUserUseCase", "Ldomain/usecase/ReloadUserUseCase;", "sendEmailVerificationLetterUseCase", "Ldomain/usecase/SendEmailVerificationLetterUseCase;", "signOutWhileUsingEmailPasswordUseCase", "Ldomain/usecase/SignOutWhileUsingEmailPasswordUseCase;", "signOutWhileUsingGmailAuth", "Ldomain/usecase/SignOutWhileUsingGmailAuth;", "signUpUseCase", "Ldomain/usecase/SignUpUseCase;", "oneTapClient", "Lcom/google/android/gms/auth/api/identity/SignInClient;", "signInWithGmail", "Lcom/google/android/gms/auth/api/identity/BeginSignInRequest;", "isEmailVerifiedUseCase", "Ldomain/usecase/IsEmailVerifiedUseCase;", "insertUserUseCase", "Ldomain/usecases/InsertUserUseCase;", "feature_auth_debug"})
public final class PresentationModule {
    
    public PresentationModule() {
        super();
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final presentation.viewModels.AuthenticationViewModelFactory provideAuthenticationViewModelFactory(@org.jetbrains.annotations.NotNull
    domain.usecase.AddUserToFireStoreUseCase addUserToFireStoreUseCase, @org.jetbrains.annotations.NotNull
    domain.usecase.DeleteUserFromFirebaseUseCase deleteUserFromFirebaseUseCase, @org.jetbrains.annotations.NotNull
    domain.usecase.LoginUseCase loginUseCase, @org.jetbrains.annotations.NotNull
    domain.usecase.ReloadUserUseCase reloadUserUseCase, @org.jetbrains.annotations.NotNull
    domain.usecase.SendEmailVerificationLetterUseCase sendEmailVerificationLetterUseCase, @org.jetbrains.annotations.NotNull
    domain.usecase.SignOutWhileUsingEmailPasswordUseCase signOutWhileUsingEmailPasswordUseCase, @org.jetbrains.annotations.NotNull
    domain.usecase.SignOutWhileUsingGmailAuth signOutWhileUsingGmailAuth, @org.jetbrains.annotations.NotNull
    domain.usecase.SignUpUseCase signUpUseCase, @org.jetbrains.annotations.NotNull
    com.google.android.gms.auth.api.identity.SignInClient oneTapClient, @org.jetbrains.annotations.NotNull
    com.google.android.gms.auth.api.identity.BeginSignInRequest signInWithGmail, @org.jetbrains.annotations.NotNull
    domain.usecase.IsEmailVerifiedUseCase isEmailVerifiedUseCase, @org.jetbrains.annotations.NotNull
    domain.usecases.InsertUserUseCase insertUserUseCase) {
        return null;
    }
}