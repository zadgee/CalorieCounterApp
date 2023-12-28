package glue.sign_up.di
import com.test.sign_up.domain.repo.SignUpRepository
import com.test.sign_up.domain.repo.ValidationRepositorySignUp
import com.test.sign_up.presentation.router.SignUpRouter
import com.test.sign_up.presentation.viewModel.SignUpViewModelFactory
import dagger.Module
import dagger.Provides
import domain.usecases.SendEmailVerificationLetterUseCase
import domain.usecases.SignUpUseCase
import glue.navigation.NavigationComponent
import glue.sign_up.repo.SignUpRepositoryImpl
import glue.sign_up.repo.ValidationRepositorySignUpImpl
import glue.sign_up.router.SignUpRouterImpl


@Module
class SignUpModule(
    private val navigationComponent: NavigationComponent
) {


    @Provides
    fun provideSignUpRepository(
        signUpUseCase: SignUpUseCase
    ): SignUpRepository {
        return SignUpRepositoryImpl(
            signUpUseCase
        )
    }

    @Provides
    fun provideValidationRepository():ValidationRepositorySignUp{
        return ValidationRepositorySignUpImpl()
    }

    @Provides
    fun provideRouter(
        sendEmailVerificationLetterUseCase: SendEmailVerificationLetterUseCase
    ): SignUpRouter {
        return SignUpRouterImpl(
            sendEmailVerificationLetterUseCase = sendEmailVerificationLetterUseCase,
        )
    }

    @Provides
    fun provideViewModelFactory(
        router: SignUpRouter,
        validationRepositorySignUp:ValidationRepositorySignUp,
        signUpRepository:SignUpRepository,
    ): SignUpViewModelFactory {
        return SignUpViewModelFactory(
            router = router,
            validationRepositorySignUp = validationRepositorySignUp,
            signUpRepository = signUpRepository,
            signUpNavigationRouter = navigationComponent.getSignUpNavigationRouter()
        )
    }
}