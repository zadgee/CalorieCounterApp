package glue.sign_in.repo
import com.test.sign_in.domain.event.ValidationResultSignIn
import com.test.sign_in.domain.repo.ValidationRepositorySignIn
import domain.usecases.ValidateEmailUseCase
import domain.usecases.ValidatePasswordUseCase
import glue.sign_in.mapper.toValidationResultSignIn

class ValidationRepositorySignInSignInImpl : ValidationRepositorySignIn {

    override suspend fun validateEmail(email: String): ValidationResultSignIn {
        return ValidateEmailUseCase().validate(email).toValidationResultSignIn()
    }

    override suspend fun validatePassword(password: String): ValidationResultSignIn {
        return ValidatePasswordUseCase().validate(password).toValidationResultSignIn()
    }
}