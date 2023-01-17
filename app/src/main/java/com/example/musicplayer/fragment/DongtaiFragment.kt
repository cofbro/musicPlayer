package com.example.musicplayer.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.musicplayer.ClickEvent
import com.example.musicplayer.R
import com.example.musicplayer.adapter.DongtaiPagerAdapter
import com.example.musicplayer.databinding.FragmentDongtaiBinding
import com.example.musicplayer.fragment.tabfragment.DongTaiForwardFragment
import com.example.musicplayer.fragment.tabfragment.DongtaiGoodFragment
import com.example.musicplayer.fragment.tabfragment.DontaiCommentsFragment
import com.google.android.material.tabs.TabLayoutMediator

class DongtaiFragment : Fragment() {

private lateinit var binding:FragmentDongtaiBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDongtaiBinding.inflate(layoutInflater,container,false)
        binding.clickEvent = ClickEvent()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        val dongtaiPagerAdapter = DongtaiPagerAdapter(requireActivity().supportFragmentManager,lifecycle)
//        dongtaiPagerAdapter.setPageList(
//            listOf(
//                DontaiCommentsFragment(),
//                DongTaiForwardFragment(),
//                DongtaiGoodFragment()
//            )
//        )
//        binding.dongtaiViewpager.adapter = dongtaiPagerAdapter
//        TabLayoutMediator(binding.dongtaiTableTap,binding.dongtaiViewpager){tab,position->
//            when(position){
//                0->tab.text = "评论"
//                1->tab.text = "全部"
//                2->tab.text = "朋友"
//            }
//        }.attach()
    }

}