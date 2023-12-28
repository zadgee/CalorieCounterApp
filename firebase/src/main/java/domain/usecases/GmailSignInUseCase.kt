package domain.usecases
import android.content.IntentSender
import domain.repo.AuthenticationRepository
import javax.inject.Inject

class GmailSignInUseCase @Inject constructor(
    private val repository: AuthenticationRepository
) {

    suspend fun gmailSignIn():IntentSender{
        return repository.gmailSignIn()
    }

}