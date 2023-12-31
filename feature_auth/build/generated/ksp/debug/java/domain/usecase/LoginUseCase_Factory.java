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
public final class LoginUseCase_Factory implements Factory<LoginUseCase> {
  private final Provider<AuthenticationRepository> repositoryProvider;

  public LoginUseCase_Factory(Provider<AuthenticationRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public LoginUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static LoginUseCase_Factory create(Provider<AuthenticationRepository> repositoryProvider) {
    return new LoginUseCase_Factory(repositoryProvider);
  }

  public static LoginUseCase newInstance(AuthenticationRepository repository) {
    return new LoginUseCase(repository);
  }
}
