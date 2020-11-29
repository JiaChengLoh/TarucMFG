package com.example.mrfarmergrocer.ui.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mrfarmergrocer.R
import com.example.mrfarmergrocer.firestore.FirestoreClass
import com.example.mrfarmergrocer.models.Product
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_products.*
import kotlinx.android.synthetic.main.bottom_nav_view.*
import com.example.mrfarmergrocer.utils.Constants


class ProductsActivity : BaseActivity() {

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

    fun successProductsListFromFireStore(productsList: ArrayList<Product>) {

        // Hide Progress dialog.
        hideProgressDialog()

        for(i in productsList){
            Log.i("Price", i.price)
        }

        /*
        if (productsList.size > 0) {
            rv_my_product_items.visibility = View.VISIBLE
            tv_no_products_found.visibility = View.GONE

            rv_my_product_items.layoutManager = LinearLayoutManager(activity)
            rv_my_product_items.setHasFixedSize(true)

            val adapterProducts =
                    MyProductsListAdapter(requireActivity(), productsList, this@ProductsFragment)
            rv_my_product_items.adapter = adapterProducts
        } else {
            rv_my_product_items.visibility = View.GONE
            tv_no_products_found.visibility = View.VISIBLE
        }
        */

    }

    private fun getProductListFromFireStore(){
        showProgressDialog(resources.getString(R.string.please_wait))
        FirestoreClass().getProductsList(this)

    }

    override fun onResume(){
        super.onResume()
        getProductListFromFireStore()
    }

}