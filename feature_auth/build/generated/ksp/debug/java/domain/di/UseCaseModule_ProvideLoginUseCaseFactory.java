package domain.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import domain.repository.AuthenticationRepository;
import domain.usecase.LoginUseCase;
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
public final class UseCaseModule_ProvideLoginUseCaseFactory implements Factory<LoginUseCase> {
  private final UseCaseModule module;

  private final Provider<AuthenticationRepository> repositoryProvider;

  public UseCaseModule_ProvideLoginUseCaseFactory(UseCaseModule module,
      Provider<AuthenticationRepository> repositoryProvider) {
    this.module = module;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public LoginUseCase get() {
    return provideLoginUseCase(module, repositoryProvider.get());
  }

  public static UseCaseModule_ProvideLoginUseCaseFactory create(UseCaseModule module,
      Provider<AuthenticationRepository> repositoryProvider) {
    return new UseCaseModule_ProvideLoginUseCaseFactory(module, repositoryProvider);
  }

  public static LoginUseCase provideLoginUseCase(UseCaseModule instance,
      AuthenticationRepository repository) {
    return Preconditions.checkNotNullFromProvides(instance.provideLoginUseCase(repository));
  }
}
