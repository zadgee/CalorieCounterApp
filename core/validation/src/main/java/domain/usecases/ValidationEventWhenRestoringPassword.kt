package domain.usecases

sealed class ValidationEventWhenRestoringPassword{
    data class ValidationProcess(
        val email: String
    ): ValidationEventWhenRestoringPassword()
}
