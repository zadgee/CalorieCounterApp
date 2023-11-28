package data.di;

import com.google.android.gms.auth.api.identity.SignInClient;
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
public final class AuthModule_ProvideOneTapClientFactory implements Factory<SignInClient> {
  private final AuthModule module;

  public AuthModule_ProvideOneTapClientFactory(AuthModule module) {
    this.module = module;
  }

  @Override
  public SignInClient get() {
    return provideOneTapClient(module);
  }

  public static AuthModule_ProvideOneTapClientFactory create(AuthModule module) {
    return new AuthModule_ProvideOneTapClientFactory(module);
  }

  public static SignInClient provideOneTapClient(AuthModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideOneTapClient());
  }
}
