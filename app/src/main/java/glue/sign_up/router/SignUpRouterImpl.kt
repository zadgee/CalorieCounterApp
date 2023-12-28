package glue.sign_up.router
import com.test.sign_up.presentation.router.SignUpRouter
import domain.usecases.SendEmailVerificationLetterUseCase
import javax.inject.Inject

class SignUpRouterImpl @Inject constructor(
    private val sendEmailVerificationLetterUseCase:SendEmailVerificationLetterUseCase
): SignUpRouter {

    override suspend fun sendEmailVerification() {
      return sendEmailVerificationLetterUseCase.send()
    }
}