package domain.usecase;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import domain.repository.AuthenticationRepository;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class AddUserToFireStoreUseCase_Factory implements Factory<AddUserToFireStoreUseCase> {
  private final Provider<AuthenticationRepository> repositoryProvider;

  public AddUserToFireStoreUseCase_Factory(Provider<AuthenticationRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public AddUserToFireStoreUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static AddUserToFireStoreUseCase_Factory create(
      Provider<AuthenticationRepository> repositoryProvider) {
    return new AddUserToFireStoreUseCase_Factory(repositoryProvider);
  }

  public static AddUserToFireStoreUseCase newInstance(AuthenticationRepository repository) {
    return new AddUserToFireStoreUseCase(repository);
  }
}
