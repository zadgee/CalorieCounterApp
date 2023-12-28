package domain.usecases
import domain.repo.AuthenticationRepository
import javax.inject.Inject


class AddUserToFireStoreUseCase @Inject constructor(
    private val repository: AuthenticationRepository
) {

    suspend fun add(name:String,email:String,password: String){
       return repository.addUserToFireStore(name,email,password)
    }

}