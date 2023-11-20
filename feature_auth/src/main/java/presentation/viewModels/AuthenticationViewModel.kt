package presentation.viewModels
import android.content.IntentSender
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.GoogleAuthProvider
import data.annotations.GmailSignIn
import data.annotations.GmailSignUp
import domain.models.UserEntity
import domain.event.SignInEvent
import domain.event.SignUpEvent
import domain.models.GmailUserEntity
import domain.models.user.GmailAuthorizationData
import domain.usecase.AddUserToFireStoreUseCase
import domain.usecase.DeleteUserFromFirebaseUseCase
import domain.usecase.GetUserNameFromFireStoreByEmail
import domain.usecase.GetFirebaseUserUseCase
import domain.usecase.GmailAuthUseCase
import domain.usecase.LoginUseCase
import domain.usecase.ReloadUserUseCase
import domain.usecase.SendEmailVerificationLetterUseCase
import domain.usecase.SignOutWhileUsingEmailPasswordUseCase
import domain.usecase.SignOutWhileUsingGmailAuth
import domain.usecase.SignUpUseCase
import domain.usecases.GetGmailUserUseCase
import domain.usecases.GetUserFromDatabaseUseCase
import domain.usecases.InsertGmailUserUseCase
import domain.usecases.InsertUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthenticationViewModel @Inject constructor(
    private val addUserToFireStoreUseCase: AddUserToFireStoreUseCase,
    private val deleteUserFromFirebaseUseCase: DeleteUserFromFirebaseUseCase,
    private val loginUseCase:LoginUseCase,
    private val reloadUserUseCase: ReloadUserUseCase,
    private val sendEmailVerificationLetterUseCase: SendEmailVerificationLetterUseCase,
    private val signOutWhileUsingEmailPasswordUseCase: SignOutWhileUsingEmailPasswordUseCase,
    private val signOutWhileUsingGmailAuth: SignOutWhileUsingGmailAuth,
    private val signUpUseCase: SignUpUseCase,
    val oneTapClient: SignInClient,
    private val getFirebaseUserUseCase: GetFirebaseUserUseCase,
    private val insertUserUseCase: InsertUserUseCase,
    private val getUserNameFromFireStoreByEmail: GetUserNameFromFireStoreByEmail,
    @GmailSignIn private val signIn: BeginSignInRequest,
    @GmailSignUp private val signUp: BeginSignInRequest,
    private val gmailAuthUseCase: GmailAuthUseCase,
    private val insertGmailUserUseCase: InsertGmailUserUseCase,
    private val getGmailUserUseCase: GetGmailUserUseCase,
    private val getUserFromDatabaseUseCase: GetUserFromDatabaseUseCase
) : ViewModel() {

    private val _signUpState = MutableStateFlow<SignUpEvent>(SignUpEvent.Loading)
    val signUpState = _signUpState.asStateFlow()
    private val _signInState = MutableStateFlow<SignInEvent>(SignInEvent.Loading)
    val signInState = _signInState.asStateFlow()
    val isEmailVerified get() = getFirebaseUserUseCase.user()?.isEmailVerified ?:false
    private val firebaseUser = getFirebaseUserUseCase.user()
    private val _userNameFlow = MutableSharedFlow<String>()
    val userNameFlow = _userNameFlow.asSharedFlow()
    private val _gmailUserFlow = MutableStateFlow<GmailUserEntity?>(null)
    val gmailUserFlow = _gmailUserFlow.asStateFlow()
    private val _defaultAuthorizationUserFlow = MutableStateFlow<UserEntity?>(null)
    val defaultAuthorizationUserFlow = _defaultAuthorizationUserFlow.asStateFlow()


    fun signUp(
        email:String,
        password:String
    ){
        viewModelScope.launch(Dispatchers.IO) {
            _signUpState.emit(
              signUpUseCase.signUp(email,password)
            )
        }
    }

    fun signIn(
        email:String,
        password: String
    ){
        viewModelScope.launch(Dispatchers.IO) {
            _signInState.emit(
                loginUseCase.login(email,password)
            )
        }
    }

     fun addUserToFireStore(
        name:String,
        email:String,
        password:String
    ){
      viewModelScope.launch(Dispatchers.IO) {
          addUserToFireStoreUseCase.add(
              name,email, password
          )
      }
    }

    fun deleteUserFromFirebase(){
        viewModelScope.launch(Dispatchers.IO) {
            deleteUserFromFirebaseUseCase.delete()
        }
    }

    fun reloadUser(){
        viewModelScope.launch(Dispatchers.IO) {
             reloadUserUseCase.reload()
        }
    }

    suspend fun gmailSignIn(): IntentSender? {
        val signInResult = oneTapClient.beginSignIn(signIn).await()
        return signInResult.pendingIntent.intentSender
    }


    suspend fun gmailSignUp(): IntentSender? {
        val signUpResult = oneTapClient.beginSignIn(signUp).await()
        return signUpResult.pendingIntent.intentSender
    }

    suspend fun authorizeWithGmail(): GmailAuthorizationData?{
        return withContext(Dispatchers.IO){
            if(firebaseUser != null &&
                firebaseUser.providerData.any {
                    it.providerId == GoogleAuthProvider.PROVIDER_ID
                }
            ){
                GmailAuthorizationData(
                    id = firebaseUser.uid,
                    name = firebaseUser.displayName ?:"",
                    pictureUrl = firebaseUser.photoUrl?.toString()
                )
            }
            null
        }
    }

    fun signOutWhileUsingEmailPassword(){
        viewModelScope.launch(Dispatchers.IO) {
           signOutWhileUsingEmailPasswordUseCase.signOut()
        }
    }

    fun signOutWhileUsingGmailAuth(){
        viewModelScope.launch(Dispatchers.IO) {
            signOutWhileUsingGmailAuth.signOut()
        }
    }

    fun sendEmailVerification(){
        viewModelScope.launch(Dispatchers.Default) {
            sendEmailVerificationLetterUseCase.send()
        }
    }

    fun insertUser(userEntity: UserEntity){
        viewModelScope.launch(Dispatchers.IO) {
            insertUserUseCase.insertUser(userEntity)
        }
    }

    fun getDefaultAuthorizationUserFromDB(){
        viewModelScope.launch(Dispatchers.IO) {
            _defaultAuthorizationUserFlow.emit(
                getUserFromDatabaseUseCase.getUserFromDataBase()
            )
        }
    }

    fun retrieveUserName(email:String){
        viewModelScope.launch(Dispatchers.IO) {
            val value = getUserNameFromFireStoreByEmail.retrieve(email)
            _userNameFlow.emit(
                value
            )
        }
    }

    fun gmailAuth(credential: AuthCredential){
        viewModelScope.launch(Dispatchers.IO) {
            gmailAuthUseCase.gmailAuth(credential)
        }
    }

    fun insertGmailUser(gmailUserEntity: GmailUserEntity){
        viewModelScope.launch(Dispatchers.IO) {
            insertGmailUserUseCase.insert(gmailUserEntity)
        }
    }

    fun getGmailUser(){
        viewModelScope.launch(Dispatchers.IO) {
            _gmailUserFlow.emit(
                getGmailUserUseCase.execute()
            )
        }
    }

}

