package com.example.practicekt.activity.databinding

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.practicekt.R
import com.example.practicekt.databinding.ActivityDataBactivityBinding

class DataActivity : AppCompatActivity() {

    private val viewModel: DataBViewModel by viewModels()
    private lateinit var binding: ActivityDataBactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_bactivity)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }
}
