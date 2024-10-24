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
import androidx.navigation.createGraph
import androidx.navigation.fragment.findNavController
import com.example.practicekt.R
import com.example.practicekt.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "Fragment onCreateView: ")
//        val view = inflater.inflate(R.layout.fragment_second, container, false)
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        val name = arguments?.getString("name")
        Log.d(TAG, "Name : $name")

        return binding.root


//        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnReplaceFirstFragment.setOnClickListener {
//            findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
            /* requireActivity().supportFragmentManager
                 .beginTransaction()
                 .replace(R.id.fcvFrag, FirstFragment())
                 .addToBackStack(null)
                 .commit()
 */
            requireActivity().supportFragmentManager.popBackStack()
        }
    }
}
