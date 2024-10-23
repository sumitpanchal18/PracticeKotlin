package com.example.practicekt.fragments

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.ContentValues.TAG
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.practicekt.R

class CustomDialogFragment : DialogFragment() {


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_custom_dialog, container, false)
        val editTextName = view.findViewById<EditText>(R.id.editTextName)
        val buttonSubmit = view.findViewById<Button>(R.id.buttonSubmit)
        val buttonCancel = view.findViewById<Button>(R.id.buttonCancel)

        buttonSubmit.setOnClickListener {
            val name = editTextName.text.toString()
            Log.d(TAG, "Name : $name")
            dismiss()
        }

        buttonCancel.setOnClickListener {
            dismiss()
        }

        return view
    }
/*
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return Dialog(requireContext(), theme).apply {
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }*/
}
