package domain.usecases
import domain.models.GmailAuthorizationData
import domain.repo.AuthenticationRepository
import javax.inject.Inject

class GetFirebaseUserDataUseCase @Inject constructor(
    private val repository: AuthenticationRepository
) {

    suspend fun getData(): GmailAuthorizationData {
        return repository.getFirebaseUserData()
    }

}