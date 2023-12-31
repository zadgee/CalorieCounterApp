package domain.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import domain.repository.AuthenticationRepository;
import domain.usecase.SignUpUseCase;
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
public final class UseCaseModule_ProvideSignUpUseCaseFactory implements Factory<SignUpUseCase> {
  private final UseCaseModule module;

  private final Provider<AuthenticationRepository> repositoryProvider;

  public UseCaseModule_ProvideSignUpUseCaseFactory(UseCaseModule module,
      Provider<AuthenticationRepository> repositoryProvider) {
    this.module = module;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public SignUpUseCase get() {
    return provideSignUpUseCase(module, repositoryProvider.get());
  }

  public static UseCaseModule_ProvideSignUpUseCaseFactory create(UseCaseModule module,
      Provider<AuthenticationRepository> repositoryProvider) {
    return new UseCaseModule_ProvideSignUpUseCaseFactory(module, repositoryProvider);
  }

  public static SignUpUseCase provideSignUpUseCase(UseCaseModule instance,
      AuthenticationRepository repository) {
    return Preconditions.checkNotNullFromProvides(instance.provideSignUpUseCase(repository));
  }
}
