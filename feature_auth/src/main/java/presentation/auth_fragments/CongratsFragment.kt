package presentation.auth_fragments
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nutrition.feature_auth.R
import com.nutrition.feature_auth.databinding.FragmentCongratsBinding
import androidx.navigation.fragment.findNavController

class CongratsFragment : Fragment() {
private var binding:FragmentCongratsBinding?=null


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
            findNavController().navigate(
                    R.id.action_congratsFragment_to_homeFragment
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}