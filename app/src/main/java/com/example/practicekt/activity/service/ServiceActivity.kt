package com.example.practicekt.activity.service

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practicekt.databinding.ActivityServiceBinding

class ServiceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityServiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.playButton.setOnClickListener {
            val intent = Intent(this, AudioService::class.java)
            startForegroundService(intent)
        }
        binding.stopButton.setOnClickListener {
            val intent = Intent(this, AudioService::class.java)
            stopService(intent)
        }
    }
}
