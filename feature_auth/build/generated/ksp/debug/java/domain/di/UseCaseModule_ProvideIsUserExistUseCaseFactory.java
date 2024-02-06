package domain.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import domain.repository.AuthenticationRepository;
import domain.usecase.IsUserExistUseCase;
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
public final class UseCaseModule_ProvideIsUserExistUseCaseFactory implements Factory<IsUserExistUseCase> {
  private final UseCaseModule module;

  private final Provider<AuthenticationRepository> repositoryProvider;

  public UseCaseModule_ProvideIsUserExistUseCaseFactory(UseCaseModule module,
      Provider<AuthenticationRepository> repositoryProvider) {
    this.module = module;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public IsUserExistUseCase get() {
    return provideIsUserExistUseCase(module, repositoryProvider.get());
  }

  public static UseCaseModule_ProvideIsUserExistUseCaseFactory create(UseCaseModule module,
      Provider<AuthenticationRepository> repositoryProvider) {
    return new UseCaseModule_ProvideIsUserExistUseCaseFactory(module, repositoryProvider);
  }

  public static IsUserExistUseCase provideIsUserExistUseCase(UseCaseModule instance,
      AuthenticationRepository repository) {
    return Preconditions.checkNotNullFromProvides(instance.provideIsUserExistUseCase(repository));
  }
}
