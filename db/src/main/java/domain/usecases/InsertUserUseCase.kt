package domain.usecases
import domain.models.UserEntity
import domain.repository.UserDataSource
import javax.inject.Inject

class InsertUserUseCase @Inject constructor(
    private val userDataSource: UserDataSource
) {

    suspend fun insertUser(userEntity: UserEntity) {
        return userDataSource.insertUser(userEntity)
    }

}