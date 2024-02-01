package domain.usecases
import domain.repo.AuthenticationRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ReloadUserUseCase @Inject constructor(
    private val repository: AuthenticationRepository
){
private val useCaseScope = CoroutineScope(Dispatchers.IO)

     fun reload(){
         useCaseScope.launch {
             repository.reloadUser()
         }
    }

}