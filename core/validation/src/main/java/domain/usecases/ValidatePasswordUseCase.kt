package domain.usecases

import androidx.core.text.isDigitsOnly
import domain.models.ValidationResult

class ValidatePasswordUseCase {

    fun validate(password:String): ValidationResult {
        if(password.isEmpty()){
            return ValidationResult(
                successful = false,
                error = "Password is required"
            )
        } else if(password.length<8){
            return ValidationResult(
                successful = false,
                error = "Password is too small"
            )
        } else if(password.isDigitsOnly()){
            return ValidationResult(
                successful = false,
                error = "Password should contain at least one letter"
            )
        }
        return ValidationResult(
            successful = true,
            error = null
        )
        }
    }
