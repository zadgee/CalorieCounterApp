package com.test.sign_in.presentation.componentProvider

import com.test.sign_in.presentation.fragment.SignInFragment

interface SignInComponentProvider{
    fun provideViewModelFactory(fragment: SignInFragment)
}