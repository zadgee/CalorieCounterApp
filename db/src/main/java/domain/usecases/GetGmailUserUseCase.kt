package domain.usecases

import domain.models.GmailUserEntity
import domain.repository.UserDataSource
import javax.inject.Inject

class GetGmailUserUseCase @Inject constructor(
    private val userDataSource: UserDataSource
) {

    suspend fun execute(): GmailUserEntity? {
        return userDataSource.getGmailUser()
    }

}