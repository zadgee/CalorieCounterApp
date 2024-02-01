package domain.usecases
import domain.di.event.SignUpEvent
import domain.repo.AuthenticationRepository
import javax.inject.Inject


class SignUpUseCase @Inject constructor(
    private val repository: AuthenticationRepository
) {

    suspend fun signUp(email: String, password: String): SignUpEvent {
        return repository.signUp(email, password)
    }

}