package presentation.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.models.validationModel.ValidationModel
import domain.usecase.ValidateEmailUseCase
import domain.usecase.ValidateNameUseCase
import domain.usecase.ValidatePasswordUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import presentation.event.ValidationEvent
import presentation.event.ValidationEventWhenRestoringPassword
import presentation.event.ValidationEventWhenSignIn

class ValidationViewModel:ViewModel() {
    private val validateEmail : ValidateEmailUseCase = ValidateEmailUseCase()
    private val validatePassword: ValidatePasswordUseCase = ValidatePasswordUseCase()
    private val validateNameUseCase: ValidateNameUseCase = ValidateNameUseCase()

    private val _fieldsState = MutableStateFlow(
        ValidationModel(
            emailError = null,
            passwordError = null,
            nameError = null
        )
    )
    val fieldsState = _fieldsState.asStateFlow()

    fun checkEvent(event:ValidationEvent){
        viewModelScope.launch {
             when(event){
                 is ValidationEvent.ValidationProcess ->{
                     validateData(event.name,event.email,event.password)
                 }
             }
        }
    }

    fun checkEventWhenSignIn(eventWhenSignIn: ValidationEventWhenSignIn){
        viewModelScope.launch {
            when(eventWhenSignIn){
                is ValidationEventWhenSignIn.ValidationProcess ->{
                    validateDataWhenSignIn(
                        eventWhenSignIn.email,eventWhenSignIn.password
                    )
                }
            }
        }
    }

    fun checkEventWhenRestoringPassword(
        eventWhenRestoringPassword: ValidationEventWhenRestoringPassword
    ){
        viewModelScope.launch {
            when(eventWhenRestoringPassword){
                is ValidationEventWhenRestoringPassword.ValidationProcess ->{
                    validateDataWhenRestoringPassword(
                        eventWhenRestoringPassword.email
                    )
                }
            }
        }
    }

    private fun validateData(
        name: String,
        email: String,
        password: String
    ){
      viewModelScope.launch(Dispatchers.IO) {
          val validateName = validateNameUseCase.validate(name)
          val validateEmail = validateEmail.validate(email)
          val validatePassword = validatePassword.validate(password)
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
                      nameError = validateName.error,
                      emailError = validateEmail.error,
                      passwordError = validatePassword.error
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

    private fun validateDataWhenSignIn(
        email: String,
        password: String
    ){
        viewModelScope.launch(Dispatchers.IO) {
            val validateEmail = validateEmail.validate(email)
            val validatePassword = validatePassword.validate(password)
            val hasError = listOf(
                validateEmail,
                validatePassword
            ).any {
                !it.successful
            }
            if(hasError){
                _fieldsState.emit(
                    ValidationModel(
                        emailError = validateEmail.error,
                        passwordError = validatePassword.error,
                        nameError = null
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

    private fun validateDataWhenRestoringPassword(
        email: String
    ){
        viewModelScope.launch(Dispatchers.IO) {
            val validateEmail = validateEmail.validate(email)
            val hasError = listOf(
                validateEmail,
            ).any {
                !it.successful
            }
            if(hasError){
                _fieldsState.emit(
                    ValidationModel(
                        emailError = validateEmail.error,
                        passwordError = null,
                        nameError = null
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



}