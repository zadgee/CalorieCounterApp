package glue.navigation
import com.nutrition.caloriecountingapp.R
import com.test.email_verification.presentation.fragment.EmailVerificationFragment
import com.test.email_verification.presentation.router.EmailVerificationNavigationRouter
import com.test.forgot_password.presentation.fragment.ForgotPasswordFragment
import com.test.sign_in.presentation.fragment.SignInFragment
import com.test.sign_in.presentation.router.SignInNavigationRouter
import com.test.sign_up.presentation.fragment.SignUpFragment
import com.test.sign_up.presentation.router.SignUpNavigationRouter
import dagger.Module
import dagger.Provides
import domain.repo.ProfileNavRouter
import glue.email_verification.di.EmailVerificationComponent
import glue.forgot_password.di.ForgotPasswordComponent
import glue.navigationRouters.CongratsNavRouterImpl
import glue.navigationRouters.EmailVerificationNavRouterImpl
import glue.navigationRouters.ProfileNavigationNavRouterImpl
import glue.navigationRouters.SignInNavigationRouterImpl
import glue.navigationRouters.SignUpNavigationRouterImpl
import glue.profile.di.ProfileComponent
import glue.sign_in.di.SignInComponent
import glue.sign_up.di.SignUpComponent
import presentation.fragment.FragmentCongrats
import router.CongratsNavRouter

@Module(
    subcomponents = [
        SignUpComponent::class,
        SignInComponent::class,
        EmailVerificationComponent::class,
        ForgotPasswordComponent::class,
        ProfileComponent::class
    ]
)
class NavigationModule {

    @Provides
    @SignUpToSignIn
    fun provideSignUpToSignInActionId():Int{
        return R.id.action_signUpFragment_to_signInFragment
    }

    @Provides
    @SignUpToEmailVerification
    fun provideSignUpToEmailVerificationActionId():Int{
        return R.id.action_signUpFragment_to_emailVerificationFragment
    }

    @Provides
    @CongratsToHome
    fun provideCongratsToHomeActionId():Int{
        return R.id.action_fragmentCongrats_to_homeFragment
    }

    @Provides
    @EmailVerificationToCongrats
    fun provideEmailVerificationToCongratsActionId():Int{
        return R.id.action_emailVerificationFragment_to_fragmentCongrats
    }

    @Provides
    @SignInToEmailVerification
    fun provideSignInToEmailVerificationActionId():Int{
        return R.id.action_signInFragment_to_emailVerificationFragment
    }

    @Provides
    @SignInToHome
    fun provideSignInToHomeActionId():Int{
        return R.id.action_signInFragment_to_homeFragment
    }

    @Provides
    @SignInToForgotPassword
    fun provideSignInToForgotPasswordActionId():Int{
        return R.id.action_signInFragment_to_forgotPasswordFragment
    }

    @Provides
    @NavigationScope
    fun provideSignUpNavRouter(
        @SignUpToSignIn signUpToSignInActionId:Int,
        @SignUpToEmailVerification signUpToEmailVerificationActionId:Int
    ):SignUpNavigationRouter{
        return SignUpNavigationRouterImpl(
            signUpToEmailVerificationActionId = signUpToEmailVerificationActionId,
            signUpToSignInActionId = signUpToSignInActionId
        )
    }

    @Provides
    @NavigationScope
    fun provideSignInNavRouter(
        @SignInToEmailVerification signInToEmailVerificationActionId:Int,
        @SignInToHome signInToHomeActionId:Int,
        @SignInToForgotPassword signInToForgotPasswordActionId:Int
    ): SignInNavigationRouter {
        return SignInNavigationRouterImpl(
            signInToEmailVerificationActionId = signInToEmailVerificationActionId,
            signInToHomeActionId = signInToHomeActionId,
            signInToForgotPasswordActionId = signInToForgotPasswordActionId
        )
    }

    @Provides
    @NavigationScope
    fun provideEmailVerificationNavRouter(
        @EmailVerificationToCongrats emailVerificationToCongratsActionId:Int
    ):EmailVerificationNavigationRouter{
        return EmailVerificationNavRouterImpl(
            emailVerificationToCongratsActionId = emailVerificationToCongratsActionId
        )
    }

    @Provides
    @NavigationScope
    fun provideCongratsNavRouter(
       @CongratsToHome congratsToHomeActionId:Int
    ):CongratsNavRouter{
        return CongratsNavRouterImpl(
            congratsToHomeActionId = congratsToHomeActionId
        )
    }

    @Provides
    fun signInFragment():SignInFragment{
        return SignInFragment()
    }

    @Provides
    fun signUpFragment(): SignUpFragment {
        return SignUpFragment()
    }

    @Provides
    fun forgotPasswordFragment(): ForgotPasswordFragment {
        return ForgotPasswordFragment()
    }

    @Provides
    fun emailVerificationFragment(): EmailVerificationFragment {
        return EmailVerificationFragment()
    }

    @Provides
    fun provideCongratsFragment():FragmentCongrats{
        return FragmentCongrats()
    }

    @Provides
    @ProfileToSignUp
    fun provideProfileToSignUpActionId():Int{
        return R.id.action_profileFragment_to_signUpFragment
    }

    @Provides
    @ProfileToSignIn
    fun provideProfileToSignInActionId():Int{
        return R.id.action_profileFragment_to_signInFragment
    }

    @Provides
    fun provideProfileNavRouter(
        @ProfileToSignIn profileToSignIn:Int,
        @ProfileToSignUp profileToSignUp:Int
    ):ProfileNavRouter{
        return ProfileNavigationNavRouterImpl(
            profileToSignIn = profileToSignIn,
            profileToSignUp = profileToSignUp
        )
    }

}