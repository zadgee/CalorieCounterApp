package domain.usecases
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthorizedWithGmailUseCase @Inject constructor(
  private val firebaseUserUseCase: GetFirebaseUserUseCase
) {
    private val firebaseUser = firebaseUserUseCase.user()
    suspend fun authorizeWithGmail(): domain.models.GmailAuthorizationData?{
        return withContext(Dispatchers.IO){
            if(firebaseUser != null &&
                firebaseUser.providerData.any {
                    it.providerId == GoogleAuthProvider.PROVIDER_ID
                }
            ){
                domain.models.GmailAuthorizationData(
                    id = firebaseUser.uid,
                    name = firebaseUser.displayName ?: "",
                    pictureUrl = firebaseUser.photoUrl?.toString()
                )
            }
            null
        }
    }
}