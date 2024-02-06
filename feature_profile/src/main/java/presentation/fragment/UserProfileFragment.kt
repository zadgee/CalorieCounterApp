package presentation.fragment
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import coil.load
import com.test.feature_profile.databinding.FragmentUserProfileBinding
import domain.repo.ProfileComponentProvider
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import presentation.USER_AUTHORIZED_AND_VERIFY_EMAIL
import presentation.USER_AUTHORIZED_WITH_GMAIL
import presentation.viewModel.ProfileViewModel
import presentation.viewModel.ProfileViewModelFactory
import javax.inject.Inject


class UserProfileFragment : Fragment() {
private var binding: FragmentUserProfileBinding? = null
@Inject lateinit var viewModelFactory: ProfileViewModelFactory
private val viewModel by viewModels<ProfileViewModel> {
    viewModelFactory
}
private var sharedPreferences:SharedPreferences?=null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as ProfileComponentProvider)
            .provideProfileComponent(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserProfileBinding.inflate(layoutInflater)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = context?.getSharedPreferences(
            "Preferences", Context.MODE_PRIVATE
        )
        val isUserAuthenticatedWithGmail = sharedPreferences?.getBoolean(
            USER_AUTHORIZED_WITH_GMAIL,false
        ) ?: false
        val isUserAuthenticatedWithDefaultAuthentication = sharedPreferences
            ?.getBoolean(
            USER_AUTHORIZED_AND_VERIFY_EMAIL,false
        ) ?: false
        if(isUserAuthenticatedWithGmail){
           lifecycleScope.launch {
               val userData = viewModel.getProfileUserDataGmailAuth()
               binding?.userProfileImage?.load(
                   userData.imageUrl
               )
               binding?.specificUserName?.text = userData.name
           }
        } else if(isUserAuthenticatedWithDefaultAuthentication){
             lifecycleScope.launch {
               val defaultAuthUserData = viewModel.getProfileUserDataDefaultAuth()
                 binding?.userProfileImage?.setImageResource(
                     defaultAuthUserData.photoProfile ?: 0
                 )
                 binding?.specificUserName?.text = defaultAuthUserData.name
             }
        }
        binding?.signOutButton?.setOnClickListener{
            if(isUserAuthenticatedWithGmail){
                lifecycleScope.launch {
                    viewModel.signOutWhileUsingGmailAuth()
                    viewModel.deleteUserFromLocalDB()
                    delay(20)
                    sharedPreferences?.edit()?.apply {
                        putBoolean("USER_AUTHORIZED_WITH_GMAIL",false)
                        putBoolean("USER_AUTHORIZED_AND_VERIFY_EMAIL",false)
                    }?.apply()
                    val actionId = viewModel.navigateProfileToSignInActionId()
                    findNavController().navigate(actionId)
                }
            } else if(isUserAuthenticatedWithDefaultAuthentication){
                lifecycleScope.launch {
                    viewModel.signOutWhileUsingEmailPassword()
                    viewModel.deleteUserFromLocalDB()
                    delay(20)
                    sharedPreferences?.edit()?.apply {
                        putBoolean("USER_AUTHORIZED_WITH_GMAIL",false)
                        putBoolean("USER_AUTHORIZED_AND_VERIFY_EMAIL",false)
                    }?.apply()
                    val actionId = viewModel.navigateProfileToSignInActionId()
                    findNavController().navigate(actionId)
                }
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}