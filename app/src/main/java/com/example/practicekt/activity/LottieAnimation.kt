package com.example.practicekt.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieDrawable
import com.example.practicekt.databinding.ActivityLottieAnimationBinding
import timber.log.Timber

class LottieAnimation : AppCompatActivity() {

    private lateinit var binding: ActivityLottieAnimationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLottieAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lottieAnimationView.playAnimation()
        binding.lottieAnimationView.repeatCount = LottieDrawable.INFINITE
        binding.lottieAnimationView.speed = 1f

        binding.testingButton.setOnClickListener {
            Timber.d("Timber is initialized and working")
        }
    }
}
