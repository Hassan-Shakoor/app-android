package com.appifest.fashion.activities

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.appifest.fashion.R
import com.appifest.fashion.adapters.HomePageAdapter
import com.appifest.fashion.domain.model.BrandModel
import com.appifest.fashion.domain.model.CategoryModel
import com.appifest.fashion.domain.model.SectionsDataClass
import com.appifest.fashion.domain.model.itemsDataClass
import com.google.android.material.bottomsheet.BottomSheetDialog

class HomeActivity : AppCompatActivity() {

    lateinit var recyclerview: RecyclerView

    var BrandList= arrayListOf<BrandModel>()
    var CategoryList= arrayListOf<CategoryModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        BrandList= ArrayList<BrandModel>()
        BrandList.add(BrandModel("Gucci"))
        BrandList.add(BrandModel("Bata"))
        BrandList.add(BrandModel("Service"))
        BrandList.add(BrandModel("HNO"))
        BrandList.add(BrandModel("LimeLight"))
        BrandList.add(BrandModel("Warda"))
        BrandList.add(BrandModel("Khadi"))
        BrandList.add(BrandModel("Stylo"))

        CategoryList= ArrayList<CategoryModel>()
        CategoryList.add(CategoryModel("Shoes"))
        CategoryList.add(CategoryModel("Pents"))
        CategoryList.add(CategoryModel("Shirts"))
        CategoryList.add(CategoryModel("Shorts"))
        CategoryList.add(CategoryModel("Socks"))
        CategoryList.add(CategoryModel("T-Shirts"))
        CategoryList.add(CategoryModel("Trousers"))
        CategoryList.add(CategoryModel("Cap"))



        var bottomSheetDialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
        var mBottomSheetBinding = LayoutInflater.from(this).inflate(R.layout.filter_bottom_dialog,null)

        bottomSheetDialog.setContentView(mBottomSheetBinding)
        bottomSheetDialog.setCancelable(true);
        bottomSheetDialog.setCanceledOnTouchOutside(true);

//        mBottomSheetBinding.brandRecyclerView.layoutManager=GridLayoutManager(this,1,GridLayoutManager.HORIZONTAL,false)
//        mBottomSheetBinding.brandRecyclerView.adapter=BrandsListAdapter(this,BrandList)
//
//        mBottomSheetBinding.categoriesRecyclerView.layoutManager=GridLayoutManager(this,2,GridLayoutManager.HORIZONTAL,false)
//        mBottomSheetBinding.categoriesRecyclerView.adapter=CategoryListAdapter(this,CategoryList)

        findViewById<ImageView>(R.id.imageView).setOnClickListener {
            bottomSheetDialog.show()
        }

        findViewById<EditText>(R.id.editText).setOnClickListener {
            var intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }

        // Check if the Android version is Lollipop or higher
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Set the status bar color to white
            window.statusBarColor = Color.WHITE

            // Set the status bar text color to black
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }


        val listOfSection=ArrayList<SectionsDataClass>()
        listOfSection.clear()
        listOfSection.add(SectionsDataClass("Recommended"))
        listOfSection.add(SectionsDataClass("RecentlyViewed"))
//
        val listOfItems=ArrayList<itemsDataClass>()
        listOfItems.clear()
        listOfItems.add(itemsDataClass("image_1","01","OCTOBER COLLECTION"))
        listOfItems.add(itemsDataClass("image_2","02","BLACK COLLECTION"))
        listOfItems.add(itemsDataClass("image_3","03","HAE BY HAEKIM"))

        recyclerview=findViewById(R.id.recyclerview_homePage)
        recyclerview.layoutManager= LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        val adapter= HomePageAdapter(listOfSection,listOfItems)
        recyclerview.adapter=adapter

//        recyclerview=findViewById(R.id.recyclerview_homePage)
//        recyclerview.layoutManager = GridLayoutManager(this, 2)
//        val adapter= SearchModeAdapter(listOfItems)
//        recyclerview.adapter=adapter
    }
}