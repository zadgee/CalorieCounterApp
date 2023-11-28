package data.di;

import com.google.firebase.auth.FirebaseAuth;
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
public final class AuthModule_ProvideFirebaseAuthFactory implements Factory<FirebaseAuth> {
  private final AuthModule module;

  public AuthModule_ProvideFirebaseAuthFactory(AuthModule module) {
    this.module = module;
  }

  @Override
  public FirebaseAuth get() {
    return provideFirebaseAuth(module);
  }

  public static AuthModule_ProvideFirebaseAuthFactory create(AuthModule module) {
    return new AuthModule_ProvideFirebaseAuthFactory(module);
  }

  public static FirebaseAuth provideFirebaseAuth(AuthModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideFirebaseAuth());
  }
}
