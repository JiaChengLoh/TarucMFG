package com.example.mrfarmergrocer.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView

import androidx.appcompat.app.AppCompatActivity
import com.example.mrfarmergrocer.R
import com.example.mrfarmergrocer.utils.Constants
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create an instance of Android SharedPreferences
        val sharedPreferences =
            getSharedPreferences(Constants.MRFARMERGROCER_PREFERENCES, Context.MODE_PRIVATE)

        val username = sharedPreferences.getString(Constants.LOGGED_IN_USERNAME, "")!!
        // Set the result to the tv_main.
        //tv_main.text= "The logged in user is $username."

        bottom_nav_view.selectedItemId = R.id.nav_home

        bottom_nav_view.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                }
                R.id.nav_products -> {
                    startActivity(Intent(this@MainActivity, ProductsActivity::class.java))
                    overridePendingTransition(0,0)
                }
                R.id.nav_orders -> {
                    startActivity(Intent(this@MainActivity, OrdersActivity::class.java))
                    overridePendingTransition(0,0)
                }
                R.id.nav_account -> {
                    startActivity(Intent(this@MainActivity, AccountActivity::class.java))
                    overridePendingTransition(0,0)
                }
            }
            false
        })


        val cart_view = findViewById(R.id.imageView) as ImageView

        cart_view.setOnClickListener{
            startActivity(Intent(this@MainActivity, CartListActivity::class.java))
            overridePendingTransition(0,0)
        }


    }

    override fun onBackPressed() {
        doubleBackToExit()
    }



}


