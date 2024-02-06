package glue.forgot_password.router
import com.test.forgot_password.presentation.router.ForgotPasswordRouter
import domain.usecases.SendPasswordResetEmailUseCase
import javax.inject.Inject

class ForgotPasswordRouterImpl @Inject constructor(
    private val sendPasswordResetEmailUseCase: SendPasswordResetEmailUseCase
) : ForgotPasswordRouter {

    override suspend fun sendResetPasswordEmail(email: String) {
        return sendPasswordResetEmailUseCase.send(email)
    }

}