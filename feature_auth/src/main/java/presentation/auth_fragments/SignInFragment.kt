package presentation.auth_fragments
import android.annotation.SuppressLint
import android.app.Activity.RESULT_CANCELED
import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Paint
import android.graphics.Typeface
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
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.firebase.auth.GoogleAuthProvider
import com.nutrition.feature_auth.R
import com.nutrition.feature_auth.databinding.FragmentSignInBinding
import domain.models.UserEntity
import domain.event.SignInEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import presentation.STATE_LOADING
import presentation.USER_AUTHORIZED_WITH_GMAIL
import presentation.event.ValidationEventWhenSignIn
import utils.showToast
import presentation.viewModels.AuthenticationViewModel
import presentation.viewModels.AuthenticationViewModelFactory
import presentation.viewModels.ValidationViewModel
import javax.inject.Inject


class SignInFragment : Fragment() {
    private var binding : FragmentSignInBinding? = null
    private val validationViewModel by viewModels<ValidationViewModel>()
    private var sharedPreferences: SharedPreferences?=null
    private var ad:InterstitialAd? = null
    @Inject
    lateinit var viewModelFactory: AuthenticationViewModelFactory
    private val authenticationViewModel:AuthenticationViewModel by viewModels {
        viewModelFactory
    }
    private var launcher:ActivityResultLauncher<IntentSenderRequest>? = null


    override fun onAttach(context: Context) {
        authComponent(context.applicationContext)
            .injectSignInFragment(this)
        activity

        launcher = registerForActivityResult(
            ActivityResultContracts.StartIntentSenderForResult()
        ){
            result->
            lifecycleScope.launch(Dispatchers.IO){
                try {
                    if(result.resultCode == RESULT_OK){
                        val credentials = authenticationViewModel.oneTapClient.
                        getSignInCredentialFromIntent(
                            result.data
                        )
                        val googleIdToken = credentials.googleIdToken
                        val googleCred = GoogleAuthProvider.getCredential(
                            googleIdToken,null
                        )
                        authenticationViewModel.gmailAuth(googleCred)
                    }else if(result.resultCode == RESULT_CANCELED){
                        Log.d("ActivityResultTAG","Result cancelled")
                    }
                }catch (e:Exception){
                    Log.d("ActivityResultTAG",e.message?:"Unknown error")
                }
            }
        }
        super.onAttach(context)

    }




