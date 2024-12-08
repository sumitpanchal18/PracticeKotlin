package com.example.practicekt.activity.rv2.doubleRv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practicekt.R

/*
class FoodAdapter(private val foodList: List<FoodItem>, private val type: Int) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    inner class FoodViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val foodImage: ImageView = view.findViewById(R.id.imageViewFood)
        val foodName: TextView = view.findViewById(R.id.textViewFoodName)
        val foodDescription: TextView = view.findViewById(R.id.textViewFoodDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_food, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val filteredFoodList = foodList.filter { it.type == type }
        val foodItem = filteredFoodList[position]

        holder.foodName.text = foodItem.name
        holder.foodImage.setImageResource(foodItem.imageResId)
        holder.foodDescription.text = foodItem.description
    }

    override fun getItemCount(): Int {
        return foodList.count { it.type == type }
    }
}
*/


class FoodAdapter(private val foodList: List<FoodItem>) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    inner class FoodViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val foodImage: ImageView = view.findViewById(R.id.imageViewFood)
        val foodName: TextView = view.findViewById(R.id.textViewFoodName)
        val foodDescription: TextView = view.findViewById(R.id.textViewFoodDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_food, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val foodItem = foodList[position]
        holder.foodName.text = foodItem.name
        holder.foodImage.setImageResource(foodItem.imageResId)
        holder.foodDescription.text = foodItem.description
    }

    override fun getItemCount(): Int = foodList.size
}
