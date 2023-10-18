package com.appifest.fashion.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.appifest.fashion.R
import com.appifest.fashion.viewmodels.MainViewModel
import com.google.android.material.button.MaterialButton
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SignUpActivity : AppCompatActivity() {
    val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        findViewById<MaterialButton>(R.id.button).setOnClickListener {
            var intent = Intent(this, VerifyEmailSignupActivity::class.java)
            startActivity(intent)

        }
    }
}