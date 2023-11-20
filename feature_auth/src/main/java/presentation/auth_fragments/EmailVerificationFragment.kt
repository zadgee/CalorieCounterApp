package presentation.auth_fragments
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Paint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.nutrition.feature_auth.R
import com.nutrition.feature_auth.databinding.FragmentEmailVerificationBinding
import dagger.Lazy
import domain.models.UserEntity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import presentation.USER_AUTHORIZED_AND_VERIFY_EMAIL
import presentation.viewModels.AuthenticationViewModel
import presentation.showToast
import presentation.viewModels.AuthenticationViewModelFactory
import javax.inject.Inject


class EmailVerificationFragment : Fragment() {
    private var sharedPreferences: SharedPreferences?=null
    private var binding:FragmentEmailVerificationBinding?=null
    @Inject lateinit var viewModelFactory:Lazy<AuthenticationViewModelFactory>
    private val authenticationViewModel:AuthenticationViewModel by viewModels {
        viewModelFactory.get()
    }


    override fun onAttach(context: Context) {
             authComponent(context.applicationContext)
             .injectEmailVerificationFragment(this)
             super.onAttach(context)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEmailVerificationBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = context?.getSharedPreferences(
            "Preferences",
            Context.MODE_PRIVATE
        )

        binding?.sendEmailVerificationLetterRetry?.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        binding?.sendEmailVerificationLetterRetry?.setOnClickListener {
            authenticationViewModel.sendEmailVerification()
            showToast(
                message = "Another email sent",
                context = view.context
            )
        }
        binding?.verifyEmailButton?.setOnClickListener {
            authenticationViewModel.reloadUser()
            val isEmailVerified = authenticationViewModel.isEmailVerified
            if(!isEmailVerified){
                showToast(
                    message = "Please, make sure, that your email is verified",
                    context = view.context
                )
            } else {
                lifecycleScope.launch {
                    val name = sharedPreferences?.getString("name","") ?:""
                    val email = sharedPreferences?.getString("email","") ?:""
                    val password = sharedPreferences?.getString("password","") ?:""
                    authenticationViewModel.addUserToFireStore(
                        name = name,
                        email = email,
                        password = password
                    )
                    delay(10)
                    authenticationViewModel.insertUser(
                        UserEntity(
                            name = name,
                            email = email,
                            password = password
                        )
                    )
                    sharedPreferences?.edit()?.apply {
                        putString("name",null)
                        putString("email",null)
                        putString("password",null)
                        putBoolean(USER_AUTHORIZED_AND_VERIFY_EMAIL,true)
                    }?.apply()
                    delay(15)
                    findNavController().navigate(
                        R.id.action_emailVerificationFragment_to_congratsFragment
                    )
                }
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        sharedPreferences = null
        binding = null
    }

}