package domain.usecases

sealed class ValidationEventWhenSignIn{
    data class ValidationProcess(val email:String,val password:String): ValidationEventWhenSignIn()
}