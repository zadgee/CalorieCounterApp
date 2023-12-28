package glue.email_verification.di
import com.test.email_verification.presentation.fragment.EmailVerificationFragment
import dagger.Subcomponent

@Subcomponent(
    modules = [
        EmailVerificationModule::class
    ]
)
interface EmailVerificationComponent{
    @Subcomponent.Builder
    interface Builder{
        fun emailVerificationModule(emailVerificationModule: EmailVerificationModule): Builder
        fun build(): EmailVerificationComponent
    }
    fun inject(fragment: EmailVerificationFragment)
}