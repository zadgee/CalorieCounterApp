package domain.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import domain.repository.AuthenticationRepository;
import domain.usecase.SendPasswordResetEmailUseCase;
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
public final class UseCaseModule_ProvideSendPasswordResetEmailUseCaseFactory implements Factory<SendPasswordResetEmailUseCase> {
  private final UseCaseModule module;

  private final Provider<AuthenticationRepository> repositoryProvider;

  public UseCaseModule_ProvideSendPasswordResetEmailUseCaseFactory(UseCaseModule module,
      Provider<AuthenticationRepository> repositoryProvider) {
    this.module = module;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public SendPasswordResetEmailUseCase get() {
    return provideSendPasswordResetEmailUseCase(module, repositoryProvider.get());
  }

  public static UseCaseModule_ProvideSendPasswordResetEmailUseCaseFactory create(
      UseCaseModule module, Provider<AuthenticationRepository> repositoryProvider) {
    return new UseCaseModule_ProvideSendPasswordResetEmailUseCaseFactory(module, repositoryProvider);
  }

  public static SendPasswordResetEmailUseCase provideSendPasswordResetEmailUseCase(
      UseCaseModule instance, AuthenticationRepository repository) {
    return Preconditions.checkNotNullFromProvides(instance.provideSendPasswordResetEmailUseCase(repository));
  }
}
