package com.test.sign_up.presentation.componentProvider

import com.test.sign_up.presentation.fragment.SignUpFragment

interface SignUpComponentProvider{
    fun provideSignUpComponent(fragment: SignUpFragment)
}