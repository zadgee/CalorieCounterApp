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
public final class SendPasswordResetEmailUseCase_Factory implements Factory<SendPasswordResetEmailUseCase> {
  private final Provider<AuthenticationRepository> repositoryProvider;

  public SendPasswordResetEmailUseCase_Factory(
      Provider<AuthenticationRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public SendPasswordResetEmailUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static SendPasswordResetEmailUseCase_Factory create(
      Provider<AuthenticationRepository> repositoryProvider) {
    return new SendPasswordResetEmailUseCase_Factory(repositoryProvider);
  }

  public static SendPasswordResetEmailUseCase newInstance(AuthenticationRepository repository) {
    return new SendPasswordResetEmailUseCase(repository);
  }
}
