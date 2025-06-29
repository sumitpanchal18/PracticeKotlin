package com.example.practicekt.activity.rv2.doubleRv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.practicekt.R

class ProductAdapter(private var productList: List<ProductDataModelItem>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        var name = item.findViewById<TextView>(R.id.textViewFoodName)
        var description = item.findViewById<TextView>(R.id.textViewFoodDescription)
        var image = item.findViewById<ImageView>(R.id.imageViewFood)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_food, parent, false)

        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.name.text = product.title
        holder.description.text = product.description
        Glide.with(holder.image.context)
            .load(product.image)
            .into(holder.image)
    }
}