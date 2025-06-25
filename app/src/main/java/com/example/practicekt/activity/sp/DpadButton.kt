package com.example.practicekt.activity.sp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.practicekt.R
import com.example.practicekt.databinding.ActivityDpadButtonBinding

class DpadButton : AppCompatActivity() {
    private lateinit var binding: ActivityDpadButtonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDpadButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set focus change listeners to provide visual feedback
        setFocusChangeListener(binding.button1)
        setFocusChangeListener(binding.button2)
        setFocusChangeListener(binding.button3)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setFocusChangeListener(button: Button) {
        button.setOnFocusChangeListener { view, hasFocus ->
            view.background =
                if (hasFocus) getDrawable(R.drawable.focused_button) else getDrawable(R.drawable.default_button)
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        return when (keyCode) {
            KeyEvent.KEYCODE_DPAD_UP -> {
                when {
                    binding.button2.isFocused -> binding.button1.requestFocus()
                    binding.button3.isFocused -> binding.button2.requestFocus()
                }
                true
            }

            KeyEvent.KEYCODE_DPAD_DOWN -> {
                when {
                    binding.button1.isFocused -> binding.button2.requestFocus()
                    binding.button2.isFocused -> binding.button3.requestFocus()
                }
                true
            }

            KeyEvent.KEYCODE_DPAD_LEFT, KeyEvent.KEYCODE_DPAD_RIGHT -> {
                // Handle left and right navigation if needed
                true
            }

            KeyEvent.KEYCODE_ENTER, KeyEvent.KEYCODE_DPAD_CENTER -> {
                // Handle OK button click
                when {
                    binding.button1.isFocused -> binding.button1.performClick()
                    binding.button2.isFocused -> binding.button2.performClick()
                    binding.button3.isFocused -> binding.button3.performClick()
                }
                true
            }

            else -> super.onKeyDown(keyCode, event)
        }
    }
}
