package presentation.auth_fragments
import android.annotation.SuppressLint
import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.SharedPreferences
import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
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
import com.google.firebase.auth.GoogleAuthProvider
import com.nutrition.feature_auth.R
import com.nutrition.feature_auth.databinding.FragmentSignInBinding
import domain.models.UserEntity
import domain.event.SignInEvent
import domain.models.GmailUserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import presentation.STATE_LOADING
import presentation.USER_AUTHORIZED_AND_VERIFY_EMAIL
import presentation.USER_AUTHORIZED_WITH_GMAIL
import presentation.event.ValidationEventWhenSignIn
import presentation.showToast
import presentation.viewModels.AuthenticationViewModel
import presentation.viewModels.AuthenticationViewModelFactory
import presentation.viewModels.ValidationViewModel
import javax.inject.Inject


class SignInFragment : Fragment() {
    private var binding : FragmentSignInBinding? = null
    private val validationViewModel by viewModels<ValidationViewModel>()
    private var sharedPreferences: SharedPreferences?=null

    @Inject
    lateinit var viewModelFactory: AuthenticationViewModelFactory
    private val authenticationViewModel:AuthenticationViewModel by viewModels {
        viewModelFactory
    }
    private var launcherGmailSignIn: ActivityResultLauncher<IntentSenderRequest>?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        launcherGmailSignIn = registerForActivityResult(
            ActivityResultContracts.StartIntentSenderForResult()
        ){ result->
            lifecycleScope.launch {
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
                        delay(10)
                        sharedPreferences?.edit()?.apply {
                            putBoolean(USER_AUTHORIZED_WITH_GMAIL,true)
                        }?.apply()
                        delay(10)
                        val userData = authenticationViewModel.authorizeWithGmail()
                        if(userData != null){
                            authenticationViewModel.insertGmailUser(
                                GmailUserEntity(
                                    id = userData.id,
                                    name = userData.name?:"",
                                    photoUrl = userData.pictureUrl?:throw NullPointerException(
                                        "Photo url cannot be null"
                                    )
                                )
                            )
                            delay(20)
                            findNavController().navigate(
                                R.id.action_signInFragment_to_homeFragment
                            )
                         }
                    }
                }catch (e:Exception){
                    Log.d("ActivityResultTAG",e.message?:"Unknown error")
                }
            }
        }
    }

    override fun onAttach(context: Context) {
        authComponent(context.applicationContext)
            .injectSignInFragment(this)
        activity
        super.onAttach(context)
    }



    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.requestedOrientation = SCREEN_ORIENTATION_PORTRAIT
        binding = FragmentSignInBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = context?.getSharedPreferences(
            "Preferences", Context.MODE_PRIVATE
        )
        binding?.forgotPasswordText?.paintFlags = Paint.UNDERLINE_TEXT_FLAG
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
            lifecycleScope.launch(Dispatchers.Default) {
                val signUpAction = authenticationViewModel.gmailSignUp()
                val signInAction = authenticationViewModel.gmailSignIn()
                val finalAction = signUpAction ?: signInAction
                launcherGmailSignIn?.launch(
                    IntentSenderRequest.Builder(
                        finalAction?:return@launch
                    ).build()
                )
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
            repeatOnLifecycle(viewLifecycleOwner.lifecycle.currentState){
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
                                        delay(50)
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
                                            sharedPreferences?.edit()?.apply {
                                                putBoolean(USER_AUTHORIZED_AND_VERIFY_EMAIL,true)
                                            }?.apply()
                                            delay(20)
                                            findNavController().navigate(
                                                R.id.action_signInFragment_to_homeFragment
                                            )
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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        sharedPreferences = null
        binding = null
        launcherGmailSignIn = null
    }

}