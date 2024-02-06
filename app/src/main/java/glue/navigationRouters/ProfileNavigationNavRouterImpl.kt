package glue.navigationRouters

import domain.repo.ProfileNavRouter
import glue.navigation.ProfileToSignIn
import glue.navigation.ProfileToSignUp
import javax.inject.Inject

class ProfileNavigationNavRouterImpl @Inject constructor(
    @ProfileToSignIn private val profileToSignIn: Int,
    @ProfileToSignUp private val profileToSignUp: Int
): ProfileNavRouter {

    override fun navigateProfileToSignUpActionId(): Int {
        return profileToSignUp
    }

    override fun navigateProfileToSignInActionId(): Int {
        return profileToSignIn
    }
}