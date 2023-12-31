package data.di;

import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import domain.repository.AuthenticationRepository;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class AuthModule_ProvideAuthenticationRepositoryFactory implements Factory<AuthenticationRepository> {
  private final AuthModule module;

  private final Provider<FirebaseAuth> firebaseAuthProvider;

  private final Provider<FirebaseFirestore> dbProvider;

  private final Provider<SignInClient> oneTapClientProvider;

  public AuthModule_ProvideAuthenticationRepositoryFactory(AuthModule module,
      Provider<FirebaseAuth> firebaseAuthProvider, Provider<FirebaseFirestore> dbProvider,
      Provider<SignInClient> oneTapClientProvider) {
    this.module = module;
    this.firebaseAuthProvider = firebaseAuthProvider;
    this.dbProvider = dbProvider;
    this.oneTapClientProvider = oneTapClientProvider;
  }

  @Override
  public AuthenticationRepository get() {
    return provideAuthenticationRepository(module, firebaseAuthProvider.get(), dbProvider.get(), oneTapClientProvider.get());
  }

  public static AuthModule_ProvideAuthenticationRepositoryFactory create(AuthModule module,
      Provider<FirebaseAuth> firebaseAuthProvider, Provider<FirebaseFirestore> dbProvider,
      Provider<SignInClient> oneTapClientProvider) {
    return new AuthModule_ProvideAuthenticationRepositoryFactory(module, firebaseAuthProvider, dbProvider, oneTapClientProvider);
  }

  public static AuthenticationRepository provideAuthenticationRepository(AuthModule instance,
      FirebaseAuth firebaseAuth, FirebaseFirestore db, SignInClient oneTapClient) {
    return Preconditions.checkNotNullFromProvides(instance.provideAuthenticationRepository(firebaseAuth, db, oneTapClient));
  }
}
