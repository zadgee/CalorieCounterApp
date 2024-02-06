package com.test.email_verification.domain.models

data class UserModel(
    val name: String,
    val email: String,
    val password: String,
    val whenAuthorized: String
)