package auth_application;

import androidx.work.WorkManager;
import app.DatabaseComponent;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import data.di.AuthModule;
import data.di.AuthModule_ProvideAuthenticationRepositoryFactory;
import data.di.AuthModule_ProvideFirebaseAuthFactory;
import data.di.AuthModule_ProvideFirebaseStoreFactory;
import data.di.AuthModule_ProvideOneTapClientFactory;
import data.di.AuthModule_ProvideSignInRequestFactory;
import data.di.AuthModule_ProvideSignUpRequestFactory;
import domain.di.UseCaseModule;
import domain.di.UseCaseModule_DeleteUserFromFirebaseUseCaseFactory;
import domain.di.UseCaseModule_ProvideAddUserToFireStoreUseCaseFactory;
import domain.di.UseCaseModule_ProvideGetUserNameFromFireStoreByEmailFactory;
import domain.di.UseCaseModule_ProvideGmailAuthUseCaseFactory;
import domain.di.UseCaseModule_ProvideIsEmailVerifiedUseCaseFactory;
import domain.di.UseCaseModule_ProvideIsUserExistUseCaseFactory;
import domain.di.UseCaseModule_ProvideLoginUseCaseFactory;
import domain.di.UseCaseModule_ProvideReloadUserUseCaseFactory;
import domain.di.UseCaseModule_ProvideSendEmailVerificationLetterUseCaseFactory;
import domain.di.UseCaseModule_ProvideSendPasswordResetEmailUseCaseFactory;
import domain.di.UseCaseModule_ProvideSignOutWhileUsingEmailPasswordUseCaseFactory;
import domain.di.UseCaseModule_ProvideSignOutWhileUsingGmailAuthFactory;
import domain.di.UseCaseModule_ProvideSignUpUseCaseFactory;
import domain.di.WorkerModule;
import domain.di.WorkerModule_ProvideWorkManagerInstanceFactory;
import domain.repository.AuthenticationRepository;
import domain.repository.UserDataSource;
import domain.usecase.AddUserToFireStoreUseCase;
import domain.usecase.DeleteUserFromFirebaseUseCase;
import domain.usecase.GetFirebaseUserDataUseCase;
import domain.usecase.GetFirebaseUserDataUseCase_Factory;
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
import domain.usecases.InsertGmailUserUseCase_Factory;
import domain.usecases.InsertUserUseCase;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import presentation.auth_fragments.EmailVerificationFragment;
import presentation.auth_fragments.EmailVerificationFragment_MembersInjector;
import presentation.auth_fragments.ForgotPasswordFragment;
import presentation.auth_fragments.ForgotPasswordFragment_MembersInjector;
import presentation.auth_fragments.SignInFragment;
import presentation.auth_fragments.SignInFragment_MembersInjector;
import presentation.auth_fragments.SignUpFragment;
import presentation.auth_fragments.SignUpFragment_MembersInjector;
import presentation.di.PresentationModule;
import presentation.di.PresentationModule_ProvideAuthenticationViewModelFactoryFactory;
import presentation.viewModels.AuthenticationViewModelFactory;

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
public final class DaggerAuthComponent {
  private DaggerAuthComponent() {
  }

  public static AuthComponent.Builder builder() {
    return new Builder();
  }

  private static final class Builder implements AuthComponent.Builder {
    private AuthModule authModule;

    private UseCaseModule useCaseModule;

    private WorkerModule workerModule;

    private DatabaseComponent databaseComponent;

    @Override
    public Builder authModule(AuthModule authModule) {
      this.authModule = Preconditions.checkNotNull(authModule);
      return this;
    }

    @Override
    public Builder useCaseModule(UseCaseModule useCaseModule) {
      this.useCaseModule = Preconditions.checkNotNull(useCaseModule);
      return this;
    }

    @Override
    public Builder workerModule(WorkerModule workerModule) {
      this.workerModule = Preconditions.checkNotNull(workerModule);
      return this;
    }

    @Override
    public Builder databaseComponent(DatabaseComponent databaseComponent) {
      this.databaseComponent = Preconditions.checkNotNull(databaseComponent);
      return this;
    }

    @Override
    public AuthComponent buildAuthComponent() {
      Preconditions.checkBuilderRequirement(authModule, AuthModule.class);
      if (useCaseModule == null) {
        this.useCaseModule = new UseCaseModule();
      }
      Preconditions.checkBuilderRequirement(workerModule, WorkerModule.class);
      Preconditions.checkBuilderRequirement(databaseComponent, DatabaseComponent.class);
      return new AuthComponentImpl(authModule, useCaseModule, new PresentationModule(), workerModule, databaseComponent);
    }
  }

