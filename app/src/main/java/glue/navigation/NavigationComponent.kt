package glue.navigation
import com.test.email_verification.presentation.router.EmailVerificationNavigationRouter
import com.test.sign_in.presentation.router.SignInNavigationRouter
import com.test.sign_up.presentation.router.SignUpNavigationRouter
import dagger.Component
import router.CongratsNavRouter

@Component(
    modules = [
        NavigationModule::class
    ]
)
interface NavigationComponent{
    @Component.Builder
    interface Builder{
        fun build(): NavigationComponent
    }
    fun getSignUpNavigationRouter(): SignUpNavigationRouter
    fun getSignInNavigationRouter(): SignInNavigationRouter
    fun getEmailVerificationNavigationRouter(): EmailVerificationNavigationRouter
    fun getCongratsNavRouter(): CongratsNavRouter
}