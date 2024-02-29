package presentation.viewModel
import android.graphics.Typeface
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import domain.SearchNavigationRouter
import domain.SearchRepository
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val navigationRouter: SearchNavigationRouter,
    private val repository: SearchRepository
):ViewModel() {

    fun pathToTextFieldsFont(fontId:Int):Typeface{
        return repository.setupSearchViewFont(fontId)
    }

}

class SearchViewModelFactory @Inject constructor(
    private val navigationRouter: SearchNavigationRouter,
    private val repository: SearchRepository
):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SearchViewModel(
            navigationRouter,
            repository
        ) as T
    }
}