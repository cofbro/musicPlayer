package com.example.musicplayer.utils

import android.content.Context
import android.graphics.Typeface
import androidx.core.view.children
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.musicplayer.R
import com.example.musicplayer.adapter.ListenAdapter
import com.example.musicplayer.databinding.FragmentKtvBinding
import com.example.musicplayer.databinding.FragmentListenBinding
import com.example.musicplayer.databinding.ItemLayout1Binding
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

fun setChipWithEvent(context: Context, chipGroup: ChipGroup, binding: FragmentListenBinding) {
    for (i in 0..6) {
        (chipGroup.getChildAt(i) as Chip).paint.typeface = Typeface.DEFAULT_BOLD
    }
    chipGroup.setOnCheckedChangeListener { _, checkedId ->

    }

}

fun setChipWithEvent(context: Context, chipGroup: ChipGroup, binding: FragmentKtvBinding) {
    for (i in 0..6) {
        (chipGroup.getChildAt(i) as Chip).paint.typeface = Typeface.DEFAULT_BOLD
    }
    chipGroup.setOnCheckedChangeListener { _, checkedId ->

    }

}

/**
 *
 * fragment: ListenFragment
 */

fun setFirstRecyclerView(context: Context, binding: FragmentListenBinding) {
    binding.recyclerView1.adapter = ListenAdapter()
    binding.recyclerView1.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
    binding.recyclerView1.addItemDecoration(SpacingItemDecoration(15,0,15,0,false))

    binding.recyclerView2.adapter = ListenAdapter()
    binding.recyclerView2.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
    binding.recyclerView2.addItemDecoration(SpacingItemDecoration(15,0,15,0,false))

    binding.recyclerView3.adapter = ListenAdapter()
    binding.recyclerView3.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
    binding.recyclerView3.addItemDecoration(SpacingItemDecoration(15,0,15,0,false))
}