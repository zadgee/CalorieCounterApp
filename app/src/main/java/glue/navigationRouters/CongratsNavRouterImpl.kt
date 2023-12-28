package glue.navigationRouters

import glue.navigation.CongratsToHome
import router.CongratsNavRouter
import javax.inject.Inject

class CongratsNavRouterImpl @Inject constructor(
    @CongratsToHome private val congratsToHomeActionId:Int
):CongratsNavRouter {
    override fun navigateCongratsToHome(): Int {
       return congratsToHomeActionId
    }
}