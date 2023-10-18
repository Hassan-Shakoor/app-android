package com.appifest.fashion.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import com.appifest.fashion.R
import com.google.android.material.button.MaterialButton

class VerifyEmailSignupActivity : AppCompatActivity() {
    private lateinit var code1: EditText
    private lateinit var code2: EditText
    private lateinit var code3: EditText
    private lateinit var code4: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify_email_signup)

        findViewById<MaterialButton>(R.id.btnVerifyThroughPhone).setOnClickListener {
            var intent = Intent(this, VerifyNumberActivity::class.java)
            startActivity(intent)
            finish()
        }

        initViews()
        codeSendfun()
    }

    private fun initViews() {
        code1 = findViewById(R.id.codeOne)
        code2 = findViewById(R.id.codeTwo)
        code3 = findViewById(R.id.codeThree)
        code4 = findViewById(R.id.codeFour)
    }

    private fun codeSendfun() {
        //for verify code
        code1.addTextChangedListener(GenericTextWatcher(code1, code2))
        code2.addTextChangedListener(GenericTextWatcher(code2, code3))
        code3.addTextChangedListener(GenericTextWatcher(code3, code4))
        code4.addTextChangedListener(GenericTextWatcher(code4, null))

        //GenericKeyEvent here works for deleting the element and to switch back to previous EditText
        //first parameter is the current EditText and second parameter is previous EditText
        code1.setOnKeyListener(GenericKeyEvent(code1, null))
        code2.setOnKeyListener(GenericKeyEvent(code2, code1))
        code3.setOnKeyListener(GenericKeyEvent(code3, code2))
        code4.setOnKeyListener(GenericKeyEvent(code4, code3))

    }

    //for verify code
    class GenericKeyEvent internal constructor(private val currentView: EditText, private val previousView: EditText?) : View.OnKeyListener {
        override fun onKey(p0: View?, keyCode: Int, event: KeyEvent?): Boolean {
            if (event!!.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DEL && currentView.id != R.id.codeOne && currentView.text.isEmpty()) {
                //If current is empty then previous EditText's number will also be deleted
                previousView!!.text = null
                previousView.requestFocus()
                return true
            }
            return false
        }

    }

    class GenericTextWatcher internal constructor(private val currentView: View, private val nextView: View?) :
        TextWatcher {
        override fun afterTextChanged(editable: Editable) { // TODO Auto-generated method stub
            val text = editable.toString()
            when (currentView.id) {
                R.id.codeOne -> if (text.length == 1) nextView!!.requestFocus()
                R.id.codeTwo -> if (text.length == 1) nextView!!.requestFocus()
                R.id.codeThree -> if (text.length == 1) nextView!!.requestFocus()
                //You can use EditText4 same as above to hide the keyboard
            }
        }

        override fun beforeTextChanged(
            arg0: CharSequence,
            arg1: Int,
            arg2: Int,
            arg3: Int
        ) { // TODO Auto-generated method stub
        }

        override fun onTextChanged(
            arg0: CharSequence,
            arg1: Int,
            arg2: Int,
            arg3: Int
        ) { // TODO Auto-generated method stub
        }
    }
}