package data.remoteDataSource.repository
import android.util.Log
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import domain.event.ReloadingEvent
import domain.event.SignInEvent
import domain.event.SignUpEvent
import domain.models.user.GmailAuthorizationData
import domain.models.user.UserModel
import domain.repository.AuthenticationRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

private const val EMAIL_VERIFICATION = "EmailVerification"
private const val DELETE_USER_FROM_FIREBASE = "DeleteUserFromFireBase"
private const val USER_TO_FIRE_STORE_ERROR = "SavingToFireStoreTAG"



class AuthenticationRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val db:FirebaseFirestore,
    private val oneTapClient:SignInClient
): AuthenticationRepository {

    override val user: FirebaseUser? get() = firebaseAuth.currentUser

    override suspend fun getUserNameFromFireStoreByEmail(email: String):Flow<String>{
        return flow {
            val userCollection = db.collection("users_collection")
            val result = userCollection.whereEqualTo(
                "email",email
            ).get().await()
            if(!result.isEmpty){
                val userName = result.toObjects(UserModel::class.java)[0].name
                emit(
                   userName
                )
            }
        }.catch {
            Log.d("TAG",it.message?:"Unknown error")
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
                val userRef = db.collection("authorized_users_with_gmail")
                userRef.document().set(user).addOnFailureListener {
                    Log.d(USER_TO_FIRE_STORE_ERROR,it.message?:"Unknown error")
                }.await()
            }
        }
    }

    override suspend fun signUp(email: String, password: String): SignUpEvent {
       return try {
           SignUpEvent.Loading
           val isUserAlreadyCreated =
               firebaseAuth.fetchSignInMethodsForEmail(email).await().signInMethods
           if(isUserAlreadyCreated.isNullOrEmpty()){
               SignUpEvent.Error(error = "User already exists")
           }
           firebaseAuth.createUserWithEmailAndPassword(email, password).await()
           return SignUpEvent.Success
       }catch(e:Exception){
           SignUpEvent.Error(error = e.message ?:"Unknown error")
       }
    }

    override suspend fun addUserToFireStore(name: String, email: String, password: String) {
        val userCollection = db.collection("users_collection")
        val user = UserModel(
            name = name,
            email = email,
            password = password
        )
        userCollection.document().set(user).await()
    }

    override suspend fun login(email: String, password: String): SignInEvent {
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
           SignInEvent.Error(e.message ?:"Unknown error")
       }
    }

    override suspend fun signOutWhileUsingEmailPassword() {
        return firebaseAuth.signOut()
    }

    override suspend fun signOutWhileUsingGmailAuth() {
        firebaseAuth.signOut()
        delay(20)
        oneTapClient.signOut()
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
             Log.d(EMAIL_VERIFICATION,"${e.message}")
         }
    }

    override suspend fun deleteUserFromFirebase() {
        try {
          user?.delete()?.await()
        }catch (e:Exception){
            Log.d(DELETE_USER_FROM_FIREBASE,"${e.message}")
        }
    }


}