package presentation.viewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import domain.repo.GmailUserToBeDeleted
import domain.repo.ProfileRepository
import domain.repo.ProfileNavRouter
import domain.repo.ProfileUserDataDefaultAuthModel
import domain.repo.ProfileUserDataGmailAuthModel
import domain.repo.UserToBeDeleted
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val profileRepository: ProfileRepository,
    private val profileNavRouter: ProfileNavRouter
):ViewModel(){

    suspend fun deleteGmailUserFromLocalDB(){
       return withContext(Dispatchers.IO){
           profileRepository.deleteGmailUserFromDB(
               GmailUserToBeDeleted(
                   id = "",
                   name = "",
                   photoUrl = "",
                   whenAuthorized = ""
               )
           )
       }
    }

    suspend fun deleteUserFromLocalDB(){
        return withContext(Dispatchers.IO){
            profileRepository.deleteUserFromLocalDB(
                UserToBeDeleted(
                    name = "",
                    email = "",
                    whenAuthorized = "",
                    password = ""
                )
            )
        }
    }

     suspend fun signOutWhileUsingGmailAuth(){
        return withContext(Dispatchers.Default){
            profileRepository.signOutWhileUsingGmailAuth()
        }
    }

     suspend fun signOutWhileUsingEmailPassword(){
        return withContext(Dispatchers.Default){
            profileRepository.signOutWhileUsingEmailPassword()
        }
    }

    suspend fun getProfileUserDataGmailAuth():ProfileUserDataGmailAuthModel{
        return profileRepository.getProfileUserDataGmailAuth().single()
    }

    suspend fun getProfileUserDataDefaultAuth():ProfileUserDataDefaultAuthModel{
        return profileRepository.getProfileUserDataDefaultAuth().single()
    }

    fun navigateProfileToSignUpActionId():Int{
        return profileNavRouter.navigateProfileToSignUpActionId()
    }

    fun navigateProfileToSignInActionId():Int{
        return profileNavRouter.navigateProfileToSignInActionId()
    }

}

class ProfileViewModelFactory @Inject constructor(
    private val profileRepository: ProfileRepository,
    private val profileNavRouter: ProfileNavRouter
):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ProfileViewModel::class.java)){
            return ProfileViewModel(
                profileRepository,
                profileNavRouter
            ) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}