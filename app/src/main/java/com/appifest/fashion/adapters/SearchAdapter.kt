package com.freecode.searchscreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.appifest.fashion.R

class SearchAdapter(private val dataList: List<String>)
    : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(
            LayoutInflater.from(parent.context).inflate(
            R.layout.listlayout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {

        holder.titleTextView.text = dataList[position]
    }

    override fun getItemCount() = dataList.size

    class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.textView2)
    }

     fun onQueryChanged(filterQuery: String): List<String> {
        // Empty new array list which contains new strings
        val filteredList = ArrayList<String>()
        // Loop through each item in list
        for (currentSport in dataList) {
            // Before checking string matching convert string to lower case.
            if (currentSport.toLowerCase().contains(filterQuery)) {
                // If the match is success, add item to list.
                filteredList.add(currentSport)
            }
        }
        return filteredList
    }
}

