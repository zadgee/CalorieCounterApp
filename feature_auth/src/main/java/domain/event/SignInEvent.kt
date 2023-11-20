package domain.event

import com.google.firebase.auth.AuthResult

sealed class SignInEvent{
    data class Success(val result: AuthResult): SignInEvent()
    data class Error(val error:String): SignInEvent()
    object Loading:SignInEvent()
}
