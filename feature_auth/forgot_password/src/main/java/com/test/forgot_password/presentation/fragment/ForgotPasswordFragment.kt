package com.test.forgot_password.presentation.fragment
import android.content.Context
import android.os.Bundle
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
import com.google.android.gms.ads.AdRequest
import com.test.forgot_password.databinding.FragmentForgotPasswordBinding
import com.test.forgot_password.domain.event.ValidationEventWhenRestoringPassword
import com.test.forgot_password.presentation.componentProvider.ForgotPasswordComponentProvider
import com.test.forgot_password.presentation.viewmodel.ForgotPasswordViewModel
import com.test.forgot_password.presentation.viewmodel.ForgotPasswordViewModelFactory
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import utils.showToast
import javax.inject.Inject

class ForgotPasswordFragment : Fragment() {
private var binding: FragmentForgotPasswordBinding?=null
@Inject lateinit var viewModelFactory: ForgotPasswordViewModelFactory
private val viewModel by viewModels<ForgotPasswordViewModel> {
    viewModelFactory
}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adRequest = AdRequest.Builder().build()
        binding?.adView?.loadAd(adRequest)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentForgotPasswordBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as ForgotPasswordComponentProvider)
            .provideViewModelFactory(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.goBackButton?.setOnClickListener {
            findNavController().popBackStack()
        }
        binding?.alreadyRestorePassword?.setOnClickListener {
            findNavController().popBackStack()
        }
        binding?.nextButton?.setOnClickListener {
            handleRestorePassword(
                context = view.context,
                email = binding?.emailTextField?.text.toString()
            )
        }
        binding?.emailTextField?.setOnEditorActionListener {
                _, actionId, event ->
            if(event != null && event.keyCode == KeyEvent.KEYCODE_ENTER
                || actionId == EditorInfo.IME_ACTION_DONE){
                handleRestorePassword(
                    context = view.context,
                    email = binding?.emailTextField?.text.toString()
                )
            }
            return@setOnEditorActionListener true
        }
    }

    private fun handleRestorePassword(
        context: Context,
        email:String
    ) {
         viewModel.checkEvent(
            event = ValidationEventWhenRestoringPassword.ValidationProcess(
                email = email
            )
         )
        lifecycleScope.launch {
            repeatOnLifecycle(viewLifecycleOwner.lifecycle.currentState) {
                viewModel.emailFieldState.collect{
                        result->
                    if(result.emailError != null){
                        binding?.emailError?.text = result.emailError
                        binding?.emailError?.visibility = VISIBLE
                    } else {
                        binding?.emailError?.visibility = INVISIBLE
                        viewModel.sendResetPasswordEmail(email)
                        delay(15)
                        showToast(
                            message = "Check your email",
                            context = context
                        )
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