class AuthenticationViewModelFactory @Inject constructor(
    private val addUserToFireStoreUseCase: AddUserToFireStoreUseCase,
    private val deleteUserFromFirebaseUseCase: DeleteUserFromFirebaseUseCase,
    private val loginUseCase:LoginUseCase,
    private val reloadUserUseCase: ReloadUserUseCase,
    private val sendEmailVerificationLetterUseCase: SendEmailVerificationLetterUseCase,
    private val signOutWhileUsingEmailPasswordUseCase: SignOutWhileUsingEmailPasswordUseCase,
    private val signOutWhileUsingGmailAuth: SignOutWhileUsingGmailAuth,
    private val signUpUseCase: SignUpUseCase,
    private val oneTapClient: SignInClient,
    private val getFirebaseUserUseCase: GetFirebaseUserUseCase,
    private val insertUserUseCase: InsertUserUseCase,
    private val getUserNameFromFireStoreByEmail: GetUserNameFromFireStoreByEmail,
    @GmailSignIn private val signIn: BeginSignInRequest,
    @GmailSignUp private val signUp: BeginSignInRequest,
    private val gmailAuthUseCase: GmailAuthUseCase,
    private val insertGmailUserUseCase: InsertGmailUserUseCase,
    private val getGmailUserUseCase: GetGmailUserUseCase,
    private val getUserFromDatabaseUseCase: GetUserFromDatabaseUseCase
):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
         if(modelClass.isAssignableFrom(AuthenticationViewModel::class.java)){
             return AuthenticationViewModel(
                 addUserToFireStoreUseCase,
                 deleteUserFromFirebaseUseCase,
                 loginUseCase,
                 reloadUserUseCase,
                 sendEmailVerificationLetterUseCase,
                 signOutWhileUsingEmailPasswordUseCase,
                 signOutWhileUsingGmailAuth,
                 signUpUseCase,
                 oneTapClient,
                 getFirebaseUserUseCase,
                 insertUserUseCase,
                 getUserNameFromFireStoreByEmail,
                 signIn,
                 signUp,
                 gmailAuthUseCase,
                 insertGmailUserUseCase,
                 getGmailUserUseCase,
                 getUserFromDatabaseUseCase
             ) as T
         }else{
             throw IllegalArgumentException("Unknown ViewModel class")
         }
    }
}