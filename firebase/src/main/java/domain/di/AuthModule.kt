package domain.di
import android.content.Context
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.DEFAULT_SIGN_IN
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import data.AuthenticationRepositoryImpl
import domain.annotations.GmailSignIn
import domain.annotations.GmailSignUp
import domain.di.scopes.AuthScope
import domain.repo.AuthenticationRepository

private const val WEB_CLIENT_ID = "954292325717-pc2h4vsfujmrjohfat9jbqnhhslrb78p.apps.googleusercontent.com"

@Module
class AuthModule(
    private val context: Context
){

    @Provides
    @AuthScope
    fun provideFirebaseAuth():FirebaseAuth{
        return FirebaseAuth.getInstance()
    }

    @Provides
    @AuthScope
    @GmailSignIn
    fun provideSignInRequest() = BeginSignInRequest.builder()
        .setGoogleIdTokenRequestOptions(
            BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                .setSupported(true)
                .setServerClientId(WEB_CLIENT_ID)
                .setFilterByAuthorizedAccounts(true)
                .build()
        )
        .setAutoSelectEnabled(true)
        .build()

    @Provides
    @AuthScope
    @GmailSignUp
    fun provideSignUpRequest() = BeginSignInRequest.builder()
        .setGoogleIdTokenRequestOptions(
            BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                .setSupported(true)
                .setServerClientId(WEB_CLIENT_ID)
                .setFilterByAuthorizedAccounts(false)
                .build()
        ).build()


    @Provides
    @AuthScope
    fun provideSignInOptions():GoogleSignInOptions {
        return GoogleSignInOptions.Builder(DEFAULT_SIGN_IN)
            .requestIdToken(WEB_CLIENT_ID)
            .requestEmail()
            .requestProfile()
            .build()
    }

    @Provides
    @AuthScope
    fun provideUserFireStoreCollection():FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    @Provides
    @AuthScope
    fun provideOneTapClient():SignInClient{
        return Identity.getSignInClient(context)
    }

    @Provides
    @AuthScope
    fun provideAuthenticationRepository(
        firebaseAuth: FirebaseAuth,
        oneTapClient: SignInClient,
        @GmailSignIn gmailSignIn: BeginSignInRequest,
        @GmailSignUp gmailSignUp: BeginSignInRequest,
        firebaseFireStore:FirebaseFirestore
    ): AuthenticationRepository {
        return AuthenticationRepositoryImpl(
            firebaseAuth = firebaseAuth,
            signInClient = oneTapClient,
            gmailSignIn = gmailSignIn,
            gmailSignUp = gmailSignUp,
            firebaseFireStore = firebaseFireStore
        )
    }
}