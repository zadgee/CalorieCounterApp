package domain.usecases

import domain.models.UserEntity
import domain.repository.UserDataSource
import javax.inject.Inject

class DeleteUserFromDBUseCase @Inject constructor(
    private val userDataSource: UserDataSource
){

    suspend fun deleteUser(user:UserEntity){
        return userDataSource.deleteUserFromDB(user)
    }

}