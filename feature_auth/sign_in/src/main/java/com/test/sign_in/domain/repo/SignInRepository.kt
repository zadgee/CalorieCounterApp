package com.test.sign_in.domain.repo

import com.test.sign_in.domain.event.EventSignIn

interface SignInRepository {
    suspend fun signIn(email:String,password:String):EventSignIn
}