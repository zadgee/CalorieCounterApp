package presentation.main_fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nutrition.feature_home.databinding.MainFragmentBinding

class MainFragment : Fragment() {
private var binding : MainFragmentBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainFragmentBinding.inflate(layoutInflater)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.bottomNavigationBar?.setOnItemReselectedListener {
            item->
            when(item.itemId){

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}