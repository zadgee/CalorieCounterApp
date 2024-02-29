package glue.search.di
import android.content.Context
import dagger.Module
import dagger.Provides
import domain.SearchNavigationRouter
import domain.SearchRepository
import glue.search.router.SearchNavigationRouterImpl
import glue.search.repo.SearchRepositoryImpl
import presentation.viewModel.SearchViewModelFactory

@Module
class SearchModule(
    private val context:Context
) {

    @Provides
    fun provideSearchRepository():SearchRepository{
        return SearchRepositoryImpl(context)
    }

    @Provides
    fun provideNavigationRouter():SearchNavigationRouter{
        return SearchNavigationRouterImpl()
    }

    @Provides
    fun provideViewModelFactory(
        repository: SearchRepository,
        router:SearchNavigationRouter
    ): SearchViewModelFactory {
        return SearchViewModelFactory(
            repository = repository,
            navigationRouter = router
        )
    }

}