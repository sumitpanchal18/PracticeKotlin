package com.example.practicekt.activity.sp

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.practicekt.R
import com.example.practicekt.databinding.ActivityDatePickerBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class DatePickerActivity : AppCompatActivity() {
    lateinit var binding: ActivityDatePickerBinding
    private val calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatePickerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDatePicker.setOnClickListener {
            showDatePicker()
        }

        loadImage()


    }

    private fun loadImage() {
        Glide.with(this)
            .load("https://24ai.tech/en/wp-content/uploads/sites/3/2023/10/01_product_1_sdelat-izobrazhenie-1-1-6-scaled.jpg")
            .placeholder(R.drawable.img_1)
            .error(R.drawable.img)
            .into(binding.imgGlide)


    }

    @SuppressLint("SetTextI18n")
    private fun showDatePicker() {
        val datePickerDialog = DatePickerDialog(
            this,
//            R.style.CustomDatePickerDialog,
            { _, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, monthOfYear, dayOfMonth)
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                val formattedDate = dateFormat.format(selectedDate.time)
                binding.tvSelectedDate.text = "Selected Date: $formattedDate"
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        datePickerDialog.datePicker.maxDate = Calendar.getInstance().timeInMillis

        datePickerDialog.show()
    }
}