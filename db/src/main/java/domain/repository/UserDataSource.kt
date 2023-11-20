package domain.repository

import domain.models.GmailUserEntity
import domain.models.UserEntity

interface UserDataSource {
    suspend fun insertUser(userEntity: UserEntity)
    suspend fun getUser(): UserEntity?
    suspend fun insertGmailUser(gmailUserEntity: GmailUserEntity)
    suspend fun getGmailUser(): GmailUserEntity?
}