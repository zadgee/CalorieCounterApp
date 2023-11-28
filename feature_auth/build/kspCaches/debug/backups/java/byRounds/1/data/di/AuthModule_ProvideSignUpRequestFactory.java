package data.di;

import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("auth_application.AuthScope")
@QualifierMetadata("data.annotations.GmailSignUp")
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
public final class AuthModule_ProvideSignUpRequestFactory implements Factory<BeginSignInRequest> {
  private final AuthModule module;

  public AuthModule_ProvideSignUpRequestFactory(AuthModule module) {
    this.module = module;
  }

  @Override
  public BeginSignInRequest get() {
    return provideSignUpRequest(module);
  }

  public static AuthModule_ProvideSignUpRequestFactory create(AuthModule module) {
    return new AuthModule_ProvideSignUpRequestFactory(module);
  }

  public static BeginSignInRequest provideSignUpRequest(AuthModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideSignUpRequest());
  }
}
