package domain.event

data class ValidationResult(
    val successful:Boolean,
    val error:String?=null
)
