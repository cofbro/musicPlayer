package com.example.musicplayer.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.musicplayer.ClickEvent
import com.example.musicplayer.R
import com.example.musicplayer.adapter.FollowPagerAdapter
import com.example.musicplayer.databinding.FragmentFollowBinding
import com.example.musicplayer.fragment.tabfragment.FollowAllFragment
import com.example.musicplayer.fragment.tabfragment.FollowFriendsFragment
import com.example.musicplayer.fragment.tabfragment.FollowMusicianFragment
import com.google.android.material.tabs.TabLayoutMediator

class FollowFragment : Fragment {

    private lateinit var binding: FragmentFollowBinding

    constructor() : super()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFollowBinding.inflate(layoutInflater, container, false)
       binding.clickEvent = ClickEvent()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val followPagerAdapter = FollowPagerAdapter(requireActivity().supportFragmentManager,lifecycle)
        followPagerAdapter.setPageList(
            listOf(
                FollowMusicianFragment(),
                FollowAllFragment(),
                FollowFriendsFragment()
            )
        )
        binding.followViewpager.adapter = followPagerAdapter
        TabLayoutMediator(binding.followTableTap,binding.followViewpager){tab,position->
            when(position){
                0->tab.text = "音乐人"
                1->tab.text = "全部"
                2->tab.text = "朋友"
            }
        }.attach()
    }

}