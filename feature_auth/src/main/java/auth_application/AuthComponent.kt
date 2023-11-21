package auth_application
import app.DatabaseComponent
import dagger.Component
import data.di.AuthModule
import domain.di.UseCaseModule
import domain.di.WorkerModule
import presentation.auth_fragments.EmailVerificationFragment
import presentation.auth_fragments.ForgotPasswordFragment
import presentation.auth_fragments.SignInFragment
import presentation.auth_fragments.SignUpFragment
import presentation.di.PresentationModule
import presentation.viewModels.AuthenticationViewModelFactory

@Component(
    modules = [
        AuthModule::class,
        UseCaseModule::class,
        PresentationModule::class,
        WorkerModule::class
    ],
    dependencies = [
        DatabaseComponent::class
    ]
)
@AuthScope
interface AuthComponent{

    @Component.Builder
    interface Builder{
        fun authModule(authModule: AuthModule):Builder
        fun workerModule(workerModule: WorkerModule):Builder
        fun databaseComponent(databaseComponent: DatabaseComponent):Builder
        fun buildAuthComponent():AuthComponent
    }

    fun injectSignUpFragment(fragment: SignUpFragment)
    fun injectSignInFragment(fragment: SignInFragment)
    fun injectEmailVerificationFragment(fragment: EmailVerificationFragment)
    fun injectForgotPasswordFragment(fragment: ForgotPasswordFragment)
}