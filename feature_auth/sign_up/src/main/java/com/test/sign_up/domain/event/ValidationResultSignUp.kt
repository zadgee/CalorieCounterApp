package com.test.sign_up.domain.event

data class ValidationResultSignUp(
    val successful: Boolean,
    val errorMessage: String?=null
)