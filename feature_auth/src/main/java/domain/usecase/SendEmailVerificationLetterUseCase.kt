package domain.usecase

import domain.repository.AuthenticationRepository
import javax.inject.Inject

class SendEmailVerificationLetterUseCase @Inject constructor(
    private val repository: AuthenticationRepository
) {

    suspend fun send(){
        return repository.sendEmailVerificationLetter()
    }

}