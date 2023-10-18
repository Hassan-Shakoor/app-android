package com.appifest.fashion.activities

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.RegexValidator
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import com.appifest.fashion.R

class ItemSelectActivity : AppCompatActivity() {
    lateinit var tvViewAll: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_select)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w: Window = window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
            val decorView = window.decorView
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

        tvViewAll=findViewById(R.id.tv_itemSelectScreen_ViewAllText)

        val text = "View All"
        val spannable = SpannableString(text)
        val underlineSpan = UnderlineSpan()
        spannable.setSpan(underlineSpan, 0, text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        val textColorSpan = ForegroundColorSpan(Color.BLACK)
        spannable.setSpan(textColorSpan, 0, text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        tvViewAll.text = spannable

        tvViewAll.setOnClickListener {
            var intent = Intent(this, ReviewActivity::class.java)
            startActivity(intent)
        }
    }
}