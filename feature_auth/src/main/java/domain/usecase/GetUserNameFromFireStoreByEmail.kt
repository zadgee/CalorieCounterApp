package domain.usecase
import domain.repository.AuthenticationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class GetUserNameFromFireStoreByEmail @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
){

    suspend fun retrieve(email:String): String {
        return authenticationRepository.getUserNameFromFireStoreByEmail(email).first()
    }

}