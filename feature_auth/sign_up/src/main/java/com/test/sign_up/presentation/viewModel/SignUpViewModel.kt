package com.test.sign_up.presentation.viewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.test.sign_up.domain.event.EventSignUp
import com.test.sign_up.domain.event.ValidationEvent
import com.test.sign_up.domain.event.ValidationModel
import com.test.sign_up.domain.repo.SignUpRepository
import com.test.sign_up.domain.repo.ValidationRepositorySignUp
import com.test.sign_up.presentation.router.SignUpNavigationRouter
import com.test.sign_up.presentation.router.SignUpRouter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SignUpViewModel @Inject constructor(
    private val router: SignUpRouter,
    private val validationRepositorySignUp: ValidationRepositorySignUp,
    private val signUpRepository: SignUpRepository,
    private val signUpNavigationRouter: SignUpNavigationRouter
):ViewModel(){
    private val _signUpState = MutableStateFlow<EventSignUp>(EventSignUp.Loading)
    val signUpState = _signUpState.asStateFlow()

    private val _fieldsState = MutableStateFlow(ValidationModel(
        emailError = null,
        passwordError = null,
        nameError = null
    ))
    val fieldsState = _fieldsState.asStateFlow()

    fun signUp(
        email:String,
        password:String
    ){
        viewModelScope.launch(Dispatchers.IO) {
            _signUpState.emit(
                signUpRepository.signUp(
                    email = email,
                    password = password
                )
            )
        }
    }

    fun checkEvent(event: ValidationEvent){
        viewModelScope.launch {
            when(event){
                is ValidationEvent.ValidationProcess ->{
                    validateData(event.name,event.email,event.password)
                }
            }
        }
    }

    private fun validateData(name: String, email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val validateName = validationRepositorySignUp.validateName(name)
            val validateEmail = validationRepositorySignUp.validateEmail(email)
            val validatePassword = validationRepositorySignUp.validatePassword(password)
            val hasError = listOf(
                validateName,
                validateEmail,
                validatePassword
            ).any {
                !it.successful
            }
            if(hasError){
                _fieldsState.emit(
                    ValidationModel(
                        nameError = validateName.errorMessage,
                        emailError = validateEmail.errorMessage,
                        passwordError = validatePassword.errorMessage
                    )
                )
            } else{
                _fieldsState.emit(
                    ValidationModel(
                        nameError = null,
                        emailError = null,
                        passwordError = null
                    )
                )
            }
        }
    }

     fun sendEmailVerification(){
        viewModelScope.launch(Dispatchers.IO) {
            router.sendEmailVerification()
        }
    }

    fun navigateSignUpToEmailVerification():Int{
        return signUpNavigationRouter.navigateSignUpToEmailVerification()
    }

    fun navigateSignUpToSignIn():Int{
        return signUpNavigationRouter.navigateSignUpToSignIn()
    }


}

class SignUpViewModelFactory @Inject constructor(
    private val router:SignUpRouter,
    private val validationRepositorySignUp:ValidationRepositorySignUp,
    private val signUpRepository:SignUpRepository,
    private val signUpNavigationRouter:SignUpNavigationRouter
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        if(modelClass.isAssignableFrom(SignUpViewModel::class.java)){
            return SignUpViewModel(
                router = router,
                validationRepositorySignUp = validationRepositorySignUp,
                signUpRepository = signUpRepository,
                signUpNavigationRouter = signUpNavigationRouter
            ) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}