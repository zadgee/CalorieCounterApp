package glue.sign_up.mapper

import com.test.sign_up.domain.event.EventSignUp
import com.test.sign_up.domain.event.ValidationResultSignUp
import domain.models.ValidationResult
import domain.event.SignUpEvent

fun SignUpEvent.toEventSignUp():EventSignUp{
    return when(this){
        is SignUpEvent.Error -> EventSignUp.Error(this.error)
        is SignUpEvent.Loading -> EventSignUp.Loading
        is SignUpEvent.Success -> EventSignUp.Success
    }
}

fun ValidationResult.toValidationResultSignUp():ValidationResultSignUp{
    return ValidationResultSignUp(
        successful = successful,
        errorMessage = error
    )
}