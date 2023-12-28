package com.test.sign_up.domain.repo

import com.test.sign_up.domain.event.ValidationResultSignUp

interface ValidationRepositorySignUp {
    suspend fun validateName(name:String):ValidationResultSignUp
    suspend fun validateEmail(email: String): ValidationResultSignUp
    suspend fun validatePassword(password:String): ValidationResultSignUp
}