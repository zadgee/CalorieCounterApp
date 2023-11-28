package presentation.di;

import androidx.work.WorkManager;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.SignInClient;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import domain.usecase.AddUserToFireStoreUseCase;
import domain.usecase.DeleteUserFromFirebaseUseCase;
import domain.usecase.GetFirebaseUserDataUseCase;
import domain.usecase.GetFirebaseUserUseCase;
import domain.usecase.GetUserNameFromFireStoreByEmail;
import domain.usecase.GmailAuthUseCase;
import domain.usecase.IsUserExistUseCase;
import domain.usecase.LoginUseCase;
import domain.usecase.ReloadUserUseCase;
import domain.usecase.SendEmailVerificationLetterUseCase;
import domain.usecase.SendPasswordResetEmailUseCase;
import domain.usecase.SignOutWhileUsingEmailPasswordUseCase;
import domain.usecase.SignOutWhileUsingGmailAuth;
import domain.usecase.SignUpUseCase;
import domain.usecases.InsertGmailUserUseCase;
import domain.usecases.InsertUserUseCase;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import presentation.viewModels.AuthenticationViewModelFactory;

@ScopeMetadata
@QualifierMetadata({
    "data.annotations.GmailSignIn",
    "data.annotations.GmailSignUp"
})
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class PresentationModule_ProvideAuthenticationViewModelFactoryFactory implements Factory<AuthenticationViewModelFactory> {
  private final PresentationModule module;

  private final Provider<AddUserToFireStoreUseCase> addUserToFireStoreUseCaseProvider;

  private final Provider<DeleteUserFromFirebaseUseCase> deleteUserFromFirebaseUseCaseProvider;

  private final Provider<LoginUseCase> loginUseCaseProvider;

  private final Provider<ReloadUserUseCase> reloadUserUseCaseProvider;

  private final Provider<SendEmailVerificationLetterUseCase> sendEmailVerificationLetterUseCaseProvider;

  private final Provider<SignOutWhileUsingEmailPasswordUseCase> signOutWhileUsingEmailPasswordUseCaseProvider;

  private final Provider<SignOutWhileUsingGmailAuth> signOutWhileUsingGmailAuthProvider;

  private final Provider<SignUpUseCase> signUpUseCaseProvider;

  private final Provider<SignInClient> oneTapClientProvider;

  private final Provider<GetFirebaseUserUseCase> getFirebaseUserUseCaseProvider;

  private final Provider<InsertUserUseCase> insertUserUseCaseProvider;

  private final Provider<GetUserNameFromFireStoreByEmail> getUserNameFromFireStoreByEmailProvider;

  private final Provider<BeginSignInRequest> signInProvider;

  private final Provider<BeginSignInRequest> signUpProvider;

  private final Provider<GmailAuthUseCase> gmailAuthUseCaseProvider;

  private final Provider<InsertGmailUserUseCase> insertGmailUserUseCaseProvider;

  private final Provider<SendPasswordResetEmailUseCase> sendPasswordResetEmailUseCaseProvider;

  private final Provider<WorkManager> workManagerProvider;

  private final Provider<GetFirebaseUserDataUseCase> getFirebaseUserDataUseCaseProvider;

  private final Provider<IsUserExistUseCase> isUserExistUseCaseProvider;

  public PresentationModule_ProvideAuthenticationViewModelFactoryFactory(PresentationModule module,
      Provider<AddUserToFireStoreUseCase> addUserToFireStoreUseCaseProvider,
      Provider<DeleteUserFromFirebaseUseCase> deleteUserFromFirebaseUseCaseProvider,
      Provider<LoginUseCase> loginUseCaseProvider,
      Provider<ReloadUserUseCase> reloadUserUseCaseProvider,
      Provider<SendEmailVerificationLetterUseCase> sendEmailVerificationLetterUseCaseProvider,
      Provider<SignOutWhileUsingEmailPasswordUseCase> signOutWhileUsingEmailPasswordUseCaseProvider,
      Provider<SignOutWhileUsingGmailAuth> signOutWhileUsingGmailAuthProvider,
      Provider<SignUpUseCase> signUpUseCaseProvider, Provider<SignInClient> oneTapClientProvider,
      Provider<GetFirebaseUserUseCase> getFirebaseUserUseCaseProvider,
      Provider<InsertUserUseCase> insertUserUseCaseProvider,
      Provider<GetUserNameFromFireStoreByEmail> getUserNameFromFireStoreByEmailProvider,
      Provider<BeginSignInRequest> signInProvider, Provider<BeginSignInRequest> signUpProvider,
      Provider<GmailAuthUseCase> gmailAuthUseCaseProvider,
      Provider<InsertGmailUserUseCase> insertGmailUserUseCaseProvider,
      Provider<SendPasswordResetEmailUseCase> sendPasswordResetEmailUseCaseProvider,
      Provider<WorkManager> workManagerProvider,
      Provider<GetFirebaseUserDataUseCase> getFirebaseUserDataUseCaseProvider,
      Provider<IsUserExistUseCase> isUserExistUseCaseProvider) {
    this.module = module;
    this.addUserToFireStoreUseCaseProvider = addUserToFireStoreUseCaseProvider;
    this.deleteUserFromFirebaseUseCaseProvider = deleteUserFromFirebaseUseCaseProvider;
    this.loginUseCaseProvider = loginUseCaseProvider;
    this.reloadUserUseCaseProvider = reloadUserUseCaseProvider;
    this.sendEmailVerificationLetterUseCaseProvider = sendEmailVerificationLetterUseCaseProvider;
    this.signOutWhileUsingEmailPasswordUseCaseProvider = signOutWhileUsingEmailPasswordUseCaseProvider;
    this.signOutWhileUsingGmailAuthProvider = signOutWhileUsingGmailAuthProvider;
    this.signUpUseCaseProvider = signUpUseCaseProvider;
    this.oneTapClientProvider = oneTapClientProvider;
    this.getFirebaseUserUseCaseProvider = getFirebaseUserUseCaseProvider;
    this.insertUserUseCaseProvider = insertUserUseCaseProvider;
    this.getUserNameFromFireStoreByEmailProvider = getUserNameFromFireStoreByEmailProvider;
    this.signInProvider = signInProvider;
    this.signUpProvider = signUpProvider;
    this.gmailAuthUseCaseProvider = gmailAuthUseCaseProvider;
    this.insertGmailUserUseCaseProvider = insertGmailUserUseCaseProvider;
    this.sendPasswordResetEmailUseCaseProvider = sendPasswordResetEmailUseCaseProvider;
    this.workManagerProvider = workManagerProvider;
    this.getFirebaseUserDataUseCaseProvider = getFirebaseUserDataUseCaseProvider;
    this.isUserExistUseCaseProvider = isUserExistUseCaseProvider;
  }

  @Override
  public AuthenticationViewModelFactory get() {
    return provideAuthenticationViewModelFactory(module, addUserToFireStoreUseCaseProvider.get(), deleteUserFromFirebaseUseCaseProvider.get(), loginUseCaseProvider.get(), reloadUserUseCaseProvider.get(), sendEmailVerificationLetterUseCaseProvider.get(), signOutWhileUsingEmailPasswordUseCaseProvider.get(), signOutWhileUsingGmailAuthProvider.get(), signUpUseCaseProvider.get(), oneTapClientProvider.get(), getFirebaseUserUseCaseProvider.get(), insertUserUseCaseProvider.get(), getUserNameFromFireStoreByEmailProvider.get(), signInProvider.get(), signUpProvider.get(), gmailAuthUseCaseProvider.get(), insertGmailUserUseCaseProvider.get(), sendPasswordResetEmailUseCaseProvider.get(), workManagerProvider.get(), getFirebaseUserDataUseCaseProvider.get(), isUserExistUseCaseProvider.get());
  }

  public static PresentationModule_ProvideAuthenticationViewModelFactoryFactory create(
      PresentationModule module,
      Provider<AddUserToFireStoreUseCase> addUserToFireStoreUseCaseProvider,
      Provider<DeleteUserFromFirebaseUseCase> deleteUserFromFirebaseUseCaseProvider,
      Provider<LoginUseCase> loginUseCaseProvider,
      Provider<ReloadUserUseCase> reloadUserUseCaseProvider,
      Provider<SendEmailVerificationLetterUseCase> sendEmailVerificationLetterUseCaseProvider,
      Provider<SignOutWhileUsingEmailPasswordUseCase> signOutWhileUsingEmailPasswordUseCaseProvider,
      Provider<SignOutWhileUsingGmailAuth> signOutWhileUsingGmailAuthProvider,
      Provider<SignUpUseCase> signUpUseCaseProvider, Provider<SignInClient> oneTapClientProvider,
      Provider<GetFirebaseUserUseCase> getFirebaseUserUseCaseProvider,
      Provider<InsertUserUseCase> insertUserUseCaseProvider,
      Provider<GetUserNameFromFireStoreByEmail> getUserNameFromFireStoreByEmailProvider,
      Provider<BeginSignInRequest> signInProvider, Provider<BeginSignInRequest> signUpProvider,
      Provider<GmailAuthUseCase> gmailAuthUseCaseProvider,
      Provider<InsertGmailUserUseCase> insertGmailUserUseCaseProvider,
      Provider<SendPasswordResetEmailUseCase> sendPasswordResetEmailUseCaseProvider,
      Provider<WorkManager> workManagerProvider,
      Provider<GetFirebaseUserDataUseCase> getFirebaseUserDataUseCaseProvider,
      Provider<IsUserExistUseCase> isUserExistUseCaseProvider) {
    return new PresentationModule_ProvideAuthenticationViewModelFactoryFactory(module, addUserToFireStoreUseCaseProvider, deleteUserFromFirebaseUseCaseProvider, loginUseCaseProvider, reloadUserUseCaseProvider, sendEmailVerificationLetterUseCaseProvider, signOutWhileUsingEmailPasswordUseCaseProvider, signOutWhileUsingGmailAuthProvider, signUpUseCaseProvider, oneTapClientProvider, getFirebaseUserUseCaseProvider, insertUserUseCaseProvider, getUserNameFromFireStoreByEmailProvider, signInProvider, signUpProvider, gmailAuthUseCaseProvider, insertGmailUserUseCaseProvider, sendPasswordResetEmailUseCaseProvider, workManagerProvider, getFirebaseUserDataUseCaseProvider, isUserExistUseCaseProvider);
  }

  public static AuthenticationViewModelFactory provideAuthenticationViewModelFactory(
      PresentationModule instance, AddUserToFireStoreUseCase addUserToFireStoreUseCase,
      DeleteUserFromFirebaseUseCase deleteUserFromFirebaseUseCase, LoginUseCase loginUseCase,
      ReloadUserUseCase reloadUserUseCase,
      SendEmailVerificationLetterUseCase sendEmailVerificationLetterUseCase,
      SignOutWhileUsingEmailPasswordUseCase signOutWhileUsingEmailPasswordUseCase,
      SignOutWhileUsingGmailAuth signOutWhileUsingGmailAuth, SignUpUseCase signUpUseCase,
      SignInClient oneTapClient, GetFirebaseUserUseCase getFirebaseUserUseCase,
      InsertUserUseCase insertUserUseCase,
      GetUserNameFromFireStoreByEmail getUserNameFromFireStoreByEmail, BeginSignInRequest signIn,
      BeginSignInRequest signUp, GmailAuthUseCase gmailAuthUseCase,
      InsertGmailUserUseCase insertGmailUserUseCase,
      SendPasswordResetEmailUseCase sendPasswordResetEmailUseCase, WorkManager workManager,
      GetFirebaseUserDataUseCase getFirebaseUserDataUseCase,
      IsUserExistUseCase isUserExistUseCase) {
    return Preconditions.checkNotNullFromProvides(instance.provideAuthenticationViewModelFactory(addUserToFireStoreUseCase, deleteUserFromFirebaseUseCase, loginUseCase, reloadUserUseCase, sendEmailVerificationLetterUseCase, signOutWhileUsingEmailPasswordUseCase, signOutWhileUsingGmailAuth, signUpUseCase, oneTapClient, getFirebaseUserUseCase, insertUserUseCase, getUserNameFromFireStoreByEmail, signIn, signUp, gmailAuthUseCase, insertGmailUserUseCase, sendPasswordResetEmailUseCase, workManager, getFirebaseUserDataUseCase, isUserExistUseCase));
  }
}
