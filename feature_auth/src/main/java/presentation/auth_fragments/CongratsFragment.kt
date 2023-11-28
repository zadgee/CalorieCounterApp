package presentation.auth_fragments
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import com.nutrition.feature_auth.R
import com.nutrition.feature_auth.databinding.FragmentCongratsBinding
import androidx.navigation.fragment.findNavController
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class CongratsFragment : Fragment() {
private var binding:FragmentCongratsBinding?=null
private var ad:InterstitialAd? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCongratsBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.goHomeButton?.setOnClickListener {
            val adRequest = AdRequest.Builder().build()
            InterstitialAd.load(
                view.context,"ca-app-pub-9481709154583117/5969237894",adRequest,
                object :InterstitialAdLoadCallback(){
                    override fun onAdFailedToLoad(p0: LoadAdError) {
                        super.onAdFailedToLoad(p0)
                        ad = null
                        Log.d("AdError","onAdFailedToLoad : ${p0.message}")
                    }

                    override fun onAdLoaded(p0: InterstitialAd) {
                        super.onAdLoaded(p0)
                        ad = p0
                        Log.d("OnAdLoaded","$p0")
                    }
                }
                )

               ad?.fullScreenContentCallback = object : FullScreenContentCallback(){
                   override fun onAdDismissedFullScreenContent() {
                       val navOptions = NavOptions.Builder()
                           .setPopUpTo(R.id.congratsFragment,true)
                           .build()
                       findNavController().navigate(
                           R.id.action_congratsFragment_to_homeFragment,null,navOptions
                       )
                   }


                   override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                       super.onAdFailedToShowFullScreenContent(p0)
                       ad = null
                       Log.d("AdError","OnAdFailedToShowFullScreenContent")
                   }

               }
            ad?.show(
                requireActivity().parent
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        ad = null
    }




}