// Generated by Dagger (https://dagger.dev).
package domain.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import domain.repository.AuthenticationRepository;
import domain.usecase.SignOutWhileUsingGmailAuth;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class UseCaseModule_ProvideSignOutWhileUsingGmailAuthFactory implements Factory<SignOutWhileUsingGmailAuth> {
  private final UseCaseModule module;

  private final Provider<AuthenticationRepository> repositoryProvider;

  public UseCaseModule_ProvideSignOutWhileUsingGmailAuthFactory(UseCaseModule module,
      Provider<AuthenticationRepository> repositoryProvider) {
    this.module = module;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public SignOutWhileUsingGmailAuth get() {
    return provideSignOutWhileUsingGmailAuth(module, repositoryProvider.get());
  }

  public static UseCaseModule_ProvideSignOutWhileUsingGmailAuthFactory create(UseCaseModule module,
      Provider<AuthenticationRepository> repositoryProvider) {
    return new UseCaseModule_ProvideSignOutWhileUsingGmailAuthFactory(module, repositoryProvider);
  }

  public static SignOutWhileUsingGmailAuth provideSignOutWhileUsingGmailAuth(UseCaseModule instance,
      AuthenticationRepository repository) {
    return Preconditions.checkNotNullFromProvides(instance.provideSignOutWhileUsingGmailAuth(repository));
  }
}
