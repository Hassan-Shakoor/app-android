package com.appifest.fashion.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.appifest.fashion.R

class LogInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)


        findViewById<TextView>(R.id.sign_up).setOnClickListener {
            var intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.forgot_pass).setOnClickListener {
            var intent = Intent(this, ForgetPasswordActivity::class.java)
            startActivity(intent)

        }



        findViewById<TextView>(R.id.btn_login).setOnClickListener {
            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}