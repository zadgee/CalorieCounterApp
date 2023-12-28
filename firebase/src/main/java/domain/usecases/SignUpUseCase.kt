package domain.usecases
import domain.repo.AuthenticationRepository
import javax.inject.Inject


class SignUpUseCase @Inject constructor(
    private val repository: AuthenticationRepository
) {

    suspend fun signUp(email: String, password: String): domain.event.SignUpEvent {
        return repository.signUp(email, password)
    }

}