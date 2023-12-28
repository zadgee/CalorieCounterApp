package com.test.email_verification.domain.repo


interface EmailVerificationRepository{
    suspend fun reloadUser():Boolean
    suspend fun sendEmailVerificationLetter()
    suspend fun deleteUserFromFirebase()
    suspend fun signOutWhileUsingGmailAuth()
    suspend fun signOutWhileUsingEmailPassword()
    suspend fun addUserToFireStore(name:String,email:String,password:String)
}