package com.test.email_verification.presentation.componentProvider

import com.test.email_verification.presentation.fragment.EmailVerificationFragment

interface EmailVerificationComponentProvider {
    fun provideViewModelFactory(fragment:EmailVerificationFragment)
}