package com.example.musicplayer.fragment.tabfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.adapter.StoryAdapter
import com.example.musicplayer.databinding.FragmentStoryBinding
import com.example.musicplayer.utils.SpacingItemDecoration


class StoryFragment : Fragment() {
    private lateinit var binding: FragmentStoryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStoryBinding.inflate(layoutInflater, container, false)

        binding.recyclerView.adapter = StoryAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL, false)
        binding.recyclerView.addItemDecoration(SpacingItemDecoration(15, 0, 10, 15,false))

        return binding.root
    }
}