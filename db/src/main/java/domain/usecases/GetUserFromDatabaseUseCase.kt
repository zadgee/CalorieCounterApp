package domain.usecases

import domain.models.UserEntity
import domain.repository.UserDataSource
import javax.inject.Inject

class GetUserFromDatabaseUseCase @Inject constructor(
    private val userDataSource: UserDataSource
) {

    suspend fun getUserFromDataBase(): UserEntity? {
        return userDataSource.getUser()
    }

}