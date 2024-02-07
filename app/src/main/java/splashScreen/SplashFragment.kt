package splashScreen
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
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
        binding?.nextButton?.setOnClickListener {
            lifecycleScope.launch {
                sharedPreferences?.edit()?.putBoolean(SKIP_SPLASH,true)?.apply()
                delay(10)
                findNavController().navigate(R.id.action_splashFragment_to_signUpFragment)
                }
            }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}