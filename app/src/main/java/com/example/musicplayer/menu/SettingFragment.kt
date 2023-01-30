package com.example.musicplayer.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.musicplayer.Onclick
import com.example.musicplayer.R
import com.example.musicplayer.databinding.FragmentSearchBinding
import com.example.musicplayer.databinding.FragmentSettingBinding

import com.example.musicplayer.viewModel.SharedViewModel

class SettingFragment : Fragment() {
   lateinit var binding:FragmentSettingBinding
   val sharemodel:SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSettingBinding.inflate(layoutInflater, container, false)
        binding.sharemodel=sharemodel
        binding.click= Onclick()
        binding.lifecycleOwner=viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.backtomenu.setOnClickListener {
            findNavController().navigateUp()
        }


    }


}