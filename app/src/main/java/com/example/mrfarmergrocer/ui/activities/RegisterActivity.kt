package com.example.mrfarmergrocer.ui.activities

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.*
import com.example.mrfarmergrocer.R

class RegisterActivity : BaseActivity() {

    var btn_register: Button = findViewById(R.id.btn_register)
    var toolbar_register_activity: Toolbar = findViewById(R.id.toolbar_register_activity)
    var et_confirm_password: EditText = findViewById(R.id.et_confirm_password)
    var et_email: EditText = findViewById(R.id.et_email)
    var et_first_name: EditText = findViewById(R.id.et_first_name)
    var et_last_name: EditText = findViewById(R.id.et_last_name)
    var et_password: EditText = findViewById(R.id.et_password)
    var cb_terms_and_condition: CheckBox = findViewById(R.id.cb_terms_and_condition)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        @Suppress("DEPRECATION")
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        }else{
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        //setupActionBar()

        val tv_login: TextView = findViewById(R.id.tv_login)
        tv_login.setOnClickListener {

            // Launch the register screen when the user clicks on the text.
            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(intent)
        }

        btn_register.setOnClickListener {

            validateRegisterDetails()
        }
    }

    //private fun setupActionBar() {

        //setSupportActionBar(findViewById(R.id.toolbar_register_activity)

        //val actionBar = supportActionBar
        //if (actionBar != null) {
            //actionBar.setDisplayHomeAsUpEnabled(true)
            //actionBar.setHomeAsUpIndicator(R.drawable.ic_black_color_back_24)
        //}

        //toolbar_register_activity.setNavigationOnClickListener { onBackPressed() }
    //}

    private fun validateRegisterDetails(): Boolean {
        return when {
            TextUtils.isEmpty(et_first_name.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_first_name), true)
                false
            }

            TextUtils.isEmpty(et_last_name.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_last_name), true)
                false
            }

            TextUtils.isEmpty(et_email.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_email), true)
                false
            }

            TextUtils.isEmpty(et_password.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_password), true)
                false
            }

            TextUtils.isEmpty(et_confirm_password.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_confirm_password), true)
                false
            }

            et_password.text.toString().trim { it <= ' ' } != et_confirm_password.text.toString()
                .trim { it <= ' ' } -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_password_and_confirm_password_mismatch), true)
                false
            }
            !cb_terms_and_condition.isChecked -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_agree_terms_and_condition), true)
                false
            }
            else -> {
                showErrorSnackBar("Your details are valid.", false)
                true
            }
        }
    }
}