package presentation.auth_fragments
import android.content.Context
import android.content.SharedPreferences
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
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.nutrition.feature_auth.R
import com.nutrition.feature_auth.databinding.SignUpFragmentBinding
import domain.event.SignUpEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import presentation.STATE_LOADING
import presentation.STATE_SUCCESS
import presentation.event.ValidationEvent
import presentation.viewModels.AuthenticationViewModel
import presentation.viewModels.ValidationViewModel
import utils.showToast
import presentation.viewModels.AuthenticationViewModelFactory
import javax.inject.Inject


class SignUpFragment : Fragment() {
    private var sharedPreferences: SharedPreferences?=null
    private var binding:SignUpFragmentBinding? = null
    private val validationViewModel by viewModels<ValidationViewModel>()
    @Inject
    lateinit var viewModelFactory: AuthenticationViewModelFactory
    private val authenticationViewModel:AuthenticationViewModel by viewModels {
        viewModelFactory
    }


    override fun onAttach(context: Context) {
        authComponent(context.applicationContext)
            .injectSignUpFragment(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SignUpFragmentBinding.inflate(layoutInflater)
        return binding?.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = context?.getSharedPreferences(
            "Preferences", Context.MODE_PRIVATE
        )

        binding?.hideOrShowPasswordButton?.setOnClickListener {
            val passwordEditText = binding?.passwordTextField
            val currentInputType = passwordEditText?.inputType ?: 0

            if (currentInputType == (
                        InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                    )
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



        binding?.alreadyHaveAccountButton?.setOnClickListener {
            findNavController().navigate(
                R.id.action_signUpFragment_to_signInFragment
            )
        }

        binding?.createAccountButton?.setOnClickListener {
            handleAccountCreateAction(
                context = view.context,
                authenticationViewModel = authenticationViewModel
            )
        }

        binding?.passwordTextField?.setOnEditorActionListener {
                _, actionId, event ->
            if(event != null && event.keyCode == KeyEvent.KEYCODE_ENTER
                || actionId == EditorInfo.IME_ACTION_DONE){
                handleAccountCreateAction(
                    context = view.context,
                    authenticationViewModel = authenticationViewModel
                )
            }
            false
        }
    }

    private fun handleAccountCreateAction(
        context:Context,
        authenticationViewModel:AuthenticationViewModel
    ) {
        val name = binding?.nameTextField?.text?.toString() ?:""
        val email = binding?.emailTextField?.text?.toString() ?:""
        val password = binding?.passwordTextField?.text?.toString() ?:""
        validationViewModel.checkEvent(
            ValidationEvent.ValidationProcess(
            name = name,
            email = email,
            password = password
        ))
        lifecycleScope.launch {
            repeatOnLifecycle(viewLifecycleOwner.lifecycle.currentState){
                validationViewModel.fieldsState.collect{result->
                    if(
                        result.nameError == null &&
                        result.emailError == null && result.passwordError == null
                    ){
                        binding?.emailError?.visibility = INVISIBLE
                        binding?.nameError?.visibility = INVISIBLE
                        binding?.passwordError?.visibility = INVISIBLE
                        authenticationViewModel.signUp(
                            email = email,
                            password = password
                        )
                        authenticationViewModel.signUpState.collect { event->
                            when(event){
                                is SignUpEvent.Error ->{
                                    showToast(
                                        message = event.error,
                                        context = context
                                    )
                                }
                                is SignUpEvent.Success ->{
                                    Log.d(STATE_SUCCESS,"Sign up event")
                                    withContext(Dispatchers.IO){
                                        sharedPreferences?.edit()?.apply {
                                            putString("name",name)
                                            putString("email",email)
                                            putString("password",password)
                                        }?.apply()
                                        delay(5)
                                        authenticationViewModel.sendEmailVerification()
                                    }
                                    delay(10)
                                    findNavController().navigate(
                                        R.id.action_signUpFragment_to_emailVerificationFragment
                                    )
                                }
                                SignUpEvent.Loading ->{
                                   Log.d(STATE_LOADING,"Loading...")
                                }
                            }

                        }
                    }else{
                        binding?.nameError?.text = result.nameError
                        binding?.nameError?.visibility = VISIBLE
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
    }

}