    @SuppressLint("SourceLockedOrientationActivity")
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
                 findNavController().navigate(
                     R.id.action_signInFragment_to_forgotPasswordFragment
                 )
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
            passwordEditText?.typeface = Typeface.DEFAULT
            passwordEditText?.setSelection(passwordEditText.text?.length ?: 0)
        }

        binding?.loginToYourAccount?.setOnClickListener{
            val email = binding?.emailTextField?.text.toString()
            val password = binding?.passwordTextField?.text.toString()

            signIn(
                email = email,
                password = password,
                context = view.context
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
                    context = view.context
                )
            }
            return@setOnEditorActionListener true
        }

        binding?.googleButton?.setOnClickListener {
            lifecycleScope.launch{
                val authorizedWithGmailData = authenticationViewModel.authorizeWithGmail()
                val userEmail = authorizedWithGmailData.email
                val isUserExist = authenticationViewModel.isUserExistOrNot(userEmail)
                if(!isUserExist){
                    val gmailSignUp = authenticationViewModel.gmailSignUp()
                    launcher?.launch(
                        IntentSenderRequest.Builder(
                            gmailSignUp
                        ).build()
                    )
                    authenticationViewModel.gmailAuthState.collect{
                            result->
                        if(result != null){
                            authenticationViewModel.insertGmailUser()
                            initAdCallback(view.context)
                        }
                    }
                } else {
                     val gmailSignIn = authenticationViewModel.gmailSignIn()
                     launcher?.launch(
                         IntentSenderRequest.Builder(
                             gmailSignIn
                         ).build()
                     )
                    authenticationViewModel.gmailAuthState.collect{
                        result->
                        if(result != null){
                            authenticationViewModel.insertGmailUser()
                            initAdCallback(view.context)
                        }
                    }
                }

            }
            }
        }


    private fun signIn(
        email:String,
        password:String,
        context: Context,
    ) {
        validationViewModel.checkEventWhenSignIn(
            eventWhenSignIn = ValidationEventWhenSignIn.ValidationProcess(
                email = email,
                password = password
            )
        )

        lifecycleScope.launch {
            validationViewModel.fieldsState.collect{result->
                if(
                    result.nameError == null &&
                    result.emailError == null &&
                    result.passwordError == null
                ){
                    binding?.emailError?.visibility = INVISIBLE
                    binding?.passwordError?.visibility = INVISIBLE
                    authenticationViewModel.signIn(
                        email = email,
                        password = password
                    )
                    authenticationViewModel.signInState.collect{ event->
                        when(event){
                            is SignInEvent.Error -> {
                                showToast(
                                    message = event.error,
                                    context = context
                                )
                            }
                            is SignInEvent.Success -> {
                                val isEmailVerified = authenticationViewModel.isEmailVerified
                                if(!isEmailVerified){
                                    showToast(
                                        message = "We've sent you an email to verify your account.",
                                        context = context
                                    )
                                    authenticationViewModel.sendEmailVerification()
                                    delay(30)
                                    findNavController().navigate(
                                        R.id.action_signInFragment_to_emailVerificationFragment
                                    )
                                } else {
                                    authenticationViewModel.retrieveUserName(email)
                                    delay(10)
                                    authenticationViewModel.userNameFlow.collect{ name->
                                        Log.d("TAG_NAME", name)
                                        authenticationViewModel.insertUser(
                                            UserEntity(
                                                name = name,
                                                email = email,
                                                password = password
                                            )
                                        )
                                        initAdCallback(context)

                                    }
                                }
                            }

                            SignInEvent.Loading ->{
                                Log.d(STATE_LOADING,"Loading...")
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


    private fun initAdCallback(
        localContext: Context
    ):Unit?{
        val adRequest = AdRequest.Builder().build()
        InterstitialAd.load(
            localContext,"ca-app-pub-9481709154583117/5969237894",adRequest,
            object : InterstitialAdLoadCallback(){
                override fun onAdFailedToLoad(p0: LoadAdError) {
                    super.onAdFailedToLoad(p0)
                    ad = null
                    Log.d("AdError","onAdFailedToLoad : ${p0.message}")
                }

                override fun onAdLoaded(p0: InterstitialAd) {
                    super.onAdLoaded(p0)
                    ad = p0
                    Log.d("OnAddLoaded","$p0")
                }
            }
        )
            ad?.fullScreenContentCallback =
                object : FullScreenContentCallback(){
                    override fun onAdFailedToShowFullScreenContent(
                        p0: AdError
                    ) {
                        super.onAdFailedToShowFullScreenContent(p0)
                        ad = null
                       Log.d("AdError","OnAdFailedToShowFullScreenContent:${p0.message}")
                    }

                    override fun onAdDismissedFullScreenContent() {
                        super.onAdDismissedFullScreenContent()
                        sharedPreferences?.edit()?.apply {
                            putBoolean(USER_AUTHORIZED_WITH_GMAIL,true)
                        }?.apply()
                        val navOptions = NavOptions.Builder()
                            .setPopUpTo(R.id.signInFragment,true)
                            .build()
                        findNavController().navigate(
                            R.id.action_signInFragment_to_homeFragment, null, navOptions
                        )
                    }
                }
            return ad?.show(requireActivity())
    }


    override fun onDestroyView() {
        super.onDestroyView()
        sharedPreferences = null
        binding = null
        launcher = null
    }

}