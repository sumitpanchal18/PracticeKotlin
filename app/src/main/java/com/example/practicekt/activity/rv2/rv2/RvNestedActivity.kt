package com.example.practicekt.activity.rv2.rv2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practicekt.R

class RvNestedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv_nested)

        val recyclerViewItem = findViewById<RecyclerView>(R.id.recyclerViewMainItems)

        // Sample data for main and sub-items
        val itemList = mutableListOf<ItemData>()

        // Main items with sub-items
        for (i in 1..2) {
            itemList.add(
                ItemData(
                    "Item $i",
                    "Description of Item $i",
                    R.drawable.img_2,
                    // Each main item has 10 sub-items
                    List(5) { index ->
                        ItemData(
                            "Sub Item ${i * 10 + index + 1}",
                            "Description of Sub Item ${i * 10 + index + 1}",
                            R.drawable.img_3
                        )
                    }
                )
            )
        }

        recyclerViewItem.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewItem.adapter = CustomAdapter(itemList)
    }
}
