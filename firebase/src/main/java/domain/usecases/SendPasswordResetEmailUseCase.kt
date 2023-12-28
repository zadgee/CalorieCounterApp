package domain.usecases
import domain.repo.AuthenticationRepository
import javax.inject.Inject

class SendPasswordResetEmailUseCase @Inject constructor(
    private val repository: AuthenticationRepository
) {

    suspend fun send(email:String){
        return repository.sendPasswordResetEmail(email)
    }

}