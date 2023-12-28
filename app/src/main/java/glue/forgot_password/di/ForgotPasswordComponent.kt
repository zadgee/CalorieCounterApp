package glue.forgot_password.di
import com.test.forgot_password.presentation.fragment.ForgotPasswordFragment
import dagger.Subcomponent

@Subcomponent(
    modules = [
        ForgotPasswordModule::class,
    ]
)
interface ForgotPasswordComponent{
    @Subcomponent.Builder
    interface Builder {
        fun forgotPasswordModule(module: ForgotPasswordModule): Builder
        fun build(): ForgotPasswordComponent
    }
    fun inject(fragment: ForgotPasswordFragment)
}