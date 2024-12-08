package com.example.practicekt.activity.rv2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practicekt.R
/*

class FoodRvActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_rv)

        val recyclerViewFood1 = findViewById<RecyclerView>(R.id.recyclerViewFood1)
        val recyclerViewFood2 = findViewById<RecyclerView>(R.id.recyclerViewFood2)

        val foodList = mutableListOf<FoodItem>()

        for (i in 1..10) {
            foodList.add(
                FoodItem(
                    "Food Item $i",
                    R.drawable.img_2,
                    "Description of Food Item $i",
                    1
                )
            )
        }

        for (i in 1..10) {
            foodList.add(
                FoodItem(
                    "Food Item $i",
                    R.drawable.img_3,
                    "Description of Food Item $i",
                    2
                )
            )
        }

        recyclerViewFood1.layoutManager = LinearLayoutManager(this)
        recyclerViewFood1.adapter = FoodAdapter(foodList, 1)

        recyclerViewFood2.layoutManager = LinearLayoutManager(this)
        recyclerViewFood2.adapter = FoodAdapter(foodList, 2)
    }
}
*/


class FoodRvActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_rv)

        val recyclerViewFood = findViewById<RecyclerView>(R.id.recyclerViewFood1)

        val foodList = mutableListOf<FoodItem>()

        for (i in 1..10) {
            foodList.add(FoodItem("Food Item $i", R.drawable.img_2, "Description of Food Item $i"))
            foodList.add(FoodItem("Food Item $i", R.drawable.img_3, "Description of Food Item $i"))
        }

        recyclerViewFood.layoutManager = LinearLayoutManager(this)
        recyclerViewFood.adapter = FoodAdapter(foodList)
    }
}
