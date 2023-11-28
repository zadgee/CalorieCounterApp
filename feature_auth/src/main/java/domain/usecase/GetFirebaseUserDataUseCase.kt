package domain.usecase

import domain.models.user.GmailAuthorizationData
import domain.repository.AuthenticationRepository
import javax.inject.Inject

class GetFirebaseUserDataUseCase @Inject constructor(
    private val repository: AuthenticationRepository
){

    suspend fun getData():GmailAuthorizationData{
        return repository.getFirebaseUserData()
    }

}