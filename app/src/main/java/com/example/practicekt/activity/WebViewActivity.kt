package com.example.practicekt.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.practicekt.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    lateinit var binding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.wvMain.webViewClient = WebViewClient()
        binding.wvMain.loadUrl("https://www.geeksforgeeks.org/")

        binding.wvMain.settings.setSupportZoom(true)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBackPressed() {
        if (binding.wvMain.canGoBack()) {
            binding.wvMain.goBack()
        } else
            super.onBackPressed()
    }
}