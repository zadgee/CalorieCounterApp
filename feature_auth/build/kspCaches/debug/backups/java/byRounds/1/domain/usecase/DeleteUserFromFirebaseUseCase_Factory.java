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
public final class DeleteUserFromFirebaseUseCase_Factory implements Factory<DeleteUserFromFirebaseUseCase> {
  private final Provider<AuthenticationRepository> repositoryProvider;

  public DeleteUserFromFirebaseUseCase_Factory(
      Provider<AuthenticationRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public DeleteUserFromFirebaseUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static DeleteUserFromFirebaseUseCase_Factory create(
      Provider<AuthenticationRepository> repositoryProvider) {
    return new DeleteUserFromFirebaseUseCase_Factory(repositoryProvider);
  }

  public static DeleteUserFromFirebaseUseCase newInstance(AuthenticationRepository repository) {
    return new DeleteUserFromFirebaseUseCase(repository);
  }
}
