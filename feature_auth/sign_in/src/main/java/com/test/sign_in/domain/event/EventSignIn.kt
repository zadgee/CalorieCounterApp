package com.test.sign_in.domain.event

sealed class EventSignIn{
    data class Success(val result: Any): EventSignIn()
    data class Error(val error:String): EventSignIn()
    object Loading: EventSignIn()
}