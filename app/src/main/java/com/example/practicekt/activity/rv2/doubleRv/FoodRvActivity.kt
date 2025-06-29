package com.example.practicekt.activity.rv2.doubleRv

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicekt.databinding.ActivityFoodRvBinding


class FoodRvActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFoodRvBinding

    var viewModel = ProductViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodRvBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[ProductViewModel::class.java]
        viewModel.products.observe(this) { productList ->
            binding.recyclerview.adapter = ProductAdapter(productList)
        }
        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(this@FoodRvActivity)
        }
    }
}
