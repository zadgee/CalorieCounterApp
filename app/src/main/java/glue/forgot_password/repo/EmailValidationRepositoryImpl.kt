package glue.forgot_password.repo
import com.test.forgot_password.domain.event.ValidationResultForgotPassword
import com.test.forgot_password.domain.repo.EmailValidationRepository
import domain.usecases.ValidateEmailUseCase
import glue.forgot_password.mapper.toValidationResultForgotPassword

class EmailValidationRepositoryImpl : EmailValidationRepository {
    override suspend fun validateEmail(email: String): ValidationResultForgotPassword {
        return ValidateEmailUseCase().validate(email).toValidationResultForgotPassword()
    }
}