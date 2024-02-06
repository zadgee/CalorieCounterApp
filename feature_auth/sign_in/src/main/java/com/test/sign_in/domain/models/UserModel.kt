package com.test.sign_in.domain.models

data class UserModel(
    val name:String,
    val email:String,
    val password:String,
    val whenAuthorized:String
)