
package com.example.musicplayer.fragment.community

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.musicplayer.R
import com.example.musicplayer.adapter.CommunityPagerAdapter
import com.example.musicplayer.databinding.FragmentCommunityBinding
import com.google.android.material.tabs.TabLayoutMediator

class CommunityFragment : Fragment() {
    private lateinit var binding: FragmentCommunityBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCommunityBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //将viewPager和tabLayout关联
        val communityPagerAdapter = CommunityPagerAdapter(requireActivity().supportFragmentManager,lifecycle)
        communityPagerAdapter.setPageList(listOf(SquareFragment(),VideoFragment(),KtvFragment()))

        binding.viewPager.adapter = communityPagerAdapter

        TabLayoutMediator(binding.tabLayout,binding.viewPager){tab,position ->
            when(position){
                0 -> tab.text = "村民广场"
                1 -> tab.text = "视频"
                2 -> tab.text = "歌房"
            }
        }.attach()

        //监听viewpager2滑动
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageScrollStateChanged(state: Int) {
                if (state == ViewPager2.SCROLL_STATE_IDLE){
                    if (binding.viewPager.currentItem != 3){
                        binding.add.imageTintList = resources.getColorStateList(R.color.themeRed,null)
                        binding.more.imageTintList = resources.getColorStateList(R.color.black,null)
                        binding.tabLayout.tabTextColors = resources.getColorStateList(R.color.black,null)
                    }else{
                        binding.add.imageTintList = resources.getColorStateList(R.color.gray,null)
                        binding.more.imageTintList = resources.getColorStateList(R.color.white,null)
                        binding.tabLayout.tabTextColors = resources.getColorStateList(R.color.white,null)

                    }
                }
            }
        })
    }
}