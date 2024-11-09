package com.example.practicekt.activity

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.practicekt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "onCreate Method called")

        val gfgf = SecondActivity().apply {
            Log.d(TAG, "onCreate: $sumit")
            println(sumit)
            "User Summary: $sumit, Age: $sumit, Email: $sumit"
        }
        val s = with(gfgf) {
            "User Summary: $sumit, Age: $sumit, Email: $sumit"
        }

        println(s)

        SecondActivity().also {
            it.sumit = "Rahul"
            Log.e(TAG, "onCreate: ${it.sumit}")
        }


// Navigating from one activity to another activity
        binding.btnName.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("name", "Sumit")
            intent.putExtra("age", 21)
            intent.putExtra("float", 187.87f)
            startActivity(intent)
//            binding.txtName.text = "E2Logy"
        }

        binding.txtName.setOnClickListener {
            finishAffinity()
        }

// Pass data from one activity to another activity
        binding.btnDataPass.setOnClickListener {

        }


    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart Method called")

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: Method called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume Method called")


    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy Method called")


    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart Method called")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop Method called")


    }


}