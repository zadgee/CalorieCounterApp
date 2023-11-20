package domain.usecase

import domain.repository.AuthenticationRepository
import javax.inject.Inject

class AddUserToFireStoreUseCase @Inject constructor(
    private val repository: AuthenticationRepository
) {

    suspend fun add(name:String,email:String,password: String){
        repository.addUserToFireStore(name,email,password)
    }

}