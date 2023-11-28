package application
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.google.android.gms.ads.MobileAds
import com.nutrition.caloriecountingapp.R
import com.nutrition.caloriecountingapp.databinding.ActivityMainBinding
import com.nutrition.feature_auth.R.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import presentation.ConnectivityState
import presentation.NetworkConnectivityChecking
import presentation.USER_AUTHORIZED_AND_VERIFY_EMAIL
import presentation.USER_AUTHORIZED_WITH_GMAIL
import splashScreen.SKIP_SPLASH

class MainActivity : AppCompatActivity() {
    private var binding:ActivityMainBinding? = null
    private var sharedPreferences:SharedPreferences? = null
    private lateinit var connectivityObserver: ConnectivityState


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        connectivityObserver = NetworkConnectivityChecking(context = applicationContext)
        sharedPreferences = applicationContext.getSharedPreferences(
            "Preferences",Context.MODE_PRIVATE
        )
        setContentView(binding?.root)
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

            val navHostFragment = binding?.navHostFragment?.getFragment<NavHostFragment>()
            val inflater = navHostFragment?.navController?.navInflater
            val navController = navHostFragment?.navController
            val graph = inflater?.inflate(R.navigation.navigation)

            if(isUserSignedInAndVerified == true || isUserSignedInWithGmail == true ){
                graph?.setStartDestination(R.id.welcomeFragment)
                delay(1500)
                graph?.setStartDestination(id.home_navigation)
            } else if(isUserSawStartScreen == true){
                graph?.setStartDestination(id.auth_navigation)
            } else {
                graph?.setStartDestination(R.id.splashFragment)
            }
            navController?.setGraph(
                graph ?: throw NullPointerException("graph cannot be null")
                ,intent.extras
            )
        }
    }

    override fun onStart() {
        super.onStart()
        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.navHostFragment
        ) as NavHostFragment
        val navController = navHostFragment.navController

        lifecycleScope.launch {
            connectivityObserver.observeConnection().collect { status ->
                when (status) {
                    ConnectivityState.Status.Losing -> {
                        navController.navigate(id.badInternetFragment)
                    }
                    ConnectivityState.Status.Lost -> {
                        navController.navigate(id.noInternetFragment)
                    }
                    ConnectivityState.Status.Unavailable -> {
                        navController.navigate(id.noInternetFragment)
                    }
                    ConnectivityState.Status.Available -> {
                        navController.popBackStack()
                    }
                }
            }
        }
    }



    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}