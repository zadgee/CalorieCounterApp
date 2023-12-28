package glue.congrats
import dagger.Module
import dagger.Provides
import glue.navigation.NavigationComponent
import presentation.fragment.CongratsViewModelFactory

@Module
class CongratsModule (
    private val navigationComponent: NavigationComponent
){

    @Provides
    fun provideViewModelFactory():CongratsViewModelFactory{
        return CongratsViewModelFactory(
            congratsNavRouter = navigationComponent.getCongratsNavRouter()
        )
    }

}