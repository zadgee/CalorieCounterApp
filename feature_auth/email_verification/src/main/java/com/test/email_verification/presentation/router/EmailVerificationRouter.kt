package com.test.email_verification.presentation.router

import com.test.email_verification.domain.models.UserModel

interface EmailVerificationRouter{
    suspend fun saveUserToDB(user:UserModel)
}