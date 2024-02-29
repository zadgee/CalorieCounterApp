package presentation.fragment
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.viewModels
import com.google.android.gms.ads.AdRequest
import com.nutrition.feature_search.databinding.FragmentSearchBinding
import domain.SearchComponentProvider
import presentation.viewModel.SearchViewModel
import presentation.viewModel.SearchViewModelFactory
import javax.inject.Inject


class SearchFragment : Fragment() {
private var binding : FragmentSearchBinding? = null
@Inject lateinit var viewModelFactory: SearchViewModelFactory
private val viewModel by viewModels<SearchViewModel> { viewModelFactory }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adRequest = AdRequest.Builder().build()
        binding?.adViewInsideSearch?.loadAd(adRequest)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as SearchComponentProvider)
            .provideViewModelFactory(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val searchViewEditText = binding?.searchFoodView
            ?.findViewById<EditText>(
                androidx.appcompat.R.id.search_src_text
            )
//        val typeface = viewModel.pathToTextFieldsFont(
//            com.nutrition.core.R.font.textfields_font
//        )
//        searchViewEditText?.typeface = typeface
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}