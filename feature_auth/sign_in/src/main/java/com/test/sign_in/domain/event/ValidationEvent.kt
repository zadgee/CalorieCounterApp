package com.test.sign_in.domain.event

sealed class ValidationEvent {
    data class ValidationProcess(val email:String,val password:String):
        ValidationEvent()
}