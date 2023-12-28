package glue.navigationRouters

import com.test.sign_up.presentation.router.SignUpNavigationRouter
import glue.navigation.SignUpToEmailVerification
import glue.navigation.SignUpToSignIn
import javax.inject.Inject

class SignUpNavigationRouterImpl @Inject constructor(
   @SignUpToEmailVerification private val signUpToEmailVerificationActionId:Int,
   @SignUpToSignIn private val signUpToSignInActionId:Int
): SignUpNavigationRouter  {
    override fun navigateSignUpToEmailVerification(): Int {
        return signUpToEmailVerificationActionId
    }

    override fun navigateSignUpToSignIn(): Int {
       return signUpToSignInActionId
    }
}