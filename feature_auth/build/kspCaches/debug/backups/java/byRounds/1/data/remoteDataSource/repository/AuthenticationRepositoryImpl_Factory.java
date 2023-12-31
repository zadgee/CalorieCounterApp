package data.remoteDataSource.repository;

import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
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
public final class AuthenticationRepositoryImpl_Factory implements Factory<AuthenticationRepositoryImpl> {
  private final Provider<FirebaseAuth> firebaseAuthProvider;

  private final Provider<FirebaseFirestore> dbProvider;

  private final Provider<SignInClient> oneTapClientProvider;

  public AuthenticationRepositoryImpl_Factory(Provider<FirebaseAuth> firebaseAuthProvider,
      Provider<FirebaseFirestore> dbProvider, Provider<SignInClient> oneTapClientProvider) {
    this.firebaseAuthProvider = firebaseAuthProvider;
    this.dbProvider = dbProvider;
    this.oneTapClientProvider = oneTapClientProvider;
  }

  @Override
  public AuthenticationRepositoryImpl get() {
    return newInstance(firebaseAuthProvider.get(), dbProvider.get(), oneTapClientProvider.get());
  }

  public static AuthenticationRepositoryImpl_Factory create(
      Provider<FirebaseAuth> firebaseAuthProvider, Provider<FirebaseFirestore> dbProvider,
      Provider<SignInClient> oneTapClientProvider) {
    return new AuthenticationRepositoryImpl_Factory(firebaseAuthProvider, dbProvider, oneTapClientProvider);
  }

  public static AuthenticationRepositoryImpl newInstance(FirebaseAuth firebaseAuth,
      FirebaseFirestore db, SignInClient oneTapClient) {
    return new AuthenticationRepositoryImpl(firebaseAuth, db, oneTapClient);
  }
}
