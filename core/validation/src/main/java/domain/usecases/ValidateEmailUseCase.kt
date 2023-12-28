package domain.usecases

import android.util.Patterns
import domain.models.ValidationResult

class ValidateEmailUseCase {

    fun validate(email:String): ValidationResult {
        if(email.isEmpty()){
            return ValidationResult(
                successful = false,
                error = "Email is required"
            )
        }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return ValidationResult(
                successful = false,
                error = "Invalid email"
            )
        }
        return ValidationResult(
            successful = true,
            error = null
        )
    }

}