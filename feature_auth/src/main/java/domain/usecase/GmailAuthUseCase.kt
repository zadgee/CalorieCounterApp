package domain.usecase

import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import domain.repository.AuthenticationRepository
import javax.inject.Inject

class GmailAuthUseCase @Inject constructor(
    private val repository: AuthenticationRepository
) {

    suspend fun gmailAuth(credential: AuthCredential): AuthResult?{
        return  repository.gmailAuth(credential)
    }

}