package glue.sign_up.repo
import com.test.sign_up.domain.event.ValidationResultSignUp
import com.test.sign_up.domain.repo.ValidationRepositorySignUp
import domain.usecases.ValidateEmailUseCase
import domain.usecases.ValidateNameUseCase
import domain.usecases.ValidatePasswordUseCase
import glue.sign_up.mapper.toValidationResultSignUp

class ValidationRepositorySignUpImpl:ValidationRepositorySignUp{
    override suspend fun validateName(name: String): ValidationResultSignUp {
        return ValidateNameUseCase().validate(name).toValidationResultSignUp()
    }

    override suspend fun validateEmail(email: String): ValidationResultSignUp {
        return ValidateEmailUseCase().validate(email).toValidationResultSignUp()
    }

    override suspend fun validatePassword(password: String): ValidationResultSignUp {
        return ValidatePasswordUseCase().validate(password).toValidationResultSignUp()
    }

}