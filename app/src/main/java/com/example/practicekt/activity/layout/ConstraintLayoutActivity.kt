package com.example.practicekt.activity.layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practicekt.databinding.ActivityConstraintLayoutBinding

class ConstraintLayoutActivity : AppCompatActivity() {
    lateinit var binding: ActivityConstraintLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConstraintLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}