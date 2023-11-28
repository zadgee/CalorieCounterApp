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
public final class SignOutWhileUsingGmailAuth_Factory implements Factory<SignOutWhileUsingGmailAuth> {
  private final Provider<AuthenticationRepository> repositoryProvider;

  public SignOutWhileUsingGmailAuth_Factory(Provider<AuthenticationRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public SignOutWhileUsingGmailAuth get() {
    return newInstance(repositoryProvider.get());
  }

  public static SignOutWhileUsingGmailAuth_Factory create(
      Provider<AuthenticationRepository> repositoryProvider) {
    return new SignOutWhileUsingGmailAuth_Factory(repositoryProvider);
  }

  public static SignOutWhileUsingGmailAuth newInstance(AuthenticationRepository repository) {
    return new SignOutWhileUsingGmailAuth(repository);
  }
}
