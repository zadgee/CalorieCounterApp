package data.di;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\bH\u0007J\b\u0010\u000e\u001a\u00020\nH\u0007J\b\u0010\u000f\u001a\u00020\fH\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Ldata/di/AuthModule;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "provideAuthenticationRepository", "Ldomain/repository/AuthenticationRepository;", "firebaseAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "db", "Lcom/google/firebase/firestore/FirebaseFirestore;", "oneTapClient", "Lcom/google/android/gms/auth/api/identity/SignInClient;", "provideFirebaseAuth", "provideFirebaseStore", "provideOneTapClient", "provideSignInOptions", "Lcom/google/android/gms/auth/api/signin/GoogleSignInOptions;", "provideSignInRequest", "Lcom/google/android/gms/auth/api/identity/BeginSignInRequest;", "feature_auth_debug"})
public final class AuthModule {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    
    public AuthModule(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.google.firebase.auth.FirebaseAuth provideFirebaseAuth() {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.google.android.gms.auth.api.identity.BeginSignInRequest provideSignInRequest() {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.google.android.gms.auth.api.signin.GoogleSignInOptions provideSignInOptions() {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.google.firebase.firestore.FirebaseFirestore provideFirebaseStore() {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.google.android.gms.auth.api.identity.SignInClient provideOneTapClient() {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final domain.repository.AuthenticationRepository provideAuthenticationRepository(@org.jetbrains.annotations.NotNull
    com.google.firebase.auth.FirebaseAuth firebaseAuth, @org.jetbrains.annotations.NotNull
    com.google.firebase.firestore.FirebaseFirestore db, @org.jetbrains.annotations.NotNull
    com.google.android.gms.auth.api.identity.SignInClient oneTapClient) {
        return null;
    }
}