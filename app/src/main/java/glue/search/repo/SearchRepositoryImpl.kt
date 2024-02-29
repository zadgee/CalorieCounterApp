package glue.search.repo
import android.content.Context
import android.graphics.Typeface
import android.util.Log
import androidx.core.content.res.ResourcesCompat
import domain.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val context: Context
):SearchRepository {

    override fun setupSearchViewFont(fontId:Int):Typeface{
        val typeface = ResourcesCompat.getFont(context, fontId)?: Typeface.DEFAULT
        Log.d("TAG","typeface: $typeface")
        return typeface
    }

}