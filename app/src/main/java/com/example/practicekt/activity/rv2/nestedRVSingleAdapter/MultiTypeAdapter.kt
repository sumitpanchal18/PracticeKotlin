import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practicekt.R
import com.example.practicekt.activity.rv2.nestedRVSingleAdapter.ListItem

class MultiTypeAdapter(private val items: List<ListItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_ONE = 0
        private const val TYPE_TWO = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is ListItem.TypeOne -> TYPE_ONE
            is ListItem.TypeTwo -> TYPE_TWO
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_ONE -> {
                val view = inflater.inflate(R.layout.item_type_one, parent, false)
                TypeOneViewHolder(view)
            }

            TYPE_TWO -> {
                val view = inflater.inflate(R.layout.item_type_two, parent, false)
                TypeTwoViewHolder(view)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        when (holder) {
            is TypeOneViewHolder -> holder.bind(item as ListItem.TypeOne)
            is TypeTwoViewHolder -> holder.bind(item as ListItem.TypeTwo)
        }
    }

    override fun getItemCount(): Int = items.size

    class TypeOneViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val titleText: TextView = view.findViewById(R.id.titleText)
        fun bind(item: ListItem.TypeOne) {
            titleText.text = item.title
        }
    }

    class TypeTwoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val image: ImageView = view.findViewById(R.id.imageViewNEWW)
        private val caption: TextView = view.findViewById(R.id.captionText)
        fun bind(item: ListItem.TypeTwo) {
            image.setImageResource(item.imageResId)
//            caption.text = item.imageResId
        }
    }
}