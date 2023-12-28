package com.test.sign_in.domain.repo

import com.test.sign_in.domain.event.ValidationResultSignIn

interface ValidationRepositorySignIn {
    suspend fun validateEmail(email:String):ValidationResultSignIn
    suspend fun validatePassword(password:String):ValidationResultSignIn
}