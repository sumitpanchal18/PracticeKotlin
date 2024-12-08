package com.example.practicekt.activity.rv2.nestedRv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicekt.R

class NestedFoodAdapter(private val foodList: List<FoodDataClass>) :
    RecyclerView.Adapter<NestedFoodAdapter.FoodViewHolder>() {

    inner class FoodViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val foodImage: ImageView = view.findViewById(R.id.imageViewFood)
        val foodName: TextView = view.findViewById(R.id.textViewFoodName)
        val foodDescription: TextView = view.findViewById(R.id.textViewFoodDescription)
        val recyclerViewSub: RecyclerView = view.findViewById(R.id.recyclerViewSubFood)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.nested_item_food, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val foodItem = foodList[position]
        holder.foodName.text = foodItem.name
        holder.foodImage.setImageResource(foodItem.imageResId)
        holder.foodDescription.text = foodItem.description

        if (foodItem.subItems.isNotEmpty()) {
            holder.recyclerViewSub.layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
            holder.recyclerViewSub.adapter = FoodSubAdapter(foodItem.subItems)
        }
    }

    override fun getItemCount(): Int = foodList.size
}
