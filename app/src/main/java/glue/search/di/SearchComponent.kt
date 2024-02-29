package glue.search.di

import dagger.Subcomponent
import presentation.fragment.SearchFragment

@Subcomponent(
    modules = [
      SearchModule::class
    ]
)
interface SearchComponent {
    @Subcomponent.Builder
    interface Builder{
        fun searchModule(searchModule: SearchModule):Builder
        fun build(): SearchComponent
    }
    fun inject(fragment:SearchFragment)
}