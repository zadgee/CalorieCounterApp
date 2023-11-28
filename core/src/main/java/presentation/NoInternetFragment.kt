package presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nutrition.core.R
import com.nutrition.core.databinding.FragmentNoInternetBinding


class NoInternetFragment : Fragment() {
private var binding : FragmentNoInternetBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoInternetBinding.inflate(layoutInflater)
        return binding?.root
    }

    
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}