package com.test.forgot_password.presentation.router

interface ForgotPasswordRouter {
    suspend fun sendResetPasswordEmail(email: String)
}