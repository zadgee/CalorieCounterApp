package domain.repo

data class UserToBeDeleted(
    val name:String,
    val email:String,
    val password:String,
    val whenAuthorized:String,
)
