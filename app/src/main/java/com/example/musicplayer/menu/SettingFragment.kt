package com.example.musicplayer.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.musicplayer.R
import com.example.musicplayer.databinding.FragmentSearchBinding
import com.example.musicplayer.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {
   lateinit var binding:FragmentSettingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSettingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.backtomenu.setOnClickListener {
            findNavController().navigateUp()
        }
    }


}