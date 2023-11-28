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
public final class IsUserExistUseCase_Factory implements Factory<IsUserExistUseCase> {
  private final Provider<AuthenticationRepository> repositoryProvider;

  public IsUserExistUseCase_Factory(Provider<AuthenticationRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public IsUserExistUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static IsUserExistUseCase_Factory create(
      Provider<AuthenticationRepository> repositoryProvider) {
    return new IsUserExistUseCase_Factory(repositoryProvider);
  }

  public static IsUserExistUseCase newInstance(AuthenticationRepository repository) {
    return new IsUserExistUseCase(repository);
  }
}
