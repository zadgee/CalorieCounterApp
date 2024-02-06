package com.test.sign_in.domain.models

data class GmailUserModel(
    val id:String,
    val name:String?,
    val photoUrl:String,
    val whenAuthorized:String
)