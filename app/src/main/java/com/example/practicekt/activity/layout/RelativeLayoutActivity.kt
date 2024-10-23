package com.example.practicekt.activity.layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practicekt.databinding.ActivityRelativeLayoutBinding

class RelativeLayoutActivity : AppCompatActivity() {
    lateinit var binding: ActivityRelativeLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRelativeLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
