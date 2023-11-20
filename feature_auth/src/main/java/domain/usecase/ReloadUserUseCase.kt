package domain.usecase

import domain.event.ReloadingEvent
import domain.repository.AuthenticationRepository
import javax.inject.Inject

class ReloadUserUseCase @Inject constructor(
    private val repository: AuthenticationRepository
){

    suspend fun reload(){
        return repository.reloadUser()
    }

}