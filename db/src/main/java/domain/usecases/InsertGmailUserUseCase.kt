package domain.usecases
import domain.models.GmailUserEntity
import domain.repository.UserDataSource
import javax.inject.Inject

class InsertGmailUserUseCase @Inject constructor(
    private val userDataSource: UserDataSource
) {

    suspend fun insert(gmailUserEntity: GmailUserEntity){
        return userDataSource.insertGmailUser(gmailUserEntity)
    }

}