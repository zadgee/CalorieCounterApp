package splashScreen
import SKIP_SPLASH
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.nutrition.caloriecountingapp.R
import com.nutrition.caloriecountingapp.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import presentation.USER_AUTHORIZED_AND_VERIFY_EMAIL
import presentation.USER_AUTHORIZED_WITH_GMAIL


class SplashFragment : Fragment() {
private var binding : FragmentSplashBinding? = null
private var sharedPreferences:SharedPreferences?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(layoutInflater)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         sharedPreferences = context?.getSharedPreferences(
            "Preferences", Context.MODE_PRIVATE
        )

        val isUserClickedNextButton = sharedPreferences?.getBoolean(
            SKIP_SPLASH,false
        )

        val isUserSignedInAndVerified = sharedPreferences?.getBoolean(
            USER_AUTHORIZED_AND_VERIFY_EMAIL,false
        )

        val isUserSignedInWithGmail = sharedPreferences?.getBoolean(
            USER_AUTHORIZED_WITH_GMAIL,false
        )

        if(isUserSignedInWithGmail == true){
            Log.d("TAG","Home Navigation cause' of gmail sign in")
            findNavController().navigate(R.id.action_splashFragment_home_navigation)
        }
        else if(isUserSignedInAndVerified == true){
            Log.d("TAG","Home Navigation")
            findNavController().navigate(R.id.action_splashFragment_home_navigation)
        }else if(isUserClickedNextButton == true){
            Log.d("TAG","Auth Navigation")
            findNavController().navigate(R.id.action_splashFragment_auth_navigation)
        }else{
            binding?.nextButton?.setOnClickListener {
                lifecycleScope.launch {
                    sharedPreferences?.edit()?.putBoolean(SKIP_SPLASH,true)?.apply()
                    delay(5)
                    findNavController().navigate(R.id.action_splashFragment_auth_navigation)
                }
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}