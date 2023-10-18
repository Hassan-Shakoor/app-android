package pk.edu.fccollege.appifestandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.appifest.fashion.R
import com.appifest.fashion.domain.model.itemsDataClass

class RecentlyViewedAdapter(private val listOfItems: List<itemsDataClass>) :
    RecyclerView.Adapter<RecentlyViewedAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val imageView: ImageView = itemView.findViewById(R.id.iv_recommendedAdapterLayout_image)
//        val number: TextView = itemView.findViewById(R.id.tv_recomendedAdapterLayout_number)
//        val collection: TextView = itemView.findViewById(R.id.tv_recommendedAdapterLayout_collection)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recently_viewed_adapter_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listOfItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listOfItems[position]
//        if(item.image.equals("image_1")){
//            holder.imageView.setImageResource(R.drawable.image_1)
//        }
//        else if(item.image.equals("image_2")){
//            holder.imageView.setImageResource(R.drawable.image_2)
//        }
//        else{
//            holder.imageView.setImageResource(R.drawable.image_3)
//        }
//        holder.number.text = item.number
//        holder.collection.text = item.collection
    }
}