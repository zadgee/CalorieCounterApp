package domain.event

sealed class SignUpEvent {
    data object Success : SignUpEvent()
    data class Error(val error: String) : SignUpEvent()
    data object Loading : SignUpEvent()
}