package domain.models.validationModel

data class ValidationModel(
    val name:String="",
    val email:String="",
    val password:String="",
    val nameError:String?,
    val emailError:String?,
    val passwordError:String?
)
