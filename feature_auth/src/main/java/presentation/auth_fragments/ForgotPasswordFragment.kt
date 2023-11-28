package presentation.auth_fragments

import android.annotation.SuppressLint
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
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.google.android.gms.ads.AdRequest
import com.nutrition.feature_auth.R
import com.nutrition.feature_auth.databinding.FragmentForgotPasswordBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import presentation.event.ValidationEventWhenRestoringPassword
import presentation.viewModels.AuthenticationViewModel
import presentation.viewModels.AuthenticationViewModelFactory
import presentation.viewModels.ValidationViewModel
import javax.inject.Inject


class ForgotPasswordFragment : Fragment() {
    private var binding:FragmentForgotPasswordBinding?=null
    private val validationViewModel by viewModels<ValidationViewModel>()
    @Inject
    lateinit var viewModelFactory: AuthenticationViewModelFactory
    private val authenticationViewModel: AuthenticationViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adRequest = AdRequest.Builder().build()
        binding?.adView?.loadAd(adRequest)
    }


    override fun onAttach(context: Context) {
        authComponent(context.applicationContext)
            .injectForgotPasswordFragment(this)
        activity
        super.onAttach(context)

    }

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentForgotPasswordBinding.inflate(layoutInflater)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adRequest = AdRequest.Builder().build()
        binding?.adView?.loadAd(adRequest)
        binding?.adView?.visibility = VISIBLE

        binding?.goBackButton?.setOnClickListener {
            findNavController().navigate(R.id.action_forgotPasswordFragment_to_signInFragment)
        }
        binding?.alreadyRestorePassword?.setOnClickListener {
            findNavController().navigate(R.id.action_forgotPasswordFragment_to_signInFragment)
        }
        binding?.nextButton?.setOnClickListener {
            lifecycleScope.launch {
                handleRestorePassword(
                    context = view.context
                )
            }
        }
        binding?.emailTextField?.setOnEditorActionListener {
                _, actionId, event ->
            if(event != null && event.keyCode == KeyEvent.KEYCODE_ENTER
                || actionId == EditorInfo.IME_ACTION_DONE){
                lifecycleScope.launch {
                    handleRestorePassword(
                        context = view.context
                    )
                }
            }
            return@setOnEditorActionListener true
        }
    }

    private suspend fun handleRestorePassword(
        context: Context
    ){
        val email = binding?.emailTextField?.text.toString()
        validationViewModel.checkEventWhenRestoringPassword(
            ValidationEventWhenRestoringPassword.ValidationProcess(
                email = email
            )
        )
        lifecycleScope.launch {
            repeatOnLifecycle(viewLifecycleOwner.lifecycle.currentState) {
                validationViewModel.fieldsState.collect{
                        result->
                    if(result.emailError!=null){
                        binding?.emailError?.text = result.emailError
                        binding?.emailError?.visibility = VISIBLE
                    } else {
                        binding?.emailError?.visibility = INVISIBLE
                        withContext(Dispatchers.IO){
                            authenticationViewModel.sendResetPasswordEmail(email)
                            Toast.makeText(
                                context,"Check your email",Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onResume() {
        super.onResume()
        binding?.adView?.resume()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding?.adView?.destroy()
    }

    override fun onPause() {
        super.onPause()
        binding?.adView?.pause()
    }

}