package com.example.practicekt.fragments

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.practicekt.R

/**
 * Fragment Lifecycle
 */


class FirstFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "Fragment onCreateView: ")

        val view = inflater.inflate(R.layout.fragment_first,container,false)
        val button = view.findViewById<Button>(R.id.btnRedirectSecFrag)
        button.setOnClickListener {
            redirectOnSecondActivity()
        }
        /*button.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
*/

        return view
//        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    private fun redirectOnSecondActivity() {

        val bundle = Bundle()
        bundle.putString("name","Rahul")

        val secondFragment = SecondFragment()
        secondFragment.arguments = bundle

        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fcvFrag,secondFragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "Fragment onAttach: ")

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Fragment onCreate: ")
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "Fragment onViewCreated: ")
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


/**
 * onAttach()
 * onCreate()
 * onCreateView()
 * onViewCreated()
 * onStart()
 * onResume()
 * onPause()
 * onStop()
 * onDestroyView()
 * onDestroy()
 * onDetach()
 */