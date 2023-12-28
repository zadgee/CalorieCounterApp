package domain.repo
import android.content.IntentSender
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseUser
import domain.event.SignInEvent
import domain.event.SignUpEvent
import domain.models.GmailAuthorizationData
import kotlinx.coroutines.flow.Flow

interface AuthenticationRepository{
    suspend fun signUp(email:String, password:String): SignUpEvent
    suspend fun addUserToFireStore(name:String, email:String, password: String)
    suspend fun login(email: String, password: String): SignInEvent
    suspend fun signOutWhileUsingEmailPassword()
    suspend fun signOutWhileUsingGmailAuth()
    suspend fun reloadUser()
    suspend fun sendEmailVerificationLetter()
    suspend fun deleteUserFromFirebase()
    val user: FirebaseUser?
    suspend fun getUserNameFromFireStoreByEmail(email:String): Flow<String>
    suspend fun gmailAuth(credential: AuthCredential)
    suspend fun sendPasswordResetEmail(email: String)
    suspend fun getFirebaseUserData(): GmailAuthorizationData
    suspend fun gmailSignUp():IntentSender
    suspend fun gmailSignIn():IntentSender
    val oneTapClient:SignInClient
}