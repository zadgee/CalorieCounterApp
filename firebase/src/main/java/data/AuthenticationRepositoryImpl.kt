package data
import android.content.IntentSender
import android.util.Log
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import domain.annotations.GmailSignIn
import domain.annotations.GmailSignUp
import domain.di.event.ReloadingEvent
import domain.di.event.SignInEvent
import domain.di.event.SignUpEvent
import domain.models.GmailAuthorizationData
import domain.models.UserModel
import domain.repo.AuthenticationRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

private const val USER_TO_FIRE_STORE_ERROR = "USER_TO_FIRE_STORE_ERROR"
private const val DELETE_USER_FROM_FIREBASE = "DELETE_USER_FROM_FIREBASE"
private const val EMAIL_VERIFICATION = "EMAIL_VERIFICATION"


class AuthenticationRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val firebaseFireStore: FirebaseFirestore,
    val signInClient: SignInClient,
    @GmailSignUp private val gmailSignUp: BeginSignInRequest,
    @GmailSignIn private val gmailSignIn: BeginSignInRequest,
    ): AuthenticationRepository {
    override val oneTapClient: SignInClient = signInClient
    override val user: FirebaseUser? = firebaseAuth.currentUser
    override suspend fun getUserNameFromFireStoreByEmail(email: String): Flow<String> {
        return flow {
            val userCollection = firebaseFireStore.collection("users_collection")
            val result = userCollection.whereEqualTo(
                "email", email
            ).get().await()
            if (!result.isEmpty) {
                val userName = result.toObjects(UserModel::class.java)[0].name
                emit(
                    userName
                )
            }
        }.catch {
            Log.d("TAG", it.message ?: "Unknown error")
        }
    }

    override suspend fun gmailAuth(credential: AuthCredential) {
        val result = firebaseAuth.signInWithCredential(credential).await()
        val email = result?.user?.email
        val isNewUser = result.additionalUserInfo?.isNewUser ?: false

        if(email != null && isNewUser){
            user?.apply {
                val user = GmailAuthorizationData(
                    id = uid,
                    name = displayName,
                    pictureUrl = photoUrl?.toString()
                )
                val userRef = firebaseFireStore.collection("authorized_users_with_gmail")
                userRef.document().set(user).addOnFailureListener {
                    Log.d(USER_TO_FIRE_STORE_ERROR, it.message ?: "Unknown error")
                }.await()
            }
        }
    }

    override suspend fun sendPasswordResetEmail(email: String) {
        firebaseAuth.sendPasswordResetEmail(email)
            .addOnSuccessListener {
                Log.d("ResetEmail", "Success:$it")
            }.addOnFailureListener {
                Log.d("ResetEmail", "Failure:$it")
            }
            .await()
    }

    override suspend fun getFirebaseUserData(): GmailAuthorizationData {
        return GmailAuthorizationData(
            id = user?.uid ?: throw Exception("User id is null"),
            name = user.displayName ?: "",
            pictureUrl = user.photoUrl?.toString()
        )
    }

    override suspend fun gmailSignUp(): IntentSender {
        return signInClient.beginSignIn(gmailSignUp).await().pendingIntent.intentSender
    }

    override suspend fun gmailSignIn(): IntentSender {
        return signInClient.beginSignIn(gmailSignIn).await().pendingIntent.intentSender
    }

    override suspend fun signUp(email: String, password: String):SignUpEvent {
        return try {
            val isUserAlreadyCreated =
                firebaseAuth.fetchSignInMethodsForEmail(email).await().signInMethods
            if(isUserAlreadyCreated.isNullOrEmpty()){
                SignUpEvent.Error(error = "User already exists")
            }
            firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            return SignUpEvent.Success
        }catch(e:Exception){
            SignUpEvent.Error(error = e.message ?: "Unknown error")
        }
    }

    override suspend fun addUserToFireStore(name: String, email: String, password: String) {
        val userCollection = firebaseFireStore.collection("users_collection")
        val user = UserModel(
            name = name,
            email = email,
            password = password
        )
        userCollection.document().set(user).await()
    }

    override suspend fun login(email: String, password: String):SignInEvent {
        return try {
            SignInEvent.Loading
            delay(20)
            SignInEvent.Success(
                result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            )
        }catch (e: FirebaseAuthInvalidUserException){
            SignInEvent.Error(error = "Invalid email or user does not exist")
        }catch (e: FirebaseAuthInvalidCredentialsException){
            SignInEvent.Error(error = "Invalid data")
        }
        catch (e:Exception){
            SignInEvent.Error(e.message ?: "Unknown error")
        }
    }

    override suspend fun signOutWhileUsingEmailPassword() {
        return firebaseAuth.signOut()
    }

    override suspend fun signOutWhileUsingGmailAuth() {
        firebaseAuth.signOut()
        delay(20)
        signInClient.signOut()
    }

    override suspend fun reloadUser(){
        try {
            user?.reload()?.await()
        }catch (e:Exception){
            ReloadingEvent.Error(message = "${e.message}")
        }
    }

    override suspend fun sendEmailVerificationLetter(){
        try {
            user?.sendEmailVerification()?.await()
        }catch (e:Exception){
            Log.d(EMAIL_VERIFICATION, "${e.message}")
        }
    }

    override suspend fun deleteUserFromFirebase() {
        try {
            user?.delete()?.await()
        }catch (e:Exception){
            Log.d(DELETE_USER_FROM_FIREBASE, "${e.message}")
        }
    }
}