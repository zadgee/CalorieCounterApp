package domain.worker;

import android.content.Context;
import androidx.work.WorkerParameters;
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
public final class EmailVerificationWorker_Factory implements Factory<EmailVerificationWorker> {
  private final Provider<Context> contextProvider;

  private final Provider<WorkerParameters> paramsProvider;

  private final Provider<AuthenticationRepository> authenticationRepositoryProvider;

  public EmailVerificationWorker_Factory(Provider<Context> contextProvider,
      Provider<WorkerParameters> paramsProvider,
      Provider<AuthenticationRepository> authenticationRepositoryProvider) {
    this.contextProvider = contextProvider;
    this.paramsProvider = paramsProvider;
    this.authenticationRepositoryProvider = authenticationRepositoryProvider;
  }

  @Override
  public EmailVerificationWorker get() {
    return newInstance(contextProvider.get(), paramsProvider.get(), authenticationRepositoryProvider.get());
  }

  public static EmailVerificationWorker_Factory create(Provider<Context> contextProvider,
      Provider<WorkerParameters> paramsProvider,
      Provider<AuthenticationRepository> authenticationRepositoryProvider) {
    return new EmailVerificationWorker_Factory(contextProvider, paramsProvider, authenticationRepositoryProvider);
  }

  public static EmailVerificationWorker newInstance(Context context, WorkerParameters params,
      AuthenticationRepository authenticationRepository) {
    return new EmailVerificationWorker(context, params, authenticationRepository);
  }
}
