package application
import android.app.Application
import androidx.work.Configuration
import androidx.work.WorkManager
import app.DaggerDatabaseComponent
import com.test.email_verification.presentation.componentProvider.EmailVerificationComponentProvider
import com.test.email_verification.presentation.fragment.EmailVerificationFragment
import com.test.forgot_password.presentation.componentProvider.ForgotPasswordComponentProvider
import com.test.forgot_password.presentation.fragment.ForgotPasswordFragment
import com.test.sign_in.presentation.componentProvider.SignInComponentProvider
import com.test.sign_in.presentation.fragment.SignInFragment
import com.test.sign_up.presentation.componentProvider.SignUpComponentProvider
import com.test.sign_up.presentation.fragment.SignUpFragment
import app.RoomModule
import application.di.DaggerApplicationComponent
import application.di.UseCasesModule
import componentProvider.CongratsComponentProvider
import domain.di.DaggerAuthComponent
import domain.di.AuthModule
import glue.congrats.CongratsModule
import glue.email_verification.di.EmailVerificationModule
import glue.forgot_password.di.ForgotPasswordModule
import glue.navigation.DaggerNavigationComponent
import glue.sign_in.di.SignInModule
import glue.sign_up.di.SignUpModule
import presentation.fragment.FragmentCongrats

class CalorieCountingApplication:Application(), SignUpComponentProvider, SignInComponentProvider,
  EmailVerificationComponentProvider,ForgotPasswordComponentProvider, CongratsComponentProvider,
  Configuration.Provider
{

    private val authComponent = DaggerAuthComponent
        .builder()
        .authModule(AuthModule(this))
        .build()

    private val databaseComponent = DaggerDatabaseComponent
        .builder()
        .roomModule(RoomModule(this))
        .build()

    private val navigationComponent = DaggerNavigationComponent
        .builder()
        .build()

    private val applicationComponent = DaggerApplicationComponent
        .builder()
        .authComponent(authComponent)
        .navigationComponent(navigationComponent)
        .databaseComponent(databaseComponent)
        .useCasesModule(UseCasesModule(
            authComponent, databaseComponent
        ))
        .build()

    private val signInComponent by lazy {
        applicationComponent.signInComponent()
            .signInModule(SignInModule(navigationComponent))
            .build()
    }

    private val signUpComponent = applicationComponent
        .signUpComponent()
        .signUpModule(SignUpModule(navigationComponent))
        .build()



    private val emailVerificationComponent by lazy {
        applicationComponent
            .emailVerificationComponent()
            .emailVerificationModule(
            EmailVerificationModule(
                context = this,
                navigationComponent = navigationComponent
            )
        ).build()
    }

    private val forgotPasswordComponent by lazy {
             applicationComponent
            .forgotPasswordComponent()
            .forgotPasswordModule(
                ForgotPasswordModule(navigationComponent
                ))
            .build()
    }

    private val congratsComponent by lazy {
        applicationComponent
            .congratsComponent()
            .congratsModule(CongratsModule(navigationComponent))
            .build()
    }

    override fun provideViewModelFactory(fragment: EmailVerificationFragment) {
        return emailVerificationComponent.inject(fragment)
    }

    override fun provideViewModelFactory(fragment: ForgotPasswordFragment) {
        return forgotPasswordComponent.inject(fragment)
    }

    override fun provideViewModelFactory(fragment: SignInFragment) {
        return signInComponent.inject(fragment)
    }

    override fun provideSignUpComponent(fragment: SignUpFragment) {
        return signUpComponent.inject(fragment)
    }

    override fun inject(fragment: FragmentCongrats) {
        return congratsComponent.inject(fragment)
    }

    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder().build()

    override fun onCreate() {
        super.onCreate()
        WorkManager.initialize(
            this, Configuration.Builder().build()
        )
    }

}