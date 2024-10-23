package com.example.practicekt.activity.rv

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practicekt.R

class RvActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this)
        val data = ArrayList<dataClass>()

//        for (i in 1..20) {
        data.add(dataClass(R.drawable.img, "Item 1"))
        data.add(dataClass(R.drawable.img_1, "Item 2"))
//        }
        val adapter = CustomAdapter(data)
        recyclerview.adapter = adapter

    }
}
