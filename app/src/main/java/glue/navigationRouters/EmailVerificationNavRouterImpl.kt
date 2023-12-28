package glue.navigationRouters

import com.test.email_verification.presentation.router.EmailVerificationNavigationRouter
import glue.navigation.EmailVerificationToCongrats
import javax.inject.Inject

class EmailVerificationNavRouterImpl @Inject constructor(
    @EmailVerificationToCongrats private val emailVerificationToCongratsActionId:Int
):EmailVerificationNavigationRouter {

    override fun navigateToCongrats(): Int {
       return emailVerificationToCongratsActionId
    }
}