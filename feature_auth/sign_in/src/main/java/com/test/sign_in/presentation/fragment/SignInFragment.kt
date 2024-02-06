package com.test.sign_in.presentation.fragment
import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Paint
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.test.sign_in.databinding.FragmentSignInBinding
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.nutrition.core.R
import com.test.sign_in.domain.event.EventSignIn
import com.test.sign_in.domain.event.ValidationEvent
import com.test.sign_in.domain.models.UserModel
import com.test.sign_in.presentation.viewModel.SignInViewModel
import com.test.sign_in.presentation.viewModel.SignInViewModelFactory
import com.test.sign_in.presentation.componentProvider.SignInComponentProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import presentation.USER_AUTHORIZED_AND_VERIFY_EMAIL
import presentation.USER_AUTHORIZED_WITH_GMAIL
import presentation.showToast

class SignInFragment : Fragment() {
    private var binding:FragmentSignInBinding?=null
    @Inject lateinit var viewModelFactory: SignInViewModelFactory
    private val viewModel by viewModels<SignInViewModel> { viewModelFactory }
    private var ad: InterstitialAd? = null
    private var launcherGmailSignIn: ActivityResultLauncher<IntentSenderRequest>?=null
    private var sharedPreferences: SharedPreferences?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        launcherGmailSignIn = registerForActivityResult(
            ActivityResultContracts.StartIntentSenderForResult()
        ){ result->
            lifecycleScope.launch {
                try {
                    if(result.resultCode == RESULT_OK){
                        viewModel.initGmailAuth(
                            activityResult = result
                        )
                        sharedPreferences?.edit()?.apply {
                            putBoolean("SKIP_SPLASH",false)
                            putBoolean(USER_AUTHORIZED_WITH_GMAIL,true)
                        }?.apply()
                        delay(20)
                            loadFullScreenAd()
                            initStates()
                    }
                }catch(e:Exception){
                    Log.d("ActivityResultTAG",e.message?:"Unknown error")
                }
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as SignInComponentProvider)
            .provideViewModelFactory(this)
    }

    private fun loadFullScreenAd() {
        val adRequest = AdRequest.Builder().build()
        InterstitialAd.load(requireContext(),"ca-app-pub-9481709154583117/5969237894"
            ,adRequest,
            object : InterstitialAdLoadCallback(){
                override fun onAdLoaded(p0: InterstitialAd) {
                    ad = p0
                }

                override fun onAdFailedToLoad(p0: LoadAdError) {
                    ad = null
                    Log.d("AdError","ad failed to load: ${p0.message}")
                }
            })
    }


