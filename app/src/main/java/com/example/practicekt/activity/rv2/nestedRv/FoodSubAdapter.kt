package com.example.practicekt.activity.rv2.nestedRv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practicekt.R

class FoodSubAdapter(private val subItemList: List<FoodSubItem>) :
    RecyclerView.Adapter<FoodSubAdapter.FoodSubViewHolder>() {

    inner class FoodSubViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val subFoodImage: ImageView = view.findViewById(R.id.imageViewSubFood)
        val subFoodName: TextView = view.findViewById(R.id.textViewSubFoodName)
        val subFoodDescription: TextView = view.findViewById(R.id.textViewSubFoodDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodSubViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_item_sub_food, parent, false)
        return FoodSubViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodSubViewHolder, position: Int) {
        val subItem = subItemList[position]
        holder.subFoodName.text = subItem.subName
        holder.subFoodImage.setImageResource(subItem.subImageResId)
        holder.subFoodDescription.text = subItem.subDescription
    }

    override fun getItemCount(): Int = subItemList.size
}
