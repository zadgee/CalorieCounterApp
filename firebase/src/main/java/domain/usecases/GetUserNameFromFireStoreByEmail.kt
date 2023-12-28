package domain.usecases
import domain.repo.AuthenticationRepository
import kotlinx.coroutines.flow.last
import javax.inject.Inject

class GetUserNameFromFireStoreByEmail @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
){

    suspend fun retrieve(email:String): String {
        return authenticationRepository.getUserNameFromFireStoreByEmail(email).last()
    }

}