package presentation
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import domain.repo.ProfileRepository
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val profileRepository: ProfileRepository
){

    suspend fun deleteUserFromLocalDB(){
        return profileRepository.deleteUserFromLocalDB()
    }

    suspend fun signOutWhileUsingGmailAuth(){
        return profileRepository.signOutWhileUsingGmailAuth()
    }

    suspend fun signOutWhileUsingEmailPassword(){
        return profileRepository.signOutWhileUsingEmailPassword()
    }

}

class ProfileViewModelFactory @Inject constructor(
    private val profileRepository: ProfileRepository
):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ProfileViewModel::class.java)){
            return ProfileViewModel(
                profileRepository
            ) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}