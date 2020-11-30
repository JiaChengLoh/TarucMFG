package com.example.mrfarmergrocer.ui.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import com.example.mrfarmergrocer.R
import com.example.mrfarmergrocer.models.User
import com.example.mrfarmergrocer.firestore.FirestoreClass
import com.example.mrfarmergrocer.utils.Constants
import com.example.mrfarmergrocer.utils.GlideLoader
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_account.*


class AccountActivity : BaseActivity(), View.OnClickListener  {

    lateinit var preferences: SharedPreferences

    // A variable for user details which will be initialized later on.
    private lateinit var mUserDetails: User


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        preferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        setupActionBar()


        tv_edit.setOnClickListener(this@AccountActivity)
        btn_logout.setOnClickListener(this@AccountActivity)
        ll_address.setOnClickListener(this@AccountActivity)


    }

    override fun onResume() {
        super.onResume()

        getUserDetails()
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {

                R.id.tv_edit -> {
                    val intent = Intent(this@AccountActivity, UserProfileActivity::class.java)
                    intent.putExtra(Constants.EXTRA_USER_DETAILS, mUserDetails)
                    startActivity(intent)
                }

                R.id.ll_address -> {
                    val intent = Intent(this@AccountActivity, AddressListActivity::class.java)
                    startActivity(intent)
                }

                R.id.btn_logout -> {

                    val editor: SharedPreferences.Editor = preferences.edit()
                    editor.clear()
                    editor.apply()

                    FirebaseAuth.getInstance().signOut()

                    val intent = Intent(this@AccountActivity, LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish()
                }

            }
        }
    }

    /**
     * A function for actionBar Setup.
     */
    private fun setupActionBar() {

        setSupportActionBar(toolbar_settings_activity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
        }

        toolbar_settings_activity.setNavigationOnClickListener { onBackPressed() }
    }

    private fun getUserDetails() {

        // Show the progress dialog
        showProgressDialog(resources.getString(R.string.please_wait))

        // Call the function of Firestore class to get the user details from firestore which is already created.
        FirestoreClass().getUserDetails(this@AccountActivity)
    }

    /**
     * A function to receive the user details and populate it in the UI.
     */
    fun userDetailsSuccess(user: User) {
        mUserDetails = user


        // Hide the progress dialog
        hideProgressDialog()

        // Load the image using the Glide Loader class.
        GlideLoader(this@AccountActivity).loadUserPicture(user.image, iv_user_photo)

        tv_name.text = "${user.firstName} ${user.lastName}"
        tv_gender.text = user.gender
        tv_email.text = user.email
        tv_mobile_number.text = "${user.mobile}"
    }

}