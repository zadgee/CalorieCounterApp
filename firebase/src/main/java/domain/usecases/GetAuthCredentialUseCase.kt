package domain.usecases
import androidx.activity.result.ActivityResult
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.GoogleAuthProvider
import domain.repo.AuthenticationRepository
import javax.inject.Inject


class GetAuthCredentialUseCase @Inject constructor(
    private val repository: AuthenticationRepository
) {

    fun getAuthCredential(activityResult:ActivityResult):AuthCredential{
       val credentials = repository.oneTapClient.getSignInCredentialFromIntent(
            activityResult.data
        )
       val googleIdToken = credentials.googleIdToken
       return GoogleAuthProvider.getCredential(
           googleIdToken,null
       )
    }
}