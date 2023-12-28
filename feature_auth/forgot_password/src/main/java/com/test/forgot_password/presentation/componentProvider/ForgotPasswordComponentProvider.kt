package com.test.forgot_password.presentation.componentProvider

import com.test.forgot_password.presentation.fragment.ForgotPasswordFragment

interface ForgotPasswordComponentProvider {
    fun provideViewModelFactory(fragment: ForgotPasswordFragment)
}