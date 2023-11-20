package presentation.viewModels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001Bg\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u00a2\u0006\u0002\u0010\u001aJ\u001e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020.J\u0006\u00101\u001a\u00020,J\u0011\u00102\u001a\u000203H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00104J\u000e\u00105\u001a\u00020,2\u0006\u00106\u001a\u000207J\u0006\u00108\u001a\u00020,J\u0006\u00109\u001a\u00020,J\u0016\u0010:\u001a\u00020,2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020.J\u0006\u0010;\u001a\u00020,J\u0006\u0010\u000e\u001a\u00020,J\u0016\u0010<\u001a\u00020,2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020.R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020!8F\u00a2\u0006\u0006\u001a\u0004\b \u0010\"R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001d0&\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001f0&\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010(R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006="}, d2 = {"Lpresentation/viewModels/AuthenticationViewModel;", "Landroidx/lifecycle/ViewModel;", "addUserToFireStoreUseCase", "Ldomain/usecase/AddUserToFireStoreUseCase;", "deleteUserFromFirebaseUseCase", "Ldomain/usecase/DeleteUserFromFirebaseUseCase;", "loginUseCase", "Ldomain/usecase/LoginUseCase;", "reloadUserUseCase", "Ldomain/usecase/ReloadUserUseCase;", "sendEmailVerificationLetterUseCase", "Ldomain/usecase/SendEmailVerificationLetterUseCase;", "signOutWhileUsingEmailPasswordUseCase", "Ldomain/usecase/SignOutWhileUsingEmailPasswordUseCase;", "signOutWhileUsingGmailAuth", "Ldomain/usecase/SignOutWhileUsingGmailAuth;", "signUpUseCase", "Ldomain/usecase/SignUpUseCase;", "oneTapClient", "Lcom/google/android/gms/auth/api/identity/SignInClient;", "signInWithGmail", "Lcom/google/android/gms/auth/api/identity/BeginSignInRequest;", "isEmailVerifiedUseCase", "Ldomain/usecase/IsEmailVerifiedUseCase;", "insertUserUseCase", "Ldomain/usecases/InsertUserUseCase;", "(Ldomain/usecase/AddUserToFireStoreUseCase;Ldomain/usecase/DeleteUserFromFirebaseUseCase;Ldomain/usecase/LoginUseCase;Ldomain/usecase/ReloadUserUseCase;Ldomain/usecase/SendEmailVerificationLetterUseCase;Ldomain/usecase/SignOutWhileUsingEmailPasswordUseCase;Ldomain/usecase/SignOutWhileUsingGmailAuth;Ldomain/usecase/SignUpUseCase;Lcom/google/android/gms/auth/api/identity/SignInClient;Lcom/google/android/gms/auth/api/identity/BeginSignInRequest;Ldomain/usecase/IsEmailVerifiedUseCase;Ldomain/usecases/InsertUserUseCase;)V", "_signInState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldomain/event/SignInEvent;", "_signUpState", "Ldomain/event/SignUpEvent;", "isEmailVerified", "", "()Z", "getOneTapClient", "()Lcom/google/android/gms/auth/api/identity/SignInClient;", "signInState", "Lkotlinx/coroutines/flow/StateFlow;", "getSignInState", "()Lkotlinx/coroutines/flow/StateFlow;", "signUpState", "getSignUpState", "addUserToFireStore", "", "name", "", "email", "password", "deleteUserFromFirebase", "gmailSignIn", "Landroid/content/IntentSender;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertUser", "userEntity", "Ldata/models/UserEntity;", "reloadUser", "sendEmailVerification", "signIn", "signOutWhileUsingEmailPassword", "signUp", "feature_auth_debug"})
public final class AuthenticationViewModel extends androidx.lifecycle.ViewModel {
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
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<domain.event.SignUpEvent> _signUpState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<domain.event.SignUpEvent> signUpState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<domain.event.SignInEvent> _signInState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<domain.event.SignInEvent> signInState = null;
    
    @javax.inject.Inject
    public AuthenticationViewModel(@org.jetbrains.annotations.NotNull
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
    
    @org.jetbrains.annotations.NotNull
    public final com.google.android.gms.auth.api.identity.SignInClient getOneTapClient() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<domain.event.SignUpEvent> getSignUpState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<domain.event.SignInEvent> getSignInState() {
        return null;
    }
    
    public final boolean isEmailVerified() {
        return false;
    }
    
    public final void signUp(@org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String password) {
    }
    
    public final void signIn(@org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String password) {
    }
    
    public final void addUserToFireStore(@org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String password) {
    }
    
    public final void deleteUserFromFirebase() {
    }
    
    public final void reloadUser() {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object gmailSignIn(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super android.content.IntentSender> $completion) {
        return null;
    }
    
    public final void signOutWhileUsingEmailPassword() {
    }
    
    public final void signOutWhileUsingGmailAuth() {
    }
    
    public final void sendEmailVerification() {
    }
    
    public final void insertUser(@org.jetbrains.annotations.NotNull
    data.models.UserEntity userEntity) {
    }
}