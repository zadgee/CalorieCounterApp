package presentation.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import router.CongratsNavRouter
import javax.inject.Inject

class CongratsViewModel @Inject constructor(
    private val congratsNavRouter: CongratsNavRouter
):ViewModel(){

    fun navigateCongratsToHome():Int{
        return congratsNavRouter.navigateCongratsToHome()
    }

}


class CongratsViewModelFactory @Inject constructor(
    private val congratsNavRouter: CongratsNavRouter
): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CongratsViewModel(congratsNavRouter) as T
    }

}