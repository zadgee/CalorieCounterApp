package com.test.sign_in.domain.event

data class ValidationResultSignIn(
    val successful:Boolean,
    val errorMessage:String?=null
)