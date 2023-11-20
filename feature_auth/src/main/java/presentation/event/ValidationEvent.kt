package presentation.event

sealed class ValidationEvent {
    data class ValidationProcess(val name:String,val email:String,val password:String):ValidationEvent()
}