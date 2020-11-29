package com.example.mrfarmergrocer.ui.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mrfarmergrocer.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_account.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.et_email
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.bottom_nav_view.*

class AccountActivity : AppCompatActivity() {

    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        preferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        btn_logout.setOnClickListener {

            val editor: SharedPreferences.Editor = preferences.edit()
            editor.clear()
            editor.apply()

            val intent = Intent(this@AccountActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        bottom_nav_view.selectedItemId = R.id.nav_account

        bottom_nav_view.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this@AccountActivity, MainActivity::class.java))
                    overridePendingTransition(0,0)
                }
                R.id.nav_products -> {
                    startActivity(Intent(this@AccountActivity, ProductsActivity::class.java))
                    overridePendingTransition(0,0)
                }
                R.id.nav_orders -> {
                    startActivity(Intent(this@AccountActivity, OrdersActivity::class.java))
                    overridePendingTransition(0,0)
                }
                R.id.nav_account -> {
                }
            }
            false
        })
    }
}