package com.test.sign_up.presentation.fragment
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.nutrition.core.R
import com.test.sign_up.databinding.SignUpFragmentBinding
import com.test.sign_up.domain.event.EventSignUp
import com.test.sign_up.domain.event.ValidationEvent
import com.test.sign_up.presentation.componentProvider.SignUpComponentProvider
import com.test.sign_up.presentation.viewModel.SignUpViewModel
import com.test.sign_up.presentation.viewModel.SignUpViewModelFactory
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import utils.showToast
import javax.inject.Inject

private const val STATE_LOADING = "StateLoading"
class SignUpFragment : Fragment() {
    private var binding: SignUpFragmentBinding?=null
    @Inject
    lateinit var viewModelFactory: SignUpViewModelFactory
    private val viewModel by viewModels<SignUpViewModel> {
        viewModelFactory
    }
    private var sharedPreferences: SharedPreferences?=null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as SignUpComponentProvider)
            .provideSignUpComponent(this)
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
            passwordEditText?.setSelection(passwordEditText.text?.length ?: 0)
        }

        binding?.alreadyHaveAccountButton?.setOnClickListener {
            val actionId = viewModel.navigateSignUpToSignIn()
            findNavController().navigate(actionId)
        }

        binding?.createAccountButton?.setOnClickListener {
            handleAccountCreateAction(
                context = view.context,
                name = binding?.nameTextField?.text.toString(),
                email = binding?.emailTextField?.text.toString(),
                password = binding?.passwordTextField?.text.toString(),
            )
        }

        binding?.passwordTextField?.setOnEditorActionListener {
                _, actionId, event ->
            if(event != null && event.keyCode == KeyEvent.KEYCODE_ENTER
                || actionId == EditorInfo.IME_ACTION_DONE
            ){
                handleAccountCreateAction(
                    context = view.context,
                    name = binding?.nameTextField?.text.toString(),
                    email = binding?.emailTextField?.text.toString(),
                    password = binding?.passwordTextField?.text.toString(),
                )
            }
            false
        }
    }

    private fun handleAccountCreateAction(
        context: Context,
        name:String,
        email:String,
        password:String
    ) {
       viewModel.checkEvent(
           ValidationEvent.ValidationProcess(
               name = name,
               email = email,
               password = password
           )
       )
        lifecycleScope.launch {
            repeatOnLifecycle(viewLifecycleOwner.lifecycle.currentState){
                viewModel.fieldsState.collect{
                    result->
                    if(
                        result.nameError == null &&
                        result.emailError == null &&
                        result.passwordError == null){
                        binding?.emailError?.visibility = INVISIBLE
                        binding?.nameError?.visibility = INVISIBLE
                        binding?.passwordError?.visibility = INVISIBLE
                        viewModel.signUp(
                            email = email,
                            password = password
                        )
                        viewModel.signUpState.collect{
                            event->
                            when(event){
                                is EventSignUp.Error -> {
                                    showToast(
                                        message = event.error,
                                        context = context
                                    )
                                }
                                is EventSignUp.Loading -> {
                                    binding?.progressBarSignUp?.visibility = VISIBLE
                                    Log.d(STATE_LOADING, "Loading...")
                                }
                                is EventSignUp.Success -> {
                                    sharedPreferences?.edit()?.apply {
                                        putString("name",name)
                                        putString("email",email)
                                        putString("password",password)
                                    }?.apply()
                                    viewModel.sendEmailVerification()
                                    delay(40)
                                    val actionId = viewModel
                                        .navigateSignUpToEmailVerification()
                                    findNavController().navigate(actionId)
                                }
                            }
                        }
                    } else {
                        binding?.nameError?.text = result.nameError
                        binding?.emailError?.text = result.emailError
                        binding?.passwordError?.text = result.passwordError
                        binding?.emailError?.visibility = VISIBLE
                        binding?.nameError?.visibility = VISIBLE
                        binding?.passwordError?.visibility = VISIBLE
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}