package glue.sign_in.di
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.test.sign_in.domain.repo.SignInRepository
import com.test.sign_in.domain.repo.ValidationRepositorySignIn
import com.test.sign_in.presentation.fragment.SignInFragment
import com.test.sign_in.presentation.router.SignInRouter
import com.test.sign_in.presentation.viewModel.SignInViewModelFactory
import dagger.Module
import dagger.Provides
import domain.usecases.InsertGmailUserUseCase
import domain.usecases.InsertUserUseCase
import domain.usecases.GetFirebaseUserDataUseCase
import domain.usecases.GetFirebaseUserUseCase
import domain.usecases.GetUserNameFromFireStoreByEmail
import domain.usecases.GmailAuthUseCase
import domain.usecases.GmailSignInUseCase
import domain.usecases.GmailSignUpUseCase
import domain.usecases.LoginUseCase
import domain.usecases.SendEmailVerificationLetterUseCase
import glue.navigation.NavigationComponent
import glue.sign_in.repo.SignInRepositoryImpl
import glue.sign_in.repo.ValidationRepositorySignInSignInImpl
import glue.sign_in.router.SignInRouterImpl


@Module
class SignInModule(
    private val navigationComponent: NavigationComponent
) {

  @Provides
  fun provideValidationRepository():ValidationRepositorySignIn{
      return ValidationRepositorySignInSignInImpl()
  }

    @Provides
    fun provideSignInRepository(
        loginUseCase: LoginUseCase
    ):SignInRepository{
       return SignInRepositoryImpl(
           loginUseCase
       )
   }

   @Provides
   fun provideNavController():NavController{
       return SignInFragment().findNavController()
   }

   @Provides
   fun provideSignInRouter(
       sendEmailVerificationLetterUseCase: SendEmailVerificationLetterUseCase,
       insertUserUseCase:InsertUserUseCase,
       getUserNameFromFireStoreByEmail: GetUserNameFromFireStoreByEmail,
       gmailAuthUseCase: GmailAuthUseCase,
       gmailSignInUseCase: GmailSignInUseCase,
       gmailSignUpUseCase: GmailSignUpUseCase,
       getFirebaseUserDataUseCase: GetFirebaseUserDataUseCase,
       insertGmailUserUseCase: InsertGmailUserUseCase
   ): SignInRouter {
       return SignInRouterImpl(
           sendEmailVerificationLetterUseCase = sendEmailVerificationLetterUseCase,
           insertUserUseCase = insertUserUseCase,
           getUserNameFromFireStoreByEmail = getUserNameFromFireStoreByEmail,
           gmailSignInUseCase = gmailSignInUseCase ,
           gmailSignUpUseCase = gmailSignUpUseCase,
           gmailAuthUseCase = gmailAuthUseCase,
           getFirebaseUserDataUseCase = getFirebaseUserDataUseCase,
           insertGmailUserUseCase = insertGmailUserUseCase
       )
   }


   @Provides
   fun provideViewModelFactory(
       getFirebaseUserUseCase: GetFirebaseUserUseCase,
       signInRepository: SignInRepository,
       signInRouter: SignInRouter,
       validationRepositorySignIn: ValidationRepositorySignIn,
   ): SignInViewModelFactory {
      return SignInViewModelFactory(
          isEmailVerified = getFirebaseUserUseCase.isEmailVerified(),
          signInRepository = signInRepository,
          router = signInRouter,
          validationRepositorySignIn = validationRepositorySignIn,
          signInNavigationRouter = navigationComponent.getSignInNavigationRouter()
      )
   }

}