package domain.usecase

import domain.repository.AuthenticationRepository
import javax.inject.Inject

class SignOutWhileUsingGmailAuth @Inject constructor(
    private val repository: AuthenticationRepository
) {

    suspend fun signOut() {
       return repository.signOutWhileUsingGmailAuth()
    }

}