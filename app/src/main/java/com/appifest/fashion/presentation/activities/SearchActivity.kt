package com.appifest.fashion.activities

import DivLikeAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.appifest.fashion.R
import com.freecode.searchscreen.SearchAdapter
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent

class SearchActivity : AppCompatActivity() {

    lateinit var searchAdapter : SearchAdapter

    var divLikeContent : ArrayList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        val recyclerView = findViewById<RecyclerView>(R.id.recentSearchesRecyclerView)
        val layoutManager = FlexboxLayoutManager(this)
        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.justifyContent = JustifyContent.SPACE_BETWEEN
        recyclerView.layoutManager = layoutManager

        divLikeContent = ArrayList<String>()
        divLikeContent?.add("Hoodie")
        divLikeContent?.add("Shirt")
        divLikeContent?.add("Watch")
        divLikeContent?.add("Coat")
        divLikeContent?.add("Skirt")
        divLikeContent?.add("Trousers")
        divLikeContent?.add("Suit")
        divLikeContent?.add("Pents")
        divLikeContent?.add("Shorts")

        val adapter = DivLikeAdapter(divLikeContent!!)

        searchAdapter = SearchAdapter(divLikeContent!!)

        recyclerView.adapter = adapter

        var EditText = findViewById<EditText>(R.id.edt_search)

        EditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                filterWithQuery(p0?.toString()!!)
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })

        var recyclerViewSearch = findViewById<RecyclerView>(R.id.recyclerView)

        var searchAdapter = SearchAdapter(divLikeContent!!)

        recyclerViewSearch.adapter = searchAdapter

        recyclerViewSearch.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }

    private fun filterWithQuery(query: String) {


        // Perform operation only is query is not empty
        if (query.isNotEmpty()) {
            // Call the function with valid query and take new filtered list.
            val filteredList: List<String> = searchAdapter.onQueryChanged(query)
            // Call the adapter with new filtered array list
            attachAdapter(filteredList)
            // If the matches are empty hide RecyclerView and show error text
        }
        else if (query.isEmpty()) {
            // If query is empty don't make changes to list
            attachAdapter(divLikeContent!!)
        }
    }

    private fun attachAdapter(list: List<String>) {
        val searchAdapter = SearchAdapter(list)
        findViewById<RecyclerView>(R.id.recyclerView).adapter = searchAdapter
    }
}