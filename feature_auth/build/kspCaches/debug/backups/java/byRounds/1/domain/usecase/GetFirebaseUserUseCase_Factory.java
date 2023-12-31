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
public final class GetFirebaseUserUseCase_Factory implements Factory<GetFirebaseUserUseCase> {
  private final Provider<AuthenticationRepository> repositoryProvider;

  public GetFirebaseUserUseCase_Factory(Provider<AuthenticationRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetFirebaseUserUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetFirebaseUserUseCase_Factory create(
      Provider<AuthenticationRepository> repositoryProvider) {
    return new GetFirebaseUserUseCase_Factory(repositoryProvider);
  }

  public static GetFirebaseUserUseCase newInstance(AuthenticationRepository repository) {
    return new GetFirebaseUserUseCase(repository);
  }
}
