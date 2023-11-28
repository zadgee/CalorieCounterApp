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
public final class SignOutWhileUsingEmailPasswordUseCase_Factory implements Factory<SignOutWhileUsingEmailPasswordUseCase> {
  private final Provider<AuthenticationRepository> repositoryProvider;

  public SignOutWhileUsingEmailPasswordUseCase_Factory(
      Provider<AuthenticationRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public SignOutWhileUsingEmailPasswordUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static SignOutWhileUsingEmailPasswordUseCase_Factory create(
      Provider<AuthenticationRepository> repositoryProvider) {
    return new SignOutWhileUsingEmailPasswordUseCase_Factory(repositoryProvider);
  }

  public static SignOutWhileUsingEmailPasswordUseCase newInstance(
      AuthenticationRepository repository) {
    return new SignOutWhileUsingEmailPasswordUseCase(repository);
  }
}
