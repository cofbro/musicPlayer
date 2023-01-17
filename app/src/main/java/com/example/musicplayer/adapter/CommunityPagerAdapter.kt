package com.example.musicplayer.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class CommunityPagerAdapter (fragmentManager: FragmentManager,lifecycle: Lifecycle):FragmentStateAdapter(fragmentManager, lifecycle){
    private var pageList = emptyList<Fragment>()
    override fun getItemCount(): Int {
        return pageList.size
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> pageList[0]
            1 -> pageList[1]
            2 -> pageList[2]
            else -> {pageList[0]}
        }
    }

    fun setPageList(new:List<Fragment>){
        pageList = new
    }
}