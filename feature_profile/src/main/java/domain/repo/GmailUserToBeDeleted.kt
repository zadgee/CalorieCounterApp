package domain.repo

data class GmailUserToBeDeleted(
    val id:String,
    val name:String?,
    val photoUrl:String,
    val whenAuthorized:String?,
)
