package domain.usecases
import domain.repo.AuthenticationRepository
import javax.inject.Inject

class SendEmailVerificationLetterUseCase @Inject constructor(
    private val repository: AuthenticationRepository
) {

    suspend fun send(){
        return repository.sendEmailVerificationLetter()
    }

}