    private fun initStates(){
        if(ad != null){
            ad?.fullScreenContentCallback =
                object : FullScreenContentCallback(){
                    override fun onAdFailedToShowFullScreenContent(
                        p0: AdError
                    ) {
                        super.onAdFailedToShowFullScreenContent(
                            p0
                        )
                        ad = null
                        loadFullScreenAd()
                    }

                    override fun onAdDismissedFullScreenContent() {
                        super.onAdDismissedFullScreenContent()
                        val actionId = viewModel.navigateSignInToHome()
                        findNavController().navigate(actionId)
                    }
                }
            ad?.show(requireActivity())
        } else {
            val actionId = viewModel.navigateSignInToHome()
            findNavController().navigate(actionId)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignInBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = context?.getSharedPreferences(
            "Preferences", Context.MODE_PRIVATE
        )

        binding?.forgotPasswordText?.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        binding?.forgotPasswordText?.setOnClickListener {
            lifecycleScope.launch {
               val actionId = viewModel.navigateSignInToForgotPassword()
                findNavController().navigate(actionId)
            }
        }

        binding?.hideOrShowPasswordButton?.setOnClickListener {
            val passwordEditText = binding?.passwordTextField
            val currentInputType = passwordEditText?.inputType ?: 0

            if (currentInputType == (
                        InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
            ) {
                passwordEditText?.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                binding?.hideOrShowPasswordButton?.setImageResource(
                   R.drawable.show_password
                )
            } else {
                passwordEditText?.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                binding?.hideOrShowPasswordButton?.setImageResource(
                    R.drawable.password_visibility_off
                )
            }
            passwordEditText?.setSelection(passwordEditText.text?.length ?: 0)
        }

        binding?.loginToYourAccount?.setOnClickListener{
            val email = binding?.emailTextField?.text.toString()
            val password = binding?.passwordTextField?.text.toString()

            signIn(
                email = email,
                password = password,
                context = view.context,
            )
        }

        binding?.passwordTextField?.setOnEditorActionListener {
                _, actionId, event ->
            if(event != null && event.keyCode == KeyEvent.KEYCODE_ENTER
                || actionId == EditorInfo.IME_ACTION_DONE){
                val email = binding?.emailTextField?.text.toString()
                val password = binding?.passwordTextField?.text.toString()
                signIn(
                    email = email,
                    password = password,
                    context = view.context,
                )
            }
            return@setOnEditorActionListener true
        }

        binding?.googleButton?.setOnClickListener {
            lifecycleScope.launch(Dispatchers.Default) {
                val signUpAction = viewModel.gmailSignUp()
                val signInAction = viewModel.gmailSignIn()
                launcherGmailSignIn?.launch(
                    IntentSenderRequest.Builder(
                        signUpAction?:signInAction?:return@launch
                    ).build()
                )
                viewModel.insertGmailUser()
            }
        }

    }

    private fun signIn(
        email: String,
        password: String,
        context: Context
    ) {
         viewModel.checkEvent(
            event = ValidationEvent.ValidationProcess(
                email = email,
                password = password
            )
         )

        lifecycleScope.launch {
            repeatOnLifecycle(
                viewLifecycleOwner.lifecycle.currentState
            ){
               viewModel.fieldsState.collect{ result->
                   if(result.emailError == null && result.passwordError == null){
                       binding?.emailError?.visibility = INVISIBLE
                       binding?.passwordError?.visibility = INVISIBLE
                       viewModel.signIn(
                          email = email,
                          password = password
                       )
                       viewModel.signInState.collect{ event->
                           when(event){
                               is EventSignIn.Error -> {
                                   showToast(
                                       message = event.error,
                                       context = context
                                   )
                               }
                               is EventSignIn.Loading ->{
                                   binding?.progressBarSignIn?.visibility = VISIBLE
                                   Log.d("SignInLoading","Loading...")
                               }
                               is EventSignIn.Success ->{
                                  val isEmailVerified = viewModel.isEmailVerified()
                                  if(!isEmailVerified){
                                      showToast(
                                          message = "We've sent you an email to verify your account.",
                                          context = context
                                      )
                                      val name = viewModel.getUserNameFromFireStore(
                                          email
                                      )
                                      sharedPreferences?.edit()?.apply {
                                          putString("name",name)
                                          putString("email",email)
                                          putString("password",password)
                                      }?.apply()
                                      viewModel.sendEmailVerificationLetter()
                                      delay(40)
                                      val actionId = viewModel
                                          .navigateSignInToEmailVerification()
                                      findNavController().navigate(actionId)
                                  } else {
                                      val name = viewModel.getUserNameFromFireStore(
                                          email
                                      )
                                      delay(10)
                                      viewModel.saveUserDataToDatabase(
                                          UserModel(
                                              name = name,
                                              email = email,
                                              password = password,
                                              whenAuthorized = viewModel
                                                  .timeMillisToDateConverter()
                                          )
                                      )
                                      delay(10)
                                      sharedPreferences?.edit()?.apply {
                                          putBoolean("SKIP_SPLASH",false)
                                          putBoolean(USER_AUTHORIZED_AND_VERIFY_EMAIL,true)
                                      }?.apply()
                                      delay(10)
                                      val actionId = viewModel.navigateSignInToHome()
                                      findNavController().navigate(actionId)
                                  }
                               }
                           }
                       }
                   } else {
                       binding?.emailError?.text = result.emailError
                       binding?.emailError?.visibility = VISIBLE
                       binding?.passwordError?.text = result.passwordError
                       binding?.passwordError?.visibility = VISIBLE
                   }
               }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        ad = null
        launcherGmailSignIn = null
    }
}