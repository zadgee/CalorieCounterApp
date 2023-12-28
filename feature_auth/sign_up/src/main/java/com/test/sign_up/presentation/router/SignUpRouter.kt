package com.test.sign_up.presentation.router

interface SignUpRouter {
    suspend fun sendEmailVerification()
}