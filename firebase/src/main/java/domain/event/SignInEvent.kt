package domain.event

sealed class SignInEvent{
    data class Success(val result: Any): SignInEvent()
    data class Error(val error:String): SignInEvent()
    object Loading: SignInEvent()
}