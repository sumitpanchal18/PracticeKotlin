package com.example.practicekt.activity.layout

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.practicekt.R
import com.example.practicekt.databinding.ActivityLinearLayoutBinding

class LinearLayoutActivity : AppCompatActivity() {

    lateinit var binding : ActivityLinearLayoutBinding
    var mobileNumber = StringBuilder()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLinearLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttons = listOf(
            findViewById<TextView>(R.id.txt1),
            findViewById(R.id.txt2),
            findViewById(R.id.txt3),
            findViewById(R.id.txt4),
            findViewById(R.id.txt5),
            findViewById(R.id.txt6),
            findViewById(R.id.txt7),
            findViewById(R.id.txt8),
            findViewById(R.id.txt9),
            findViewById(R.id.txt0),
        )

        buttons.forEach{ btn ->
            btn.setOnClickListener {
                mobileNumber.append(btn.text)
                binding.txtMobileNumber.text = mobileNumber.toString()
            }
        }

        binding.imgDel.setOnClickListener{
            if (mobileNumber.isNotEmpty())
            {
                mobileNumber.deleteCharAt(mobileNumber.length-1)
                binding.txtMobileNumber.text = mobileNumber.toString()

            }
        }

    }
}