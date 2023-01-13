package com.example.musicplayer.fragment.tabfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicplayer.R
import com.example.musicplayer.adapter.FollowAdapter
import com.example.musicplayer.databinding.FragmentFollowMusicianBinding

class FollowMusicianFragment : Fragment() {
    private lateinit var binding:FragmentFollowMusicianBinding
    private lateinit var adapter:FollowAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFollowMusicianBinding.inflate(inflater,container,false)

        adapter = FollowAdapter()
        binding.recyclerview.layoutManager = LinearLayoutManager(requireActivity())
        binding.recyclerview.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


    }
}