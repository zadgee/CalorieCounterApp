package application
import SKIP_SPLASH
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.google.android.gms.ads.MobileAds
import com.nutrition.caloriecountingapp.R
import com.nutrition.caloriecountingapp.databinding.ActivityMainBinding
import com.test.sign_in.presentation.USER_AUTHORIZED_AND_VERIFY_EMAIL
import com.test.sign_in.presentation.USER_AUTHORIZED_WITH_GMAIL
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(){
    private var binding: ActivityMainBinding? = null
    private var sharedPreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        sharedPreferences = applicationContext.getSharedPreferences(
            "Preferences", Context.MODE_PRIVATE
        )
        MobileAds.initialize(this)
        lifecycleScope.launch {
            val isUserSawStartScreen = sharedPreferences?.getBoolean(
                SKIP_SPLASH,false
            )
            val isUserSignedInAndVerified = sharedPreferences?.getBoolean(
                USER_AUTHORIZED_AND_VERIFY_EMAIL,false
            )

            val isUserSignedInWithGmail = sharedPreferences?.getBoolean(
                USER_AUTHORIZED_WITH_GMAIL,false
            )
            val navHostFragment = binding?.fragmentContainer?.getFragment<NavHostFragment>()
            val inflater = navHostFragment?.navController?.navInflater
            val navController = navHostFragment?.navController
            val graph = inflater?.inflate(R.navigation.navigation)

            if(isUserSignedInAndVerified == true ||
                isUserSignedInWithGmail == true){
                graph?.setStartDestination(R.id.homeFragment)
            } else if(isUserSawStartScreen == true){
                graph?.setStartDestination(R.id.signUpFragment)
            } else {
                graph?.setStartDestination(R.id.splashFragment)
            }
            navController?.setGraph(
                graph ?: throw NullPointerException("graph cannot be null")
                ,intent.extras
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}