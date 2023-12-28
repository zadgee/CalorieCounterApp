package glue.sign_up.di
import com.test.sign_up.presentation.fragment.SignUpFragment
import dagger.Subcomponent

@Subcomponent(
    modules = [
        SignUpModule::class
    ]
)
interface SignUpComponent{
    @Subcomponent.Builder
    interface Builder{
        fun signUpModule(module: SignUpModule): Builder
        fun build(): SignUpComponent
    }
    fun inject(fragment: SignUpFragment)
}