package com.test.forgot_password.domain.event

data class ValidationResultForgotPassword(
    val successful: Boolean,
    val errorMessage: String?=null
)
