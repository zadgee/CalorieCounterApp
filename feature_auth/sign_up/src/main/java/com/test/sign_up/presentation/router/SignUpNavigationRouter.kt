package com.test.sign_up.presentation.router

interface SignUpNavigationRouter{
    fun navigateSignUpToEmailVerification():Int
    fun navigateSignUpToSignIn():Int
}