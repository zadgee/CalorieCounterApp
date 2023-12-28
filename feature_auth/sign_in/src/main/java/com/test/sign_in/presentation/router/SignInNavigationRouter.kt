package com.test.sign_in.presentation.router

interface SignInNavigationRouter {
    fun navigateSignInToEmailVerification():Int
    fun navigateSignInToHome():Int
    fun navigateSignInToForgotPassword():Int
}