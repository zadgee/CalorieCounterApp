package domain.models

data class ValidationResult(
    val successful:Boolean,
    val error:String?=null
)