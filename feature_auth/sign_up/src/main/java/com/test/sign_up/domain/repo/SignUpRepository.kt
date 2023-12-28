package com.test.sign_up.domain.repo

import com.test.sign_up.domain.event.EventSignUp

interface SignUpRepository {
    suspend fun signUp(email: String, password: String): EventSignUp
}