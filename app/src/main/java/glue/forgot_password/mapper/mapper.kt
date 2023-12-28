package glue.forgot_password.mapper

import com.test.forgot_password.domain.event.ValidationResultForgotPassword
import domain.models.ValidationResult

fun ValidationResult.toValidationResultForgotPassword(): ValidationResultForgotPassword {
    return ValidationResultForgotPassword(
        successful = successful,
        errorMessage = error
    )
}