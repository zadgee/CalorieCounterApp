package com.test.sign_in.presentation.viewModel
import android.content.IntentSender
import androidx.activity.result.ActivityResult
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.test.sign_in.domain.event.EventSignIn
import com.test.sign_in.domain.event.ValidationEvent
import com.test.sign_in.domain.models.GmailUserModel
import com.test.sign_in.domain.models.UserModel
import com.test.sign_in.domain.models.ValidationModel
import com.test.sign_in.domain.repo.SignInRepository
import com.test.sign_in.domain.repo.ValidationRepositorySignIn
import com.test.sign_in.presentation.router.SignInNavigationRouter
import com.test.sign_in.presentation.router.SignInRouter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SignInViewModel @Inject constructor(
    private val validationRepositorySignIn: ValidationRepositorySignIn,
    private val signInRepository: SignInRepository,
    private val router: SignInRouter,
    val isEmailVerified:Boolean,
    private val signInNavigationRouter: SignInNavigationRouter
) : ViewModel() {
    private val _signInState = MutableStateFlow<EventSignIn>(EventSignIn.Loading)
    val signInState = _signInState.asStateFlow()

    private val _fieldsState = MutableStateFlow(
        ValidationModel(
            emailError = null,
            passwordError = null,
        )
    )
    val fieldsState = _fieldsState.asStateFlow()

    fun signIn(email:String,password:String){
        viewModelScope.launch(Dispatchers.IO) {
            _signInState.emit(
                signInRepository.signIn(email,password)
            )
        }
    }

    fun checkEvent(event: ValidationEvent){
        viewModelScope.launch {
            when(event){
                is ValidationEvent.ValidationProcess ->{
                    validationProcess(
                        email = event.email,
                        password = event.password
                    )
                }
            }
        }
    }

     fun sendEmailVerificationLetter(){
        viewModelScope.launch(Dispatchers.IO) {
            router.sendEmailVerification()
        }
    }

    suspend fun getUserNameFromFireStore(email: String):String{
        return withContext(Dispatchers.IO){
            router.getUserNameFromFireStore(
                email
            )
        }
    }

    suspend fun saveUserDataToDatabase(
        userModel: UserModel
    ) {
        return withContext(Dispatchers.IO){
            router.saveUserDataToDatabase(
                userModel
            )
        }
    }

   private fun validationProcess(
        email:String,
        password:String
    ) {
       viewModelScope.launch(Dispatchers.IO) {
           val validateEmail = validationRepositorySignIn.validateEmail(email)
           val validatePassword = validationRepositorySignIn.validatePassword(password)
           val hasError = listOf(
               validateEmail,
               validatePassword,
           ).any {
               !it.successful
           }
           if(hasError){
               _fieldsState.emit(
                   ValidationModel(
                       emailError = validateEmail.errorMessage,
                       passwordError = validatePassword.errorMessage
                   )
               )
           } else{
               _fieldsState.emit(
                   ValidationModel(
                       emailError = null,
                       passwordError = null
                   )
               )
           }
       }
    }

   suspend fun gmailSignUp():IntentSender?{
       return router.launchGmailSignUp()
   }

   suspend fun insertGmailUser(){
       return withContext(Dispatchers.IO){
           router.saveGmailUserToDataBase(
               GmailUserModel(
                   id = "",
                   name = "",
                   photoUrl = ""
               )
           )
       }
   }

   suspend fun gmailSignIn():IntentSender?{
       return router.launchGmailSignIn()
   }

     suspend fun initGmailAuth(activityResult: ActivityResult){
        return withContext(Dispatchers.Main){
            router.initGmailAuth(activityResult)
        }
    }

    fun navigateSignInToForgotPassword():Int{
        return signInNavigationRouter.navigateSignInToForgotPassword()
    }

    fun navigateSignInToHome():Int{
        return signInNavigationRouter.navigateSignInToHome()
    }

    fun navigateSignInToEmailVerification():Int{
        return signInNavigationRouter.navigateSignInToEmailVerification()
    }

}

class SignInViewModelFactory @Inject constructor(
    private val validationRepositorySignIn: ValidationRepositorySignIn,
    private val signInRepository: SignInRepository,
    private val router: SignInRouter,
    val isEmailVerified:Boolean,
    private val signInNavigationRouter: SignInNavigationRouter
):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SignInViewModel::class.java)){
            return SignInViewModel(
                 validationRepositorySignIn = validationRepositorySignIn,
                 signInRepository = signInRepository,
                 router = router,
                 isEmailVerified = isEmailVerified,
                 signInNavigationRouter = signInNavigationRouter
            ) as T
        }else{
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}