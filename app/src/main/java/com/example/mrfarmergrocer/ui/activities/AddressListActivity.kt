package com.example.mrfarmergrocer.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mrfarmergrocer.R
import kotlinx.android.synthetic.main.activity_address_list.*

class AddressListActivity : AppCompatActivity() {
    /**
     * This function is auto created by Android when the Activity Class is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        //This call the parent constructor
        super.onCreate(savedInstanceState)
        // This is used to align the xml view to this class
        setContentView(R.layout.activity_address_list)


        setupActionBar()

        tv_add_address.setOnClickListener {
            val intent = Intent(this@AddressListActivity,AddEditAddressActivity::class.java)
            startActivity(intent)
        }
    }

    // TODO Step 9: Create a function to setup action bar.
    // START
    /**
     * A function for actionBar Setup.
     */
    private fun setupActionBar() {

        setSupportActionBar(toolbar_address_list_activity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24)
        }

        toolbar_address_list_activity.setNavigationOnClickListener { onBackPressed() }
    }
    // END
}