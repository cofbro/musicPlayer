package com.example.musicplayer.fragment.bokefragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.musicplayer.R
import com.example.musicplayer.adapter.BokePagerAdapter
import com.example.musicplayer.databinding.FragmentBokeBinding
import com.example.musicplayer.fragment.tabfragment.ListenFragment
import com.example.musicplayer.fragment.tabfragment.StoryFragment
import com.example.musicplayer.utils.setChipWithEvent
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
        //将viewPager与tabLayout关联
        val bokePagerAdapter = BokePagerAdapter(requireActivity().supportFragmentManager, lifecycle)
        bokePagerAdapter.setPageList(listOf(ListenFragment(), StoryFragment()))

        binding.viewPager.adapter = bokePagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "听听"
                1 -> tab.text = "故事"
            }
        }.attach()

        //监听viewpager2滑动
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                if (state == ViewPager2.SCROLL_STATE_IDLE) {
                    if (binding.viewPager.currentItem == 0) {
                        binding.add.imageTintList = resources.getColorStateList(R.color.themeRed, null)
                        binding.more.imageTintList = resources.getColorStateList(R.color.black, null)
                        binding.tabLayout.tabTextColors = resources.getColorStateList(R.color.black, null)
                    } else {
                        binding.add.imageTintList = resources.getColorStateList(R.color.gray, null)
                        binding.more.imageTintList = resources.getColorStateList(R.color.white, null)
                        binding.tabLayout.tabTextColors = resources.getColorStateList(R.color.white, null)
                    }
                }
            }
        })
    }

}