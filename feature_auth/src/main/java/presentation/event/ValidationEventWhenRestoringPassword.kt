package presentation.event

sealed class ValidationEventWhenRestoringPassword{
    data class ValidationProcess(
        val email: String
    ):ValidationEventWhenRestoringPassword()
}
