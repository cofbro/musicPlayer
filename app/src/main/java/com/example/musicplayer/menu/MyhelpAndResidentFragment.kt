package com.example.musicplayer.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.musicplayer.R
import com.example.musicplayer.databinding.FragmentMyhelpAndResidentBinding

class MyhelpAndResidentFragment : Fragment() {
    lateinit var binding:FragmentMyhelpAndResidentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentMyhelpAndResidentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.backtomenus.setOnClickListener {
            findNavController().navigateUp()
        }
    }


}