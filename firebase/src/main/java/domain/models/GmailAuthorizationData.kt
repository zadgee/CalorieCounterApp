package domain.models



data class GmailAuthorizationData(
    val id:String,
    val name:String?,
    val pictureUrl:String?=null,
    val email:String
)
