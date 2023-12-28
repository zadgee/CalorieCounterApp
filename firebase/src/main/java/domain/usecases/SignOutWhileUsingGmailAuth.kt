package domain.usecases
import domain.repo.AuthenticationRepository
import javax.inject.Inject

class SignOutWhileUsingGmailAuth @Inject constructor(
    private val repository: AuthenticationRepository
) {

    suspend fun signOut() {
       return repository.signOutWhileUsingGmailAuth()
    }

}