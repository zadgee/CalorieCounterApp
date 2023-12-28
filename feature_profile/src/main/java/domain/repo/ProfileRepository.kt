package domain.repo

interface ProfileRepository{
    suspend fun signOutWhileUsingGmailAuth()
    suspend fun signOutWhileUsingEmailPassword()
    suspend fun deleteUserFromLocalDB()
}