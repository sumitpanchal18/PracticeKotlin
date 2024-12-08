package com.example.practicekt.activity.rv2.nestedRv

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practicekt.R

class NestedRvActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested_rv)

        val recyclerViewFood = findViewById<RecyclerView>(R.id.recyclerViewFoodNested)

        val foodList = mutableListOf<FoodDataClass>()

        for (i in 1..10) {
            val subItems = mutableListOf<FoodSubItem>()
            for (j in 1..50) {
                subItems.add(FoodSubItem("Sub Food $j", R.drawable.img_3, "Description of Sub Food $j"))
            }
            foodList.add(FoodDataClass("Food Item $i", R.drawable.img_2, "Description of Food Item $i", subItems))
        }

        recyclerViewFood.layoutManager = LinearLayoutManager(this)
        recyclerViewFood.adapter = NestedFoodAdapter(foodList)
    }
}