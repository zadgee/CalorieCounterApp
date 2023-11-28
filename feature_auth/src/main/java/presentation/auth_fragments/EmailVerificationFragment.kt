package presentation.auth_fragments
import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.google.android.gms.ads.AdRequest
import com.nutrition.feature_auth.R
import com.nutrition.feature_auth.databinding.FragmentEmailVerificationBinding
import dagger.Lazy
import domain.models.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import presentation.USER_AUTHORIZED_AND_VERIFY_EMAIL
import presentation.viewModels.AuthenticationViewModel
import utils.showToast
import utils.showToastLong
import presentation.viewModels.AuthenticationViewModelFactory
import javax.inject.Inject

private const val WORK_MANAGER = "WorkManagerTAG"
class EmailVerificationFragment : Fragment() {
    private var sharedPreferences: SharedPreferences?=null
    private var binding:FragmentEmailVerificationBinding?=null
    @Inject lateinit var viewModelFactory:Lazy<AuthenticationViewModelFactory>
    private val authenticationViewModel:AuthenticationViewModel by viewModels {
        viewModelFactory.get()
    }

    private var workManager:WorkManager? = null


    override fun onAttach(context: Context) {
             authComponent(context.applicationContext)
             .injectEmailVerificationFragment(this)
             super.onAttach(context)
        workManager = authenticationViewModel.workManager
    }


    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adRequest = AdRequest.Builder().build()
        binding?.adView?.loadAd(adRequest)
    }

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEmailVerificationBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adRequest = AdRequest.Builder().build()
        binding?.adView?.loadAd(adRequest)
        binding?.adView?.visibility = VISIBLE
        sharedPreferences = context?.getSharedPreferences(
            "Preferences",
            Context.MODE_PRIVATE
        )




        val request = authenticationViewModel.request
        workManager?.enqueue(request)
        workManager?.getWorkInfoByIdLiveData(request.id)?.observe(viewLifecycleOwner){ info->
            when(info.state){
                WorkInfo.State.ENQUEUED ->{
                   Log.d(WORK_MANAGER,"Enqueued")
                }
                WorkInfo.State.RUNNING -> {
                    Log.d(WORK_MANAGER,"Running")
                }
                WorkInfo.State.SUCCEEDED -> {
                    lifecycleScope.launch {
                        userVerifyEmailAction()
                    }
                }
                WorkInfo.State.FAILED ->{
                    lifecycleScope.launch {
                        showToastLong(
                            context = view.context,
                            message = "You do not verify email for a long time period," +
                                    " please sign in"
                        )
                        findNavController().navigate(
                            R.id.action_emailVerificationFragment_to_signUpFragment
                        )
                        Log.d(WORK_MANAGER,"Failed")
                    }
                }
                WorkInfo.State.BLOCKED -> {
                    Log.d(WORK_MANAGER,"Blocked")
                }
                WorkInfo.State.CANCELLED -> {
                    Log.d(WORK_MANAGER,"Cancelled")
                }
            }
        }

        binding?.sendEmailVerificationLetterRetry?.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        binding?.sendEmailVerificationLetterRetry?.setOnClickListener {
            authenticationViewModel.sendEmailVerification()
            showToast(
                message = "Another email sent",
                context = view.context
            )
        }
        binding?.verifyEmailButton?.setOnClickListener {
           lifecycleScope.launch(Dispatchers.IO) {
               authenticationViewModel.reloadUser()
               delay(15)
               val isEmailVerified = authenticationViewModel.isEmailVerified
               if(!isEmailVerified){
                   showToast(
                       message = "Please, make sure, that your email is verified",
                       context = view.context
                   )
               } else {
                   lifecycleScope.launch {
                       userVerifyEmailAction()
                   }
               }
           }
        }
    }

    private suspend fun userVerifyEmailAction(){
        withContext(Dispatchers.IO){
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
            delay(10)
            sharedPreferences?.edit()?.apply {
                putString("name",null)
                putString("email",null)
                putString("password",null)
                putBoolean(USER_AUTHORIZED_AND_VERIFY_EMAIL,true)
            }?.apply()
        }
        delay(10)
        withContext(Dispatchers.Main){
           findNavController().navigate(
               R.id.action_emailVerificationFragment_to_congratsFragment
           )
       }
    }

    override fun onResume() {
        super.onResume()
        binding?.adView?.resume()
    }

    override fun onPause() {
        super.onPause()
        binding?.adView?.pause()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        workManager = null
        sharedPreferences = null
        binding = null
    }

}