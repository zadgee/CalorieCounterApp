package presentation.viewModels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001Bg\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u00a2\u0006\u0002\u0010\u001aJ%\u0010\u001b\u001a\u0002H\u001c\"\b\b\u0000\u0010\u001c*\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001fH\u0016\u00a2\u0006\u0002\u0010 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lpresentation/viewModels/AuthenticationViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "addUserToFireStoreUseCase", "Ldomain/usecase/AddUserToFireStoreUseCase;", "deleteUserFromFirebaseUseCase", "Ldomain/usecase/DeleteUserFromFirebaseUseCase;", "loginUseCase", "Ldomain/usecase/LoginUseCase;", "reloadUserUseCase", "Ldomain/usecase/ReloadUserUseCase;", "sendEmailVerificationLetterUseCase", "Ldomain/usecase/SendEmailVerificationLetterUseCase;", "signOutWhileUsingEmailPasswordUseCase", "Ldomain/usecase/SignOutWhileUsingEmailPasswordUseCase;", "signOutWhileUsingGmailAuth", "Ldomain/usecase/SignOutWhileUsingGmailAuth;", "signUpUseCase", "Ldomain/usecase/SignUpUseCase;", "oneTapClient", "Lcom/google/android/gms/auth/api/identity/SignInClient;", "signInWithGmail", "Lcom/google/android/gms/auth/api/identity/BeginSignInRequest;", "isEmailVerifiedUseCase", "Ldomain/usecase/IsEmailVerifiedUseCase;", "insertUserUseCase", "Ldomain/usecases/InsertUserUseCase;", "(Ldomain/usecase/AddUserToFireStoreUseCase;Ldomain/usecase/DeleteUserFromFirebaseUseCase;Ldomain/usecase/LoginUseCase;Ldomain/usecase/ReloadUserUseCase;Ldomain/usecase/SendEmailVerificationLetterUseCase;Ldomain/usecase/SignOutWhileUsingEmailPasswordUseCase;Ldomain/usecase/SignOutWhileUsingGmailAuth;Ldomain/usecase/SignUpUseCase;Lcom/google/android/gms/auth/api/identity/SignInClient;Lcom/google/android/gms/auth/api/identity/BeginSignInRequest;Ldomain/usecase/IsEmailVerifiedUseCase;Ldomain/usecases/InsertUserUseCase;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "feature_auth_debug"})
public final class AuthenticationViewModelFactory implements androidx.lifecycle.ViewModelProvider.Factory {
    @org.jetbrains.annotations.NotNull
    private final domain.usecase.AddUserToFireStoreUseCase addUserToFireStoreUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final domain.usecase.DeleteUserFromFirebaseUseCase deleteUserFromFirebaseUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final domain.usecase.LoginUseCase loginUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final domain.usecase.ReloadUserUseCase reloadUserUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final domain.usecase.SendEmailVerificationLetterUseCase sendEmailVerificationLetterUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final domain.usecase.SignOutWhileUsingEmailPasswordUseCase signOutWhileUsingEmailPasswordUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final domain.usecase.SignOutWhileUsingGmailAuth signOutWhileUsingGmailAuth = null;
    @org.jetbrains.annotations.NotNull
    private final domain.usecase.SignUpUseCase signUpUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final com.google.android.gms.auth.api.identity.SignInClient oneTapClient = null;
    @org.jetbrains.annotations.NotNull
    private final com.google.android.gms.auth.api.identity.BeginSignInRequest signInWithGmail = null;
    @org.jetbrains.annotations.NotNull
    private final domain.usecase.IsEmailVerifiedUseCase isEmailVerifiedUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final domain.usecases.InsertUserUseCase insertUserUseCase = null;
    
    @javax.inject.Inject
    public AuthenticationViewModelFactory(@org.jetbrains.annotations.NotNull
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
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public <T extends androidx.lifecycle.ViewModel>T create(@org.jetbrains.annotations.NotNull
    java.lang.Class<T> modelClass) {
        return null;
    }
}