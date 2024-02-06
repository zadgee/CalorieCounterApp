package glue.profile.mapper
import domain.models.GmailUserEntity
import domain.models.UserEntity
import domain.repo.ProfileUserDataDefaultAuthModel
import domain.repo.ProfileUserDataGmailAuthModel

fun GmailUserEntity.toProfileUserDataGmailAuthModel():ProfileUserDataGmailAuthModel{
    return ProfileUserDataGmailAuthModel(
        name = name,
        imageUrl = photoUrl
    )
}

fun UserEntity.toProfileUserDataDefaultAuthModel(): ProfileUserDataDefaultAuthModel {
    return ProfileUserDataDefaultAuthModel(
        name = name,
        photoProfile = com.nutrition.core.R.drawable.profile
    )
}