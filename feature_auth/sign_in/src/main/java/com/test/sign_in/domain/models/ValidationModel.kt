package com.test.sign_in.domain.models

data class ValidationModel(
    val email:String="",
    val password:String="",
    val emailError:String?,
    val passwordError:String?
)