package domain.usecases
import domain.repo.AuthenticationRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthenticationRepository
) {

    suspend fun login(email: String, password: String): domain.event.SignInEvent {
        return repository.login(email, password)
    }

}