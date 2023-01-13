package com.example.musicplayer.fragment.tabfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.musicplayer.R
import com.example.musicplayer.databinding.FragmentListenBinding
import com.example.musicplayer.utils.setChipWithEvent
import com.example.musicplayer.utils.setFirstRecyclerView


class ListenFragment : Fragment() {
    private lateinit var binding: FragmentListenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListenBinding.inflate(layoutInflater, container, false)
        setChipWithEvent(requireActivity(), binding.chipGroup, binding)

        setFirstRecyclerView(requireActivity(), binding)

        return binding.root
    }



}