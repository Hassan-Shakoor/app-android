package com.appifest.fashion.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.appifest.fashion.R
import com.appifest.fashion.activities.ItemSelectActivity
import com.appifest.fashion.domain.model.SectionsDataClass
import com.appifest.fashion.domain.model.itemsDataClass
import pk.edu.fccollege.appifestandroid.RecentlyViewedAdapter
import pk.edu.fccollege.appifestandroid.RecommendedAdapter

class HomePageAdapter(
    private val listOfSections: List<SectionsDataClass>,
    private val listOfItems: ArrayList<itemsDataClass>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var context:Context
    companion object {
        private const val VIEW_TYPE_TYPE1 = 1
        private const val VIEW_TYPE_TYPE2 = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context=parent.context
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_TYPE1 -> {
                val view = inflater.inflate(R.layout.recommended_rcycler_layout, parent, false)
                Type1ViewHolder(view)
            }
            VIEW_TYPE_TYPE2 -> {
                val view = inflater.inflate(R.layout.recently_viewed_recycler_layout, parent, false)
                Type2ViewHolder(view)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is Type1ViewHolder -> holder.bind(listOfSections[position])
            is Type2ViewHolder -> holder.bind(listOfSections[position])
        }
    }

    override fun getItemCount(): Int = listOfSections.size

    override fun getItemViewType(position: Int): Int {
        val data=listOfSections[position]
        return when (data.title) {
            "Recommended" -> VIEW_TYPE_TYPE1
            "RecentlyViewed" -> VIEW_TYPE_TYPE2
            else -> throw IllegalArgumentException("Invalid item type at position $position")
        }
    }

    inner class Type1ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerView:RecyclerView=itemView.findViewById(R.id.recyclerview_recommendedAdapterLayout)
        fun bind(sectionsDataClass: SectionsDataClass) {
            recyclerView.layoutManager=LinearLayoutManager(context,RecyclerView.VERTICAL,false)
            val adapter= RecommendedAdapter(listOfItems)
            recyclerView.adapter=adapter

            adapter.onItemClick= { abc ->
                val intent = Intent(context, ItemSelectActivity::class.java)
                context.startActivity(intent)
            }
        }

    }
//
    inner class Type2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val recyclerView:RecyclerView=itemView.findViewById(R.id.recyclerview_recentlyViewedAdapterLayout)
        fun bind(sectionsDataClass: SectionsDataClass) {
            recyclerView.layoutManager=LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
            val adapter= RecentlyViewedAdapter(listOfItems)
            recyclerView.adapter=adapter
        }
    }
}
