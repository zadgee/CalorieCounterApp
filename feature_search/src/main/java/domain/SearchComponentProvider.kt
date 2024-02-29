package domain

import presentation.fragment.SearchFragment

interface SearchComponentProvider {
    fun provideViewModelFactory(fragment:SearchFragment)
}