package domain.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import domain.repository.AuthenticationRepository;
import domain.usecase.GetUserNameFromFireStoreByEmail;
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
public final class UseCaseModule_ProvideGetUserNameFromFireStoreByEmailFactory implements Factory<GetUserNameFromFireStoreByEmail> {
  private final UseCaseModule module;

  private final Provider<AuthenticationRepository> repositoryProvider;

  public UseCaseModule_ProvideGetUserNameFromFireStoreByEmailFactory(UseCaseModule module,
      Provider<AuthenticationRepository> repositoryProvider) {
    this.module = module;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetUserNameFromFireStoreByEmail get() {
    return provideGetUserNameFromFireStoreByEmail(module, repositoryProvider.get());
  }

  public static UseCaseModule_ProvideGetUserNameFromFireStoreByEmailFactory create(
      UseCaseModule module, Provider<AuthenticationRepository> repositoryProvider) {
    return new UseCaseModule_ProvideGetUserNameFromFireStoreByEmailFactory(module, repositoryProvider);
  }

  public static GetUserNameFromFireStoreByEmail provideGetUserNameFromFireStoreByEmail(
      UseCaseModule instance, AuthenticationRepository repository) {
    return Preconditions.checkNotNullFromProvides(instance.provideGetUserNameFromFireStoreByEmail(repository));
  }
}
