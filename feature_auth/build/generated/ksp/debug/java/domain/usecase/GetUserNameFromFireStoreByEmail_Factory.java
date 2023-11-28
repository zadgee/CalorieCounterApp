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
public final class GetUserNameFromFireStoreByEmail_Factory implements Factory<GetUserNameFromFireStoreByEmail> {
  private final Provider<AuthenticationRepository> authenticationRepositoryProvider;

  public GetUserNameFromFireStoreByEmail_Factory(
      Provider<AuthenticationRepository> authenticationRepositoryProvider) {
    this.authenticationRepositoryProvider = authenticationRepositoryProvider;
  }

  @Override
  public GetUserNameFromFireStoreByEmail get() {
    return newInstance(authenticationRepositoryProvider.get());
  }

  public static GetUserNameFromFireStoreByEmail_Factory create(
      Provider<AuthenticationRepository> authenticationRepositoryProvider) {
    return new GetUserNameFromFireStoreByEmail_Factory(authenticationRepositoryProvider);
  }

  public static GetUserNameFromFireStoreByEmail newInstance(
      AuthenticationRepository authenticationRepository) {
    return new GetUserNameFromFireStoreByEmail(authenticationRepository);
  }
}
