package domain.di;

import android.content.Context;
import androidx.work.WorkerParameters;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import domain.repository.AuthenticationRepository;
import domain.worker.EmailVerificationWorker;
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
public final class WorkerModule_ProvideEmailVerificationWaiterWorkerFactory implements Factory<EmailVerificationWorker> {
  private final WorkerModule module;

  private final Provider<Context> contextProvider;

  private final Provider<WorkerParameters> paramsProvider;

  private final Provider<AuthenticationRepository> authenticationRepositoryProvider;

  public WorkerModule_ProvideEmailVerificationWaiterWorkerFactory(WorkerModule module,
      Provider<Context> contextProvider, Provider<WorkerParameters> paramsProvider,
      Provider<AuthenticationRepository> authenticationRepositoryProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
    this.paramsProvider = paramsProvider;
    this.authenticationRepositoryProvider = authenticationRepositoryProvider;
  }

  @Override
  public EmailVerificationWorker get() {
    return provideEmailVerificationWaiterWorker(module, contextProvider.get(), paramsProvider.get(), authenticationRepositoryProvider.get());
  }

  public static WorkerModule_ProvideEmailVerificationWaiterWorkerFactory create(WorkerModule module,
      Provider<Context> contextProvider, Provider<WorkerParameters> paramsProvider,
      Provider<AuthenticationRepository> authenticationRepositoryProvider) {
    return new WorkerModule_ProvideEmailVerificationWaiterWorkerFactory(module, contextProvider, paramsProvider, authenticationRepositoryProvider);
  }

  public static EmailVerificationWorker provideEmailVerificationWaiterWorker(WorkerModule instance,
      Context context, WorkerParameters params, AuthenticationRepository authenticationRepository) {
    return Preconditions.checkNotNullFromProvides(instance.provideEmailVerificationWaiterWorker(context, params, authenticationRepository));
  }
}
