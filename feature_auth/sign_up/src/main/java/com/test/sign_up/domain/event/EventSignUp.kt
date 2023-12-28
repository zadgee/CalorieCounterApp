package com.test.sign_up.domain.event

sealed class EventSignUp{
    data object Success : EventSignUp()
    data class Error(val error:String): EventSignUp()
    object Loading : EventSignUp()
}
