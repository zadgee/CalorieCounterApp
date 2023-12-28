package domain.usecases
import domain.repo.AuthenticationRepository
import javax.inject.Inject

class DeleteUserFromFirebaseUseCase @Inject constructor(
    private val repository: AuthenticationRepository
) {

    suspend fun delete(){
        return repository.deleteUserFromFirebase()
    }

}