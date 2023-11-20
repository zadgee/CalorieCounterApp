package domain.models.user



data class GmailAuthorizationData(
    val id:String,
    val name:String?,
    val pictureUrl:String?=null
)
