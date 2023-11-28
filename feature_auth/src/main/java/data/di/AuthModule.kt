package data.di
import android.content.Context
import auth_application.AuthScope
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import dagger.Module
import dagger.Provides
import data.annotations.GmailSignIn
import data.annotations.GmailSignUp
import data.remoteDataSource.repository.AuthenticationRepositoryImpl
import domain.WEB_CLIENT_ID
import domain.repository.AuthenticationRepository


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
        ).setAutoSelectEnabled(true)
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
        ).setAutoSelectEnabled(false)
        .build()




    @Provides
    @AuthScope
    fun provideSignInOptions():GoogleSignInOptions{
        return GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(WEB_CLIENT_ID)
            .requestEmail()
            .requestProfile()
            .build()
    }

    @Provides
    @AuthScope
    fun provideFirebaseStore():FirebaseFirestore {
        return Firebase.firestore
    }


    @Provides
    @AuthScope
    fun provideOneTapClient() = Identity.getSignInClient(context)

    @Provides
    @AuthScope
    fun provideAuthenticationRepository(
        firebaseAuth: FirebaseAuth,
        db: FirebaseFirestore,
        oneTapClient:SignInClient
    ):AuthenticationRepository {
        return AuthenticationRepositoryImpl(firebaseAuth,db,oneTapClient)
    }
}