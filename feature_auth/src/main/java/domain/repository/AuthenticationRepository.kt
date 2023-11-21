package domain.repository
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseUser
import domain.event.SignInEvent
import domain.event.SignUpEvent
import kotlinx.coroutines.flow.Flow

interface AuthenticationRepository{
    suspend fun signUp(email:String,password:String): SignUpEvent
    suspend fun addUserToFireStore(name:String,email:String,password: String)
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
}