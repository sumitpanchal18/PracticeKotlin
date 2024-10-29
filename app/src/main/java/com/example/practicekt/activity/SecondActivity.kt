package com.example.practicekt.activity

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.practicekt.R
import com.example.practicekt.databinding.ActivitySecondBinding
import com.example.practicekt.fragments.FirstFragment
import com.example.practicekt.fragments.SecondFragment

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    var sumit: String? = "Sumit Panchal"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


        sumit?.let {
            println(it)
        }

//        println(sumit)  // This will print: null

        val name = intent.getStringExtra("name")
        val age = intent.getIntExtra("age", 0)
        val float = intent.getFloatExtra("float", 0.0F)
        Log.d(TAG, "age : $age  Float : $float")
        binding.txtSecName.text = name

        // Navigating to previous activity
        binding.btnFinishAc.setOnClickListener {
//            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

        binding.txtSecName.setOnClickListener {
            redirectToFragment()
        }

        binding.btnReplaceFragment.setOnClickListener {
            replaceAnotherFragment()
        }

        binding.redirectToDial.setOnClickListener {
            startActivity(Intent(this, ViewActivity::class.java))
            finish()
        }

    }

    private fun replaceAnotherFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcvFrag, SecondFragment())
            .addToBackStack(null)
            .commit()
    }

    fun redirectToFragment() {
        val fragment = FirstFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcvFrag, fragment)
            .commit()
        binding.btnFinishAc.visibility = View.GONE
        binding.txtSecName.visibility = View.GONE
    }
}



