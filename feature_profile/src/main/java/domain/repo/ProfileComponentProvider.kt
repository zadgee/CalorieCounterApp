package domain.repo

import presentation.fragment.UserProfileFragment

interface ProfileComponentProvider{
    fun provideProfileComponent(fragment:UserProfileFragment)
}