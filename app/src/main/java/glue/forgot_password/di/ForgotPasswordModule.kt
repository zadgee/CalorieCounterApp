package glue.forgot_password.di
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.test.forgot_password.domain.repo.EmailValidationRepository
import com.test.forgot_password.presentation.fragment.ForgotPasswordFragment
import com.test.forgot_password.presentation.router.ForgotPasswordRouter
import com.test.forgot_password.presentation.viewmodel.ForgotPasswordViewModelFactory
import dagger.Module
import dagger.Provides
import domain.usecases.SendPasswordResetEmailUseCase
import glue.forgot_password.router.ForgotPasswordRouterImpl
import glue.forgot_password.repo.EmailValidationRepositoryImpl
import glue.navigation.NavigationComponent


@Module
class ForgotPasswordModule(
    private val navigationComponent: NavigationComponent
) {

    @Provides
    fun provideEmailValidationRepository():EmailValidationRepository{
        return EmailValidationRepositoryImpl()
    }

    @Provides
    fun provideNavController():NavController{
        return ForgotPasswordFragment().findNavController()
    }

    @Provides
    fun provideRouter(
        sendPasswordResetEmailUseCase: SendPasswordResetEmailUseCase
    ):ForgotPasswordRouter{
        return ForgotPasswordRouterImpl(
            sendPasswordResetEmailUseCase = sendPasswordResetEmailUseCase
        )
    }

    @Provides
    fun provideViewModelFactory(
        emailValidationRepository: EmailValidationRepository,
        router:ForgotPasswordRouter,
    ):ForgotPasswordViewModelFactory{
        return ForgotPasswordViewModelFactory(
            repository = emailValidationRepository,
            router = router
        )
    }


}