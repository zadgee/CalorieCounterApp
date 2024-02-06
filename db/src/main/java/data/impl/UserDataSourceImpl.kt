package data.impl

import android.util.Log
import data.dao.UserDAO
import domain.models.GmailUserEntity
import domain.models.UserEntity
import domain.repository.UserDataSource
import javax.inject.Inject
private const val ERROR_WHILE_SAVING_USER_TO_DB = "SavingToDatabaseError"

class UserDataSourceImpl @Inject constructor(
    private val userDAO: UserDAO
) : UserDataSource {
    override suspend fun insertUser(userEntity: UserEntity) {
        try {
            userDAO.insertUser(userEntity)
        }catch (e:Exception){
            Log.d(ERROR_WHILE_SAVING_USER_TO_DB, e.message ?: "Unknown error")
        }
    }

    override suspend fun getUser(): UserEntity? {
       return userDAO.getAuthorizedUserData()
    }

    override suspend fun insertGmailUser(gmailUserEntity: GmailUserEntity) {
        try {
            userDAO.insertGmailUser(gmailUserEntity)
        }catch (e:Exception){
            Log.d(ERROR_WHILE_SAVING_USER_TO_DB, e.message ?: "Unknown error")
        }
    }

    override suspend fun getGmailUser(): GmailUserEntity? {
        return userDAO.getGmailUser()
    }

    override suspend fun deleteUserFromDB(user: UserEntity) {
        return userDAO.deleteUserFromDB(user)
    }

    override suspend fun deleteGmailUserFromDB(user: GmailUserEntity) {
        return userDAO.deleteGmailUserFromDB(user)
    }

}