  private static final class AuthComponentImpl implements AuthComponent {
    private final PresentationModule presentationModule;

    private final DatabaseComponent databaseComponent;

    private final WorkerModule workerModule;

    private final AuthComponentImpl authComponentImpl = this;

    private Provider<FirebaseAuth> provideFirebaseAuthProvider;

    private Provider<FirebaseFirestore> provideFirebaseStoreProvider;

    private Provider<SignInClient> provideOneTapClientProvider;

    private Provider<AuthenticationRepository> provideAuthenticationRepositoryProvider;

    private Provider<AddUserToFireStoreUseCase> provideAddUserToFireStoreUseCaseProvider;

    private Provider<DeleteUserFromFirebaseUseCase> deleteUserFromFirebaseUseCaseProvider;

    private Provider<LoginUseCase> provideLoginUseCaseProvider;

    private Provider<ReloadUserUseCase> provideReloadUserUseCaseProvider;

    private Provider<SendEmailVerificationLetterUseCase> provideSendEmailVerificationLetterUseCaseProvider;

    private Provider<SignOutWhileUsingEmailPasswordUseCase> provideSignOutWhileUsingEmailPasswordUseCaseProvider;

    private Provider<SignOutWhileUsingGmailAuth> provideSignOutWhileUsingGmailAuthProvider;

    private Provider<SignUpUseCase> provideSignUpUseCaseProvider;

    private Provider<GetFirebaseUserUseCase> provideIsEmailVerifiedUseCaseProvider;

    private Provider<GetUserNameFromFireStoreByEmail> provideGetUserNameFromFireStoreByEmailProvider;

    private Provider<BeginSignInRequest> provideSignInRequestProvider;

    private Provider<BeginSignInRequest> provideSignUpRequestProvider;

    private Provider<GmailAuthUseCase> provideGmailAuthUseCaseProvider;

    private Provider<SendPasswordResetEmailUseCase> provideSendPasswordResetEmailUseCaseProvider;

    private Provider<IsUserExistUseCase> provideIsUserExistUseCaseProvider;

    private Provider<InsertUserUseCase> provideInsertUseCaseProvider;

    private Provider<UserDataSource> provideUserDataSourceProvider;

    private Provider<InsertGmailUserUseCase> insertGmailUserUseCaseProvider;

    private Provider<WorkManager> provideWorkManagerInstanceProvider;

    private Provider<GetFirebaseUserDataUseCase> getFirebaseUserDataUseCaseProvider;

    private Provider<AuthenticationViewModelFactory> provideAuthenticationViewModelFactoryProvider;

    private AuthComponentImpl(AuthModule authModuleParam, UseCaseModule useCaseModuleParam,
        PresentationModule presentationModuleParam, WorkerModule workerModuleParam,
        DatabaseComponent databaseComponentParam) {
      this.presentationModule = presentationModuleParam;
      this.databaseComponent = databaseComponentParam;
      this.workerModule = workerModuleParam;
      initialize(authModuleParam, useCaseModuleParam, presentationModuleParam, workerModuleParam, databaseComponentParam);

    }

    private InsertGmailUserUseCase insertGmailUserUseCase() {
      return new InsertGmailUserUseCase(Preconditions.checkNotNullFromComponent(databaseComponent.provideUserDataSource()));
    }

    private GetFirebaseUserDataUseCase getFirebaseUserDataUseCase() {
      return new GetFirebaseUserDataUseCase(provideAuthenticationRepositoryProvider.get());
    }

