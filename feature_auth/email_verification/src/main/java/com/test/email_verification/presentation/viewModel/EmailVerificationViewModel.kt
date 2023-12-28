package com.test.email_verification.presentation.viewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.test.email_verification.domain.models.UserModel
import com.test.email_verification.domain.repo.EmailVerificationRepository
import com.test.email_verification.domain.worker.EmailVerificationWorker
import com.test.email_verification.presentation.router.EmailVerificationNavigationRouter
import com.test.email_verification.presentation.router.EmailVerificationRouter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class EmailVerificationViewModel @Inject constructor(
    val workManager: WorkManager,
    private val repository: EmailVerificationRepository,
    private val router: EmailVerificationRouter,
    private val emailVerificationNavigationRouter: EmailVerificationNavigationRouter
) : ViewModel() {

    val request = OneTimeWorkRequestBuilder<EmailVerificationWorker>()
        .setInitialDelay(7, TimeUnit.MINUTES)
        .build()


    fun signOutWhileUsingEmailPassword(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.signOutWhileUsingEmailPassword()
        }
    }

    fun deleteUserFromFirebase(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUserFromFirebase()
        }
    }

    suspend fun reloadUser():Boolean{
       return withContext(Dispatchers.IO){
           repository.reloadUser()
       }
    }

    fun sendEmailVerificationLetter(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.sendEmailVerificationLetter()
        }
    }

     fun saveUserToLocalDb(
        userModel: UserModel
    ){
        viewModelScope.launch(Dispatchers.IO) {
            router.saveUserToDB(userModel)
        }
    }

    fun saveUserToFireStore(
        name:String,
        email:String,
        password:String
    ){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUserToFireStore(
                name,
                email,
                password
            )
        }
    }

    fun navigateToCongrats():Int{
        return emailVerificationNavigationRouter.navigateToCongrats()
    }

}


class EmailVerificationViewModelFactory @Inject constructor(
    val workManager: WorkManager,
    private val repository: EmailVerificationRepository,
    private val router: EmailVerificationRouter,
    private val emailVerificationNavigationRouter: EmailVerificationNavigationRouter
):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(EmailVerificationViewModel::class.java)){
            return EmailVerificationViewModel(
                workManager = workManager,
                repository = repository,
                router = router,
                emailVerificationNavigationRouter = emailVerificationNavigationRouter
            ) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}