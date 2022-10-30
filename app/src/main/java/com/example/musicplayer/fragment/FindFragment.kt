package com.example.musicplayer.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.musicplayer.databinding.FragmentFindBinding
import com.example.musicplayer.model.SharedViewModel


class FindFragment : Fragment() {
    private val model:SharedViewModel by activityViewModels()
    private lateinit var binding: FragmentFindBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFindBinding.inflate(layoutInflater, container, false)
        binding.model=model
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        model.shouldShowNavigationView.postValue(true)
    }

}