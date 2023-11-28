package data.di;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
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
public final class AuthModule_ProvideSignInOptionsFactory implements Factory<GoogleSignInOptions> {
  private final AuthModule module;

  public AuthModule_ProvideSignInOptionsFactory(AuthModule module) {
    this.module = module;
  }

  @Override
  public GoogleSignInOptions get() {
    return provideSignInOptions(module);
  }

  public static AuthModule_ProvideSignInOptionsFactory create(AuthModule module) {
    return new AuthModule_ProvideSignInOptionsFactory(module);
  }

  public static GoogleSignInOptions provideSignInOptions(AuthModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideSignInOptions());
  }
}
