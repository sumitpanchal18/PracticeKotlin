package com.example.practicekt.activity.layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practicekt.databinding.ActivityFrameLayoutBinding

class FrameLayoutActivity : AppCompatActivity() {
    lateinit var binding: ActivityFrameLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFrameLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}