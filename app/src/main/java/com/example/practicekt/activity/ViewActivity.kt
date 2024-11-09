package com.example.practicekt.activity

import android.content.ContentValues.TAG
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.palette.graphics.Palette
import com.example.practicekt.R
import com.example.practicekt.databinding.ActivityViewBinding

class ViewActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
<<<<<<< HEAD

//        Toast.makeText(this, "ViewActivity launched", Toast.LENGTH_SHORT).show()
        extractColorsFromImage()

=======
         
>>>>>>> master
        val language = resources.getStringArray(R.array.Languages)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, language)
        binding.spinner.adapter = adapter


        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Log.d(TAG, "item selected is : ${language[position]}")
                if (language[position] != "Languages") {
                    Toast.makeText(
                        this@ViewActivity,
                        getString(R.string.select_language) + ":" +
                                language[position], Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.d(TAG, "onNothingSelected: No item selected")
            }
        }

    }
    private fun extractColorsFromImage() {
        val bitmap = (binding.plateImg.drawable as BitmapDrawable).bitmap

        Palette.from(bitmap).generate { palette ->
            palette?.let {
                val vibrantColor = it.getVibrantColor(
                    ContextCompat.getColor(this, android.R.color.darker_gray)
                )
                binding.textViewVibrant.setBackgroundColor(vibrantColor)

                val mutedColor = it.getMutedColor(
                    ContextCompat.getColor(this, android.R.color.darker_gray)
                )
                binding.textViewMuted.setBackgroundColor(mutedColor)
            }
        }
    }
}