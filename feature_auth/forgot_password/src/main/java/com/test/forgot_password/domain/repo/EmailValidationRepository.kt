package com.test.forgot_password.domain.repo

import com.test.forgot_password.domain.event.ValidationResultForgotPassword

interface EmailValidationRepository {
    suspend fun validateEmail(email: String): ValidationResultForgotPassword
}