package domain.repo

import kotlinx.coroutines.flow.Flow

interface ProfileRepository{
    suspend fun signOutWhileUsingGmailAuth()
    suspend fun signOutWhileUsingEmailPassword()
    suspend fun deleteUserFromLocalDB(user: UserToBeDeleted)
    suspend fun deleteGmailUserFromDB(user:GmailUserToBeDeleted)
    suspend fun getProfileUserDataGmailAuth(): Flow<ProfileUserDataGmailAuthModel>
    suspend fun getProfileUserDataDefaultAuth(): Flow<ProfileUserDataDefaultAuthModel>
}