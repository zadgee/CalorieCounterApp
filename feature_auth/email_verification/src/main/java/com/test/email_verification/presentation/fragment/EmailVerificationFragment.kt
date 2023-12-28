package com.test.email_verification.presentation.fragment
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.google.android.gms.ads.AdRequest
import com.test.email_verification.databinding.FragmentEmailVerificationBinding
import com.test.email_verification.domain.models.UserModel
import com.test.email_verification.presentation.componentProvider.EmailVerificationComponentProvider
import com.test.email_verification.presentation.viewModel.EmailVerificationViewModel
import com.test.email_verification.presentation.viewModel.EmailVerificationViewModelFactory
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import presentation.showToast
import presentation.showToastLong
import javax.inject.Inject

private const val WORK_MANAGER = "WorkManagerTAG"
private const val USER_AUTHORIZED_AND_VERIFY_EMAIL = "USER_AUTHORIZED_AND_VERIFY_EMAIL"

class EmailVerificationFragment : Fragment() {
    private var binding:FragmentEmailVerificationBinding?=null
    private var sharedPreferences: SharedPreferences?=null
    @Inject lateinit var factory:EmailVerificationViewModelFactory
    private val viewModel: EmailVerificationViewModel by viewModels {
        factory
    }
    private var workManager: WorkManager? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEmailVerificationBinding.inflate(inflater)
        return binding?.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adRequest = AdRequest.Builder().build()
        binding?.adView?.loadAd(adRequest)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as EmailVerificationComponentProvider
                ).provideViewModelFactory(this)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = context?.getSharedPreferences(
            "Preferences",
            Context.MODE_PRIVATE
        )
        workManager = viewModel.workManager
        val request = viewModel.request
        workManager?.enqueue(request)
        workManager?.getWorkInfoByIdLiveData(request.id)?.observe(viewLifecycleOwner){
            info->
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
                            message = "You do not verify email for a long time period"
                        )
                        viewModel.signOutWhileUsingEmailPassword()
                        delay(10)
                        viewModel.deleteUserFromFirebase()
                        delay(10)
                        findNavController().popBackStack()
                        Log.d(WORK_MANAGER,"Failed")
                    }
                }
                WorkInfo.State.BLOCKED -> {
                    Log.d(WORK_MANAGER,"Blocked")
                }
                WorkInfo.State.CANCELLED -> {
                    Log.d(WORK_MANAGER,"Cancelled")
                }
                else -> {
                    Log.d(WORK_MANAGER,"Unknown workManager error")
                }
            }
        }

        binding?.sendEmailVerificationLetterRetry?.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        binding?.sendEmailVerificationLetterRetry?.setOnClickListener {
            viewModel.sendEmailVerificationLetter()
            showToast(
                message = "Another email sent",
                context = view.context
            )
        }

        binding?.verifyEmailButton?.setOnClickListener {
            lifecycleScope.launch {
                val isEmailVerified = viewModel.reloadUser()
                if(!isEmailVerified){
                    showToast(
                        message = "Please, make sure, that your email is verified",
                        context = view.context
                    )
                } else{
                    lifecycleScope.launch {
                        userVerifyEmailAction()
                    }
                }
            }
        }

    }

    private suspend fun userVerifyEmailAction() {
        val name = sharedPreferences?.getString("name","")
        val email = sharedPreferences?.getString("email","")
        val password = sharedPreferences?.getString("password","")
        val user = UserModel(
            name = name?:throw NullPointerException ("name is null"),
            email = email?:throw NullPointerException ("email is null"),
            password = password ?:throw NullPointerException ("password is null")
        )
        viewModel.saveUserToLocalDb(
            user
        )
        delay(10)
        viewModel.saveUserToFireStore(
            name = name,
            email = email,
            password = password
        )
        delay(10)
        sharedPreferences?.edit()?.apply {
            putString("name",null)
            putString("email",null)
            putString("password",null)
            putBoolean(USER_AUTHORIZED_AND_VERIFY_EMAIL,true)
        }?.apply()
        delay(10)
        val actionId = viewModel.navigateToCongrats()
        findNavController().navigate(actionId)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        workManager = null
    }

    override fun onResume() {
        super.onResume()
        binding?.adView?.resume()
    }

    override fun onPause() {
        super.onPause()
        binding?.adView?.pause()
    }
}