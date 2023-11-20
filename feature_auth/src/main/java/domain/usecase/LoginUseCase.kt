package domain.usecase

import domain.event.SignInEvent
import domain.repository.AuthenticationRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthenticationRepository
) {

    suspend fun login(email: String, password: String): SignInEvent {
        return repository.login(email, password)
    }

}