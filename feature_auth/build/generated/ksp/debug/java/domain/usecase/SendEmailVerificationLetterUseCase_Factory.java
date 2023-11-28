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
public final class SendEmailVerificationLetterUseCase_Factory implements Factory<SendEmailVerificationLetterUseCase> {
  private final Provider<AuthenticationRepository> repositoryProvider;

  public SendEmailVerificationLetterUseCase_Factory(
      Provider<AuthenticationRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public SendEmailVerificationLetterUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static SendEmailVerificationLetterUseCase_Factory create(
      Provider<AuthenticationRepository> repositoryProvider) {
    return new SendEmailVerificationLetterUseCase_Factory(repositoryProvider);
  }

  public static SendEmailVerificationLetterUseCase newInstance(
      AuthenticationRepository repository) {
    return new SendEmailVerificationLetterUseCase(repository);
  }
}
