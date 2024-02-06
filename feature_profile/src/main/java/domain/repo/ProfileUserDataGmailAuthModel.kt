package domain.repo

data class ProfileUserDataGmailAuthModel(
    val name:String?,
    val imageUrl:String,
)

data class ProfileUserDataDefaultAuthModel(
    val name:String,
    val photoProfile:Int?
)