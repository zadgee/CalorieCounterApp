package domain.di;

import androidx.work.WorkManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class WorkerModule_ProvideWorkManagerInstanceFactory implements Factory<WorkManager> {
  private final WorkerModule module;

  public WorkerModule_ProvideWorkManagerInstanceFactory(WorkerModule module) {
    this.module = module;
  }

  @Override
  public WorkManager get() {
    return provideWorkManagerInstance(module);
  }

  public static WorkerModule_ProvideWorkManagerInstanceFactory create(WorkerModule module) {
    return new WorkerModule_ProvideWorkManagerInstanceFactory(module);
  }

  public static WorkManager provideWorkManagerInstance(WorkerModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideWorkManagerInstance());
  }
}
