package com.example.musicplayer.fragment.community

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.viewpager2.widget.ViewPager2
import com.example.musicplayer.R
import com.example.musicplayer.adapter.CommunityPagerAdapter
import com.example.musicplayer.databinding.FragmentCommunityBinding
import com.example.wangyiyun.fragment.KtvFragment
import com.example.wangyiyun.fragment.SquareFragment

class CommunityFragment : Fragment() {

    private lateinit var binding: FragmentCommunityBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentCommunityBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //将viewPager与tabLayout关联
        val communityPagerAdapter = CommunityPagerAdapter(requireActivity().supportFragmentManager,lifecycle)
        //三个界面
        communityPagerAdapter.setPageList(listOf(SquareFragment(), KtvFragment()))

        binding.viewPager.adapter = communityPagerAdapter

        //监听viewPager2的滑动
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            @RequiresApi(Build.VERSION_CODES.M)
            override fun onPageScrollStateChanged(state: Int) {
                if (state == ViewPager2.SCROLL_STATE_IDLE) {
                    Log.d("chy", "----> 3")
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