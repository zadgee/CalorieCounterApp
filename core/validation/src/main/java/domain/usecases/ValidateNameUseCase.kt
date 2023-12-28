package domain.usecases

import android.util.Patterns
import domain.models.ValidationResult

class ValidateNameUseCase {

    fun validate(name:String): ValidationResult {
        val containsDigits = name.any {
            it.isDigit()
        }
        val firstChar = name.firstOrNull()

        if(name.isEmpty()){
            return ValidationResult(
                successful = false,
                error = "Your name must not be empty"
            )
        } else if(containsDigits || name.length == 1){
            return ValidationResult(
                successful = false,
                error = "Invalid name"
            )
        } else if(firstChar == null || !firstChar.isUpperCase()){
            return ValidationResult(
                successful = false,
                error = "Capital letter required"
            )
        } else if(Patterns.EMAIL_ADDRESS.matcher(name).matches()){
            return ValidationResult(
                successful = false,
                error = "Invalid name"
            )
        }
        return ValidationResult(
            successful = true,
            error = null
        )
    }

}