package com.appifest.fashion.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.appifest.fashion.R
import com.appifest.fashion.domain.model.itemsDataClass

class SearchModeAdapter(private val listOfItems: ArrayList<itemsDataClass>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_search_card_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return listOfItems.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}