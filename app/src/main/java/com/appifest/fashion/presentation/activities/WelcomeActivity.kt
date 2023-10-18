package com.appifest.fashion.activities

import android.animation.AnimatorSet
import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.BackgroundColorSpan
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import com.appifest.fashion.R

class WelcomeActivity : AppCompatActivity() {

    private lateinit var view5: View
    private lateinit var view4: View
    private lateinit var view3: View
    private lateinit var title: TextView
    private lateinit var getStarted: Button
    private lateinit var colorAnimator: AnimatorSet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w: Window = window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }

        getStarted = findViewById(R.id.button_mainActivity_getStarted)
        title = findViewById(R.id.tv_activityMain_whereStyleMeetsConvenience)
        view5 = findViewById(R.id.view5)
        view4 = findViewById(R.id.view4)
        view3 = findViewById(R.id.view3)


        getStarted.setOnClickListener{
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
            finish()
        }

        styleText()
        animateView(view5)
        animateView(view4)
        animateView(view3)
    }


    private fun styleText() {
        val mainString = "Where Style Meets Convenience."
        val subString = "Convenience."

        if (mainString.contains(subString)) {
            val startIndex = mainString.indexOf(subString)
            val endIndex = startIndex + subString.length
            val spannableString = SpannableString(mainString)
            spannableString.setSpan(
                BackgroundColorSpan(Color.parseColor("#BD2EB8")), startIndex, endIndex,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            title.setText(spannableString)
        }
    }

    private fun animateView(view: View) {
        val colorAnimation = ValueAnimator.ofObject(
            ArgbEvaluator(),
            Color.parseColor("#BD2EB8"), // Start color (grey)
            Color.parseColor("#808080")  // End color (pink)
        )

        colorAnimation.duration = 1000  // Animation duration in milliseconds
        colorAnimation.repeatCount = ValueAnimator.INFINITE
        colorAnimation.repeatMode = ValueAnimator.REVERSE  // Reverse animation direction on each iteration

        colorAnimation.addUpdateListener { animator ->
            val color = animator.animatedValue as Int
            view.setBackgroundColor(color)
        }

        colorAnimation.start()
    }
}