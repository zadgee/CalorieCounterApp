package glue.congrats

import dagger.Subcomponent
import presentation.fragment.FragmentCongrats

@Subcomponent(
    modules = [
       CongratsModule::class
    ]
)
interface CongratsComponent{
    @Subcomponent.Builder
    interface Builder{
        fun congratsModule(congratsModule: CongratsModule): Builder
        fun build():CongratsComponent
    }
    fun inject(fragment:FragmentCongrats)
}