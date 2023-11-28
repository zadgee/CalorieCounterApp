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
public final class ReloadUserUseCase_Factory implements Factory<ReloadUserUseCase> {
  private final Provider<AuthenticationRepository> repositoryProvider;

  public ReloadUserUseCase_Factory(Provider<AuthenticationRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public ReloadUserUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static ReloadUserUseCase_Factory create(
      Provider<AuthenticationRepository> repositoryProvider) {
    return new ReloadUserUseCase_Factory(repositoryProvider);
  }

  public static ReloadUserUseCase newInstance(AuthenticationRepository repository) {
    return new ReloadUserUseCase(repository);
  }
}
