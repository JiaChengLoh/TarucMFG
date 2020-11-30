package com.example.mrfarmergrocer.adapter

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mrfarmergrocer.R
import com.example.mrfarmergrocer.models.Product
import com.example.mrfarmergrocer.ui.activities.ProductDetailsActivity
import com.example.mrfarmergrocer.ui.activities.ProductsActivity
import com.example.mrfarmergrocer.utils.Constants
import com.example.mrfarmergrocer.utils.GlideLoader

import kotlinx.android.synthetic.main.item_list_layout.view.*

open class MyProductsListAdapter(
        private val context: Context,
        private var list: ArrayList<Product>,
        private val activity: ProductsActivity
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(
                LayoutInflater.from(context).inflate(
                        R.layout.item_list_layout,
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = list[position]

        if (holder is MyViewHolder) {

            GlideLoader(context).loadProductPicture(model.image, holder.itemView.iv_item_image)

            holder.itemView.tv_item_name.text = model.title
            holder.itemView.tv_item_price.text = "RM ${model.price}"

            holder.itemView.setOnClickListener {
                // Launch Product details screen.
                val intent = Intent(context, ProductDetailsActivity::class.java)
                context.startActivity(intent)
            }

            holder.itemView.setOnClickListener {
                // Launch Product details screen.
                val intent = Intent(context, ProductDetailsActivity::class.java)

                intent.putExtra(Constants.EXTRA_PRODUCT_ID, model.product_id)

                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)
}

