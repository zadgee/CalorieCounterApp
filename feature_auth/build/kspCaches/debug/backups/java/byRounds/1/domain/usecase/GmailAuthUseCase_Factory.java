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
public final class GmailAuthUseCase_Factory implements Factory<GmailAuthUseCase> {
  private final Provider<AuthenticationRepository> repositoryProvider;

  public GmailAuthUseCase_Factory(Provider<AuthenticationRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GmailAuthUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GmailAuthUseCase_Factory create(
      Provider<AuthenticationRepository> repositoryProvider) {
    return new GmailAuthUseCase_Factory(repositoryProvider);
  }

  public static GmailAuthUseCase newInstance(AuthenticationRepository repository) {
    return new GmailAuthUseCase(repository);
  }
}