    private AuthenticationViewModelFactory authenticationViewModelFactory() {
      return PresentationModule_ProvideAuthenticationViewModelFactoryFactory.provideAuthenticationViewModelFactory(presentationModule, provideAddUserToFireStoreUseCaseProvider.get(), deleteUserFromFirebaseUseCaseProvider.get(), provideLoginUseCaseProvider.get(), provideReloadUserUseCaseProvider.get(), provideSendEmailVerificationLetterUseCaseProvider.get(), provideSignOutWhileUsingEmailPasswordUseCaseProvider.get(), provideSignOutWhileUsingGmailAuthProvider.get(), provideSignUpUseCaseProvider.get(), provideOneTapClientProvider.get(), provideIsEmailVerifiedUseCaseProvider.get(), Preconditions.checkNotNullFromComponent(databaseComponent.provideInsertUseCase()), provideGetUserNameFromFireStoreByEmailProvider.get(), provideSignInRequestProvider.get(), provideSignUpRequestProvider.get(), provideGmailAuthUseCaseProvider.get(), insertGmailUserUseCase(), provideSendPasswordResetEmailUseCaseProvider.get(), WorkerModule_ProvideWorkManagerInstanceFactory.provideWorkManagerInstance(workerModule), getFirebaseUserDataUseCase(), provideIsUserExistUseCaseProvider.get());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final AuthModule authModuleParam,
        final UseCaseModule useCaseModuleParam, final PresentationModule presentationModuleParam,
        final WorkerModule workerModuleParam, final DatabaseComponent databaseComponentParam) {
      this.provideFirebaseAuthProvider = DoubleCheck.provider(AuthModule_ProvideFirebaseAuthFactory.create(authModuleParam));
      this.provideFirebaseStoreProvider = DoubleCheck.provider(AuthModule_ProvideFirebaseStoreFactory.create(authModuleParam));
      this.provideOneTapClientProvider = DoubleCheck.provider(AuthModule_ProvideOneTapClientFactory.create(authModuleParam));
      this.provideAuthenticationRepositoryProvider = DoubleCheck.provider(AuthModule_ProvideAuthenticationRepositoryFactory.create(authModuleParam, provideFirebaseAuthProvider, provideFirebaseStoreProvider, provideOneTapClientProvider));
      this.provideAddUserToFireStoreUseCaseProvider = DoubleCheck.provider(UseCaseModule_ProvideAddUserToFireStoreUseCaseFactory.create(useCaseModuleParam, provideAuthenticationRepositoryProvider));
      this.deleteUserFromFirebaseUseCaseProvider = DoubleCheck.provider(UseCaseModule_DeleteUserFromFirebaseUseCaseFactory.create(useCaseModuleParam, provideAuthenticationRepositoryProvider));
      this.provideLoginUseCaseProvider = DoubleCheck.provider(UseCaseModule_ProvideLoginUseCaseFactory.create(useCaseModuleParam, provideAuthenticationRepositoryProvider));
      this.provideReloadUserUseCaseProvider = DoubleCheck.provider(UseCaseModule_ProvideReloadUserUseCaseFactory.create(useCaseModuleParam, provideAuthenticationRepositoryProvider));
      this.provideSendEmailVerificationLetterUseCaseProvider = DoubleCheck.provider(UseCaseModule_ProvideSendEmailVerificationLetterUseCaseFactory.create(useCaseModuleParam, provideAuthenticationRepositoryProvider));
      this.provideSignOutWhileUsingEmailPasswordUseCaseProvider = DoubleCheck.provider(UseCaseModule_ProvideSignOutWhileUsingEmailPasswordUseCaseFactory.create(useCaseModuleParam, provideAuthenticationRepositoryProvider));
      this.provideSignOutWhileUsingGmailAuthProvider = DoubleCheck.provider(UseCaseModule_ProvideSignOutWhileUsingGmailAuthFactory.create(useCaseModuleParam, provideAuthenticationRepositoryProvider));
      this.provideSignUpUseCaseProvider = DoubleCheck.provider(UseCaseModule_ProvideSignUpUseCaseFactory.create(useCaseModuleParam, provideAuthenticationRepositoryProvider));
      this.provideIsEmailVerifiedUseCaseProvider = DoubleCheck.provider(UseCaseModule_ProvideIsEmailVerifiedUseCaseFactory.create(useCaseModuleParam, provideAuthenticationRepositoryProvider));
      this.provideGetUserNameFromFireStoreByEmailProvider = DoubleCheck.provider(UseCaseModule_ProvideGetUserNameFromFireStoreByEmailFactory.create(useCaseModuleParam, provideAuthenticationRepositoryProvider));
      this.provideSignInRequestProvider = DoubleCheck.provider(AuthModule_ProvideSignInRequestFactory.create(authModuleParam));
      this.provideSignUpRequestProvider = DoubleCheck.provider(AuthModule_ProvideSignUpRequestFactory.create(authModuleParam));
      this.provideGmailAuthUseCaseProvider = DoubleCheck.provider(UseCaseModule_ProvideGmailAuthUseCaseFactory.create(useCaseModuleParam, provideAuthenticationRepositoryProvider));
      this.provideSendPasswordResetEmailUseCaseProvider = DoubleCheck.provider(UseCaseModule_ProvideSendPasswordResetEmailUseCaseFactory.create(useCaseModuleParam, provideAuthenticationRepositoryProvider));
      this.provideIsUserExistUseCaseProvider = DoubleCheck.provider(UseCaseModule_ProvideIsUserExistUseCaseFactory.create(useCaseModuleParam, provideAuthenticationRepositoryProvider));
      this.provideInsertUseCaseProvider = new ProvideInsertUseCaseProvider(databaseComponentParam);
      this.provideUserDataSourceProvider = new ProvideUserDataSourceProvider(databaseComponentParam);
      this.insertGmailUserUseCaseProvider = InsertGmailUserUseCase_Factory.create(provideUserDataSourceProvider);
      this.provideWorkManagerInstanceProvider = WorkerModule_ProvideWorkManagerInstanceFactory.create(workerModuleParam);
      this.getFirebaseUserDataUseCaseProvider = GetFirebaseUserDataUseCase_Factory.create(provideAuthenticationRepositoryProvider);
      this.provideAuthenticationViewModelFactoryProvider = PresentationModule_ProvideAuthenticationViewModelFactoryFactory.create(presentationModuleParam, provideAddUserToFireStoreUseCaseProvider, deleteUserFromFirebaseUseCaseProvider, provideLoginUseCaseProvider, provideReloadUserUseCaseProvider, provideSendEmailVerificationLetterUseCaseProvider, provideSignOutWhileUsingEmailPasswordUseCaseProvider, provideSignOutWhileUsingGmailAuthProvider, provideSignUpUseCaseProvider, provideOneTapClientProvider, provideIsEmailVerifiedUseCaseProvider, provideInsertUseCaseProvider, provideGetUserNameFromFireStoreByEmailProvider, provideSignInRequestProvider, provideSignUpRequestProvider, provideGmailAuthUseCaseProvider, insertGmailUserUseCaseProvider, provideSendPasswordResetEmailUseCaseProvider, provideWorkManagerInstanceProvider, getFirebaseUserDataUseCaseProvider, provideIsUserExistUseCaseProvider);
    }

