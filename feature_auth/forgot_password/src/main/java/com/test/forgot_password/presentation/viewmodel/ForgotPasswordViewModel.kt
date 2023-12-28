package com.test.forgot_password.presentation.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.test.forgot_password.domain.event.ValidationEventWhenRestoringPassword
import com.test.forgot_password.domain.event.ValidationModel
import com.test.forgot_password.domain.repo.EmailValidationRepository
import com.test.forgot_password.presentation.router.ForgotPasswordRouter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ForgotPasswordViewModel @Inject constructor(
    private val repository:EmailValidationRepository,
    private val router:ForgotPasswordRouter,
) :ViewModel() {

    private val _emailFieldState = MutableStateFlow(ValidationModel())
    val emailFieldState = _emailFieldState.asStateFlow()

    fun checkEvent(event: ValidationEventWhenRestoringPassword){
        viewModelScope.launch {
            when(event){
                is ValidationEventWhenRestoringPassword.ValidationProcess->{
                    validateData(event.email)
                }
            }
        }
    }

    fun sendResetPasswordEmail(email: String){
        viewModelScope.launch(Dispatchers.IO) {
            router.sendResetPasswordEmail(email)
        }
    }

    private fun validateData(email: String){
       viewModelScope.launch(Dispatchers.IO) {
           val validateEmail = repository.validateEmail(email)
           if(validateEmail.successful){
               _emailFieldState.emit(
                  ValidationModel(
                      emailError = null,
                  )
               )
           } else {
               _emailFieldState.emit(
                   ValidationModel(
                       emailError = validateEmail.errorMessage,
                   )
               )
           }
       }
    }
}

class ForgotPasswordViewModelFactory @Inject constructor(
    private val repository: EmailValidationRepository,
    private val router: ForgotPasswordRouter,
):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
         if(modelClass.isAssignableFrom(ForgotPasswordViewModel::class.java)){
            return ForgotPasswordViewModel(
               repository = repository,
               router = router
            ) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}