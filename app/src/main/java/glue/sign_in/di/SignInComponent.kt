package glue.sign_in.di
import com.test.sign_in.presentation.fragment.SignInFragment
import dagger.Subcomponent


@Subcomponent(
    modules = [
        SignInModule::class,
    ]
)
interface SignInComponent{
    @Subcomponent.Builder
    interface Builder {
        fun signInModule(module: SignInModule): Builder
        fun build(): SignInComponent
    }
    fun inject(fragment: SignInFragment)
}