package glue.email_verification.router
import com.test.email_verification.domain.models.UserModel
import com.test.email_verification.presentation.router.EmailVerificationRouter
import domain.models.UserEntity
import domain.usecases.InsertUserUseCase
import javax.inject.Inject

class EmailVerificationRouterImpl @Inject constructor(
    private val insertUserUseCase: InsertUserUseCase
) : EmailVerificationRouter {

    override suspend fun saveUserToDB(user: UserModel) {
        return insertUserUseCase.insertUser(
            UserEntity(
                email = user.email,
                name = user.name,
                password = user.password
            )
        )
    }

}