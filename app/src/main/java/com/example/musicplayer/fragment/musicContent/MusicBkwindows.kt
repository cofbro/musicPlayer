package com.example.musicplayer.fragment.musicContent

import android.os.Bundle
import android.transition.Visibility
import android.transition.VisibilityPropagation
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.musicplayer.Onclick
import com.example.musicplayer.databinding.ActivityFloatItemBinding
import com.example.musicplayer.databinding.FragmentPlayerContentBinding
import com.example.musicplayer.viewModel.SharedViewModel

class MusicBkwindows:Fragment() {
    lateinit var binding: ActivityFloatItemBinding
    private val model: SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityFloatItemBinding.inflate(layoutInflater, container, false)
        binding.sharemodel = model
        binding.click = Onclick()
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
           binding.blackandWhiteContainer.setModelAndLifeCycleOwner(model,viewLifecycleOwner)
    }
}