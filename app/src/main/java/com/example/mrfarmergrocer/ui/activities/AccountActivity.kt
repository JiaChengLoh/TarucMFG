package com.example.mrfarmergrocer.ui.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mrfarmergrocer.R
import kotlinx.android.synthetic.main.activity_account.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.bottom_nav_view.*

class AccountActivity : AppCompatActivity() {

    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        // logout
        preferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        btn_address.setOnClickListener {
            val intent = Intent(this@AccountActivity, AddressListActivity::class.java)
            startActivity(intent)
            finish()
        }

        btn_logout.setOnClickListener {
            val editor: SharedPreferences.Editor = preferences.edit()
            editor.clear()
            editor.apply()

            val intent = Intent(this@AccountActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}