    @Override
    public void injectSignUpFragment(SignUpFragment fragment) {
      injectSignUpFragment2(fragment);
    }

    @Override
    public void injectSignInFragment(SignInFragment fragment) {
      injectSignInFragment2(fragment);
    }

    @Override
    public void injectEmailVerificationFragment(EmailVerificationFragment fragment) {
      injectEmailVerificationFragment2(fragment);
    }

    @Override
    public void injectForgotPasswordFragment(ForgotPasswordFragment fragment) {
      injectForgotPasswordFragment2(fragment);
    }

    @CanIgnoreReturnValue
    private SignUpFragment injectSignUpFragment2(SignUpFragment instance) {
      SignUpFragment_MembersInjector.injectViewModelFactory(instance, authenticationViewModelFactory());
      return instance;
    }

    @CanIgnoreReturnValue
    private SignInFragment injectSignInFragment2(SignInFragment instance) {
      SignInFragment_MembersInjector.injectViewModelFactory(instance, authenticationViewModelFactory());
      return instance;
    }

    @CanIgnoreReturnValue
    private EmailVerificationFragment injectEmailVerificationFragment2(
        EmailVerificationFragment instance) {
      EmailVerificationFragment_MembersInjector.injectViewModelFactory(instance, DoubleCheck.lazy(provideAuthenticationViewModelFactoryProvider));
      return instance;
    }

    @CanIgnoreReturnValue
    private ForgotPasswordFragment injectForgotPasswordFragment2(ForgotPasswordFragment instance) {
      ForgotPasswordFragment_MembersInjector.injectViewModelFactory(instance, authenticationViewModelFactory());
      return instance;
    }

    private static final class ProvideInsertUseCaseProvider implements Provider<InsertUserUseCase> {
      private final DatabaseComponent databaseComponent;

      ProvideInsertUseCaseProvider(DatabaseComponent databaseComponent) {
        this.databaseComponent = databaseComponent;
      }

      @Override
      public InsertUserUseCase get() {
        return Preconditions.checkNotNullFromComponent(databaseComponent.provideInsertUseCase());
      }
    }

    private static final class ProvideUserDataSourceProvider implements Provider<UserDataSource> {
      private final DatabaseComponent databaseComponent;

      ProvideUserDataSourceProvider(DatabaseComponent databaseComponent) {
        this.databaseComponent = databaseComponent;
      }

      @Override
      public UserDataSource get() {
        return Preconditions.checkNotNullFromComponent(databaseComponent.provideUserDataSource());
      }
    }
  }
}
