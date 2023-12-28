package domain.usecases
import androidx.activity.result.ActivityResult
import domain.repo.AuthenticationRepository
import javax.inject.Inject

class GmailAuthUseCase @Inject constructor(
    private val repository: AuthenticationRepository,
    private val getAuthCredentialUseCase: GetAuthCredentialUseCase
) {

    suspend fun gmailAuth(activityResult: ActivityResult){
        val credential = getAuthCredentialUseCase.getAuthCredential(activityResult)
        return repository.gmailAuth(credential)
    }

}