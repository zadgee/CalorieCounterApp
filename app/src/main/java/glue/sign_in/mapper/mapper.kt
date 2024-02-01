package glue.sign_in.mapper
import com.test.sign_in.domain.event.EventSignIn
import com.test.sign_in.domain.event.ValidationResultSignIn
import domain.models.ValidationResult
import domain.di.event.SignInEvent

fun SignInEvent.toEventSignIn(): EventSignIn {
    return when (this) {
        is SignInEvent.Success -> EventSignIn.Success(result)
        is SignInEvent.Error -> EventSignIn.Error(error)
        is SignInEvent.Loading -> EventSignIn.Loading
    }
}

fun ValidationResult.toValidationResultSignIn():ValidationResultSignIn{
    return ValidationResultSignIn(
        successful = successful,
        errorMessage = error
    )
}