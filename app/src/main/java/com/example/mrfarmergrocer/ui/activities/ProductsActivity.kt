package com.example.mrfarmergrocer.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.mrfarmergrocer.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class ProductsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        bottom_nav_view.selectedItemId = R.id.nav_products

        bottom_nav_view.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this@ProductsActivity, MainActivity::class.java))
                    overridePendingTransition(0,0)
                }
                R.id.nav_products -> {
                }
                R.id.nav_orders -> {
                    startActivity(Intent(this@ProductsActivity, OrdersActivity::class.java))
                    overridePendingTransition(0,0)
                }
                R.id.nav_account -> {
                    startActivity(Intent(this@ProductsActivity, AccountActivity::class.java))
                    overridePendingTransition(0,0)
                }
            }
            false
        })

        val cart_view = findViewById(R.id.imageView) as ImageView

        cart_view.setOnClickListener{
            startActivity(Intent(this@ProductsActivity, CartListActivity::class.java))
            overridePendingTransition(0,0)
        }
    }



}