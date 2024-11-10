package com.example.practicekt.fragments

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.practicekt.R
import com.example.practicekt.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "Fragment onAttach: ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Fragment onCreate: ")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "Fragment onCreateView: ")
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "Fragment onViewCreated: ")

        binding.btnRedirectSecFrag.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        binding.txtFirstFragment.setOnClickListener {
            shareText("This is the text you want to share!")
        }
    }

    private fun shareText(textToShare: String) {
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, textToShare)
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Fragment onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Fragment onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Fragment onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Fragment onStop: ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "Fragment onDestroyView: ")
        // Optional: any additional view-related cleanup can go here
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Fragment onDestroy: ")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "Fragment onDetach: ")
    }
}
