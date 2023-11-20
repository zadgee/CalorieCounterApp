package domain.usecase
import domain.event.SignUpEvent
import domain.repository.AuthenticationRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val repository: AuthenticationRepository
) {

    suspend fun signUp(email: String, password: String): SignUpEvent {
        return repository.signUp(email, password)
    }

}