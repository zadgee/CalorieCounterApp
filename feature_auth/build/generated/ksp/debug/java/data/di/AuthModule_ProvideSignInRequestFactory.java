package data.di;

import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("auth_application.AuthScope")
@QualifierMetadata("data.annotations.GmailSignIn")
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
public final class AuthModule_ProvideSignInRequestFactory implements Factory<BeginSignInRequest> {
  private final AuthModule module;

  public AuthModule_ProvideSignInRequestFactory(AuthModule module) {
    this.module = module;
  }

  @Override
  public BeginSignInRequest get() {
    return provideSignInRequest(module);
  }

  public static AuthModule_ProvideSignInRequestFactory create(AuthModule module) {
    return new AuthModule_ProvideSignInRequestFactory(module);
  }

  public static BeginSignInRequest provideSignInRequest(AuthModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideSignInRequest());
  }
}
