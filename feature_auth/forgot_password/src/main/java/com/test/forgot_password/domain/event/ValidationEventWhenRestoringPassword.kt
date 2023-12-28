package com.test.forgot_password.domain.event

sealed class ValidationEventWhenRestoringPassword{
    data class ValidationProcess(
        val email: String
    ): ValidationEventWhenRestoringPassword()
}

data class ValidationModel(
    val email: String="",
    val emailError: String?=null
)