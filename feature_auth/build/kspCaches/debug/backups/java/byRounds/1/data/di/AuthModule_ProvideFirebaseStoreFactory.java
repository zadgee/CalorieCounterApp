package data.di;

import com.google.firebase.firestore.FirebaseFirestore;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class AuthModule_ProvideFirebaseStoreFactory implements Factory<FirebaseFirestore> {
  private final AuthModule module;

  public AuthModule_ProvideFirebaseStoreFactory(AuthModule module) {
    this.module = module;
  }

  @Override
  public FirebaseFirestore get() {
    return provideFirebaseStore(module);
  }

  public static AuthModule_ProvideFirebaseStoreFactory create(AuthModule module) {
    return new AuthModule_ProvideFirebaseStoreFactory(module);
  }

  public static FirebaseFirestore provideFirebaseStore(AuthModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideFirebaseStore());
  }
}
