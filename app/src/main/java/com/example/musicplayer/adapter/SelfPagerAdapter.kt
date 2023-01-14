package com.example.musicplayer.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView

class SelfPagerAdapter (
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
):FollowPagerAdapter(fragmentManager,lifecycle) {
    private var selfPageList = emptyList<RecyclerView>()
    override fun getItemCount(): Int {
        return selfPageList.size
    }


}