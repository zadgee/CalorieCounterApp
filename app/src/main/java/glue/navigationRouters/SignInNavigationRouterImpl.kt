package glue.navigationRouters

import com.test.sign_in.presentation.router.SignInNavigationRouter
import glue.navigation.SignInToEmailVerification
import glue.navigation.SignInToForgotPassword
import glue.navigation.SignInToHome
import javax.inject.Inject

class SignInNavigationRouterImpl @Inject constructor(
    @SignInToEmailVerification private val signInToEmailVerificationActionId:Int,
    @SignInToHome private val signInToHomeActionId:Int,
    @SignInToForgotPassword private val signInToForgotPasswordActionId:Int
):SignInNavigationRouter {
    override fun navigateSignInToEmailVerification(): Int {
        return signInToEmailVerificationActionId
    }

    override fun navigateSignInToHome(): Int {
       return signInToHomeActionId
    }

    override fun navigateSignInToForgotPassword(): Int {
        return signInToForgotPasswordActionId
    }
}