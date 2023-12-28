package domain.usecases
import android.content.IntentSender
import domain.repo.AuthenticationRepository
import javax.inject.Inject

class GmailSignUpUseCase @Inject constructor(
    private val repository: AuthenticationRepository
) {

    suspend fun gmailSignUp(): IntentSender {
        return repository.gmailSignUp()
    }

}