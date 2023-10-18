package com.appifest.fashion.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.appifest.fashion.R
import com.google.android.material.button.MaterialButton

class ForgetPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)


        findViewById<MaterialButton>(R.id.btn_cnfrm).setOnClickListener {
            var intent = Intent(this, VerifyEmailForgetActivity::class.java)
            startActivity(intent)

        }
    }
}