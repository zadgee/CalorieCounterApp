package application.di
import app.DatabaseComponent
import dagger.Component
import domain.di.AuthComponent
import glue.congrats.CongratsComponent
import glue.email_verification.di.EmailVerificationComponent
import glue.forgot_password.di.ForgotPasswordComponent
import glue.navigation.NavigationComponent
import glue.profile.di.ProfileComponent
import glue.sign_in.di.SignInComponent
import glue.sign_up.di.SignUpComponent

@Component(
    dependencies = [
        AuthComponent::class,
        DatabaseComponent::class,
        NavigationComponent::class
    ],
    modules = [
        UseCasesModule::class
    ]
    )
@ApplicationScope
interface ApplicationComponent{
    fun signUpComponent():SignUpComponent.Builder
    fun signInComponent():SignInComponent.Builder
    fun emailVerificationComponent():EmailVerificationComponent.Builder
    fun forgotPasswordComponent():ForgotPasswordComponent.Builder
    fun congratsComponent(): CongratsComponent.Builder
    fun profileComponent():ProfileComponent.Builder

    @Component.Builder
    interface Builder{
        fun authComponent(authComponent: AuthComponent): Builder
        fun databaseComponent(databaseComponent: DatabaseComponent): Builder
        fun useCasesModule(useCasesModule: UseCasesModule):Builder
        fun navigationComponent(navigationComponent: NavigationComponent):Builder
        fun build(): ApplicationComponent
    }
}