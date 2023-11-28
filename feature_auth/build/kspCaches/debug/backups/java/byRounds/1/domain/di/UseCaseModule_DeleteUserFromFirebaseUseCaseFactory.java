package domain.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import domain.repository.AuthenticationRepository;
import domain.usecase.DeleteUserFromFirebaseUseCase;
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
public final class UseCaseModule_DeleteUserFromFirebaseUseCaseFactory implements Factory<DeleteUserFromFirebaseUseCase> {
  private final UseCaseModule module;

  private final Provider<AuthenticationRepository> repositoryProvider;

  public UseCaseModule_DeleteUserFromFirebaseUseCaseFactory(UseCaseModule module,
      Provider<AuthenticationRepository> repositoryProvider) {
    this.module = module;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public DeleteUserFromFirebaseUseCase get() {
    return deleteUserFromFirebaseUseCase(module, repositoryProvider.get());
  }

  public static UseCaseModule_DeleteUserFromFirebaseUseCaseFactory create(UseCaseModule module,
      Provider<AuthenticationRepository> repositoryProvider) {
    return new UseCaseModule_DeleteUserFromFirebaseUseCaseFactory(module, repositoryProvider);
  }

  public static DeleteUserFromFirebaseUseCase deleteUserFromFirebaseUseCase(UseCaseModule instance,
      AuthenticationRepository repository) {
    return Preconditions.checkNotNullFromProvides(instance.deleteUserFromFirebaseUseCase(repository));
  }
}
