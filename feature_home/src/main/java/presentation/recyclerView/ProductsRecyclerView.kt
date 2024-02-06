package presentation.recyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.nutrition.feature_home.databinding.RecviewHomeLayoutBinding

class ProductsRecyclerView:RecyclerView.Adapter<ProductsRecyclerView.ViewHolder>(){
    private var listWithProducts:List<Any> = emptyList()
        set(value){
           val diffUtilCallback = DiffUtilCallback(field,value)
           val diffResult = DiffUtil.calculateDiff(diffUtilCallback)
           field = value
           diffResult.dispatchUpdatesTo(this)
        }
    private var binding:RecviewHomeLayoutBinding? = null
    inner class ViewHolder:RecyclerView.ViewHolder(binding?.root ?: throw Exception(
        "binding cannot be null"
    ))

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductsRecyclerView.ViewHolder {
        binding = RecviewHomeLayoutBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: ProductsRecyclerView.ViewHolder, position: Int) {
        TODO("set my model data to views")
    }

    override fun getItemCount(): Int {
      return listWithProducts.size
    }
}


// Todo change lists type to model which i'll retrieve from server
class DiffUtilCallback(
    private val oldList:List<Any>, private val newList:List<Any>
):DiffUtil.Callback(){
    override fun getOldListSize(): Int  = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem.javaClass == newItem.javaClass
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem == newItem
    }

}