package com.example.musicplayer.fragment.tabfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.musicplayer.R
import com.example.musicplayer.databinding.FragmentFollowMusicianBinding

class FollowMusicianFragment : Fragment() {
    private lateinit var binding:FragmentFollowMusicianBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFollowMusicianBinding.inflate(inflater,container,false)
        return binding.root
    }
}