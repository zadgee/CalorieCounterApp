package domain.usecase

import domain.repository.AuthenticationRepository
import javax.inject.Inject

class IsUserExistUseCase @Inject constructor(
    private val repository: AuthenticationRepository
) {

    suspend fun existOrNot(email:String):Boolean{
        return repository.isUserExist(email)
    }

}