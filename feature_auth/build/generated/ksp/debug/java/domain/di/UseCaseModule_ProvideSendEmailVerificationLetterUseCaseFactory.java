package domain.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import domain.repository.AuthenticationRepository;
import domain.usecase.SendEmailVerificationLetterUseCase;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("auth_application.AuthScope")
@QualifierMetadata
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
public final class UseCaseModule_ProvideSendEmailVerificationLetterUseCaseFactory implements Factory<SendEmailVerificationLetterUseCase> {
  private final UseCaseModule module;

  private final Provider<AuthenticationRepository> repositoryProvider;

  public UseCaseModule_ProvideSendEmailVerificationLetterUseCaseFactory(UseCaseModule module,
      Provider<AuthenticationRepository> repositoryProvider) {
    this.module = module;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public SendEmailVerificationLetterUseCase get() {
    return provideSendEmailVerificationLetterUseCase(module, repositoryProvider.get());
  }

  public static UseCaseModule_ProvideSendEmailVerificationLetterUseCaseFactory create(
      UseCaseModule module, Provider<AuthenticationRepository> repositoryProvider) {
    return new UseCaseModule_ProvideSendEmailVerificationLetterUseCaseFactory(module, repositoryProvider);
  }

  public static SendEmailVerificationLetterUseCase provideSendEmailVerificationLetterUseCase(
      UseCaseModule instance, AuthenticationRepository repository) {
    return Preconditions.checkNotNullFromProvides(instance.provideSendEmailVerificationLetterUseCase(repository));
  }
}
