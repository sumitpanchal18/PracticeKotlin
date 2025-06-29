package com.example.practicekt.activity.rv2.nestedRVSingleAdapter

import MultiTypeAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practicekt.R

class RvNestedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv_nested)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewMainItems)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val items = listOf<ListItem>(
            ListItem.TypeOne("Item Title 1"),
            ListItem.TypeTwo(R.drawable.img_2),
            ListItem.TypeOne("Item Title 2"),
            ListItem.TypeTwo(R.drawable.img_3)
        )

        val adapter = MultiTypeAdapter(items)
        recyclerView.adapter = adapter
    }
}
