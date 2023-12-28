package glue.email_verification.di
import android.content.Context
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.test.email_verification.domain.repo.EmailVerificationRepository
import com.test.email_verification.domain.worker.EmailVerificationWorker
import com.test.email_verification.presentation.router.EmailVerificationRouter
import com.test.email_verification.presentation.viewModel.EmailVerificationViewModelFactory
import dagger.Module
import dagger.Provides
import domain.usecases.InsertUserUseCase
import glue.email_verification.repo.EmailVerificationRepositoryImpl
import glue.email_verification.router.EmailVerificationRouterImpl
import domain.usecases.AddUserToFireStoreUseCase
import domain.usecases.DeleteUserFromFirebaseUseCase
import domain.usecases.GetFirebaseUserUseCase
import domain.usecases.SendEmailVerificationLetterUseCase
import domain.usecases.SignOutWhileUsingEmailPasswordUseCase
import domain.usecases.SignOutWhileUsingGmailAuth
import glue.navigation.NavigationComponent

@Module
class EmailVerificationModule(
    private val context:Context,
    private val navigationComponent: NavigationComponent,
) {

    @Provides
    fun provideWorkManager():WorkManager{
        return WorkManager.getInstance(context)
    }

    @Provides
    fun provideEmailVerificationRepository(
        addUserToFireStoreUseCase: AddUserToFireStoreUseCase,
        deleteUserFromFirebaseUseCase: DeleteUserFromFirebaseUseCase,
        sendEmailVerificationLetterUseCase: SendEmailVerificationLetterUseCase,
        signOutWhileUsingGmailAuth: SignOutWhileUsingGmailAuth,
        signOutWhileUsingEmailPasswordUseCase: SignOutWhileUsingEmailPasswordUseCase,
        getFirebaseUserUseCase: GetFirebaseUserUseCase
    ):EmailVerificationRepository{
        return EmailVerificationRepositoryImpl(
            addUserToFireStoreUseCase = addUserToFireStoreUseCase,
            deleteUserFromFirebaseUseCase = deleteUserFromFirebaseUseCase,
            sendEmailVerificationLetterUseCase = sendEmailVerificationLetterUseCase,
            signOutWhileUsingGmailAuth = signOutWhileUsingGmailAuth,
            signOutWhileUsingEmailPasswordUseCase = signOutWhileUsingEmailPasswordUseCase,
            getFirebaseUserUseCase = getFirebaseUserUseCase
        )
    }

    @Provides
    fun provideEmailVerificationWorker(
        context:Context,
        params:WorkerParameters,
        repository: EmailVerificationRepository,
    ):EmailVerificationWorker{
        return EmailVerificationWorker(
            repository = repository,
            context = context,
            params = params
        )
    }

    @Provides
    fun provideRouter(
        insertUserUseCase: InsertUserUseCase
    ): EmailVerificationRouter {
        return EmailVerificationRouterImpl(
            insertUserUseCase = insertUserUseCase
        )
    }

    @Provides
    fun provideViewModelFactory(
        workManager:WorkManager,
        repository: EmailVerificationRepository,
        router: EmailVerificationRouter,
    ):EmailVerificationViewModelFactory{
        return EmailVerificationViewModelFactory(
            workManager = workManager,
            repository = repository,
            router = router,
            emailVerificationNavigationRouter = navigationComponent.getEmailVerificationNavigationRouter()
        )
    }

}