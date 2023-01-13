package com.example.musicplayer.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.musicplayer.adapter.BokePagerAdapter
import com.example.musicplayer.databinding.FragmentBokeBinding
import com.example.musicplayer.fragment.tabfragment.ListenFragment
import com.example.musicplayer.fragment.tabfragment.StoryFragment
import com.google.android.material.tabs.TabLayoutMediator


class BokeFragment : Fragment() {
    private lateinit var binding: FragmentBokeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBokeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val bokePagerAdapter = BokePagerAdapter(requireActivity().supportFragmentManager, lifecycle)
        bokePagerAdapter.setPageList(listOf(ListenFragment(), StoryFragment()))

        binding.viewPager.adapter = bokePagerAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager){ tab, position ->
            when(position) {
                0 -> tab.text = "听听"
                1 -> tab.text = "故事"
            }
        }.attach()
    }

}