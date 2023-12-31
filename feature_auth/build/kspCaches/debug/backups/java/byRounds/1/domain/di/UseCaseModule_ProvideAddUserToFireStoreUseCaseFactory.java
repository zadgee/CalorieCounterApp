package domain.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import domain.repository.AuthenticationRepository;
import domain.usecase.AddUserToFireStoreUseCase;
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
public final class UseCaseModule_ProvideAddUserToFireStoreUseCaseFactory implements Factory<AddUserToFireStoreUseCase> {
  private final UseCaseModule module;

  private final Provider<AuthenticationRepository> repositoryProvider;

  public UseCaseModule_ProvideAddUserToFireStoreUseCaseFactory(UseCaseModule module,
      Provider<AuthenticationRepository> repositoryProvider) {
    this.module = module;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public AddUserToFireStoreUseCase get() {
    return provideAddUserToFireStoreUseCase(module, repositoryProvider.get());
  }

  public static UseCaseModule_ProvideAddUserToFireStoreUseCaseFactory create(UseCaseModule module,
      Provider<AuthenticationRepository> repositoryProvider) {
    return new UseCaseModule_ProvideAddUserToFireStoreUseCaseFactory(module, repositoryProvider);
  }

  public static AddUserToFireStoreUseCase provideAddUserToFireStoreUseCase(UseCaseModule instance,
      AuthenticationRepository repository) {
    return Preconditions.checkNotNullFromProvides(instance.provideAddUserToFireStoreUseCase(repository));
  }
}
