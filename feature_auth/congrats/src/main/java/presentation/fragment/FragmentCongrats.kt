package presentation.fragment
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.test.congrats.databinding.FragmentCongratsBinding
import componentProvider.CongratsComponentProvider
import javax.inject.Inject

class FragmentCongrats : Fragment() {
    private var binding: FragmentCongratsBinding?=null
    private var ad: InterstitialAd? = null
    @Inject lateinit var viewModelFactory: CongratsViewModelFactory
    private val viewModel by viewModels<CongratsViewModel> {
        viewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadFullScreenAd()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context as CongratsComponentProvider).inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCongratsBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.goHomeButton?.setOnClickListener {
            if(ad != null){
                ad?.fullScreenContentCallback = object : FullScreenContentCallback(){
                    override fun onAdDismissedFullScreenContent() {
                        val actionId = viewModel.navigateCongratsToHome()
                        findNavController().navigate(actionId)
                    }

                    override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                        super.onAdFailedToShowFullScreenContent(p0)
                        ad = null
                        loadFullScreenAd()
                    }

                }
                ad?.show(requireActivity())
            } else {
                val actionId = viewModel.navigateCongratsToHome()
                findNavController().navigate(actionId)
            }
        }
    }


    private fun loadFullScreenAd(){
        val adRequest = AdRequest.Builder().build()
        InterstitialAd.load(requireContext(),"ca-app-pub-9481709154583117/5969237894"
            ,adRequest,
            object : InterstitialAdLoadCallback(){
                override fun onAdLoaded(p0: InterstitialAd) {
                    ad = p0
                    Log.d("AdSuccess","ad loaded")
                }

                override fun onAdFailedToLoad(p0: LoadAdError) {
                    ad = null
                    Log.d("AdError","ad error:${p0.message}")
                }
            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        ad = null
    }
}