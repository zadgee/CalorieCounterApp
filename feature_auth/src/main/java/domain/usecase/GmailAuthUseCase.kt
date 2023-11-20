package domain.usecase

import com.google.firebase.auth.AuthCredential
import domain.repository.AuthenticationRepository
import javax.inject.Inject

class GmailAuthUseCase @Inject constructor(
    private val repository: AuthenticationRepository
) {

    suspend fun gmailAuth(credential: AuthCredential){
        repository.gmailAuth(credential)
    }

}