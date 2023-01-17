package com.example.musicplayer.utils

import android.graphics.Rect
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.adapter.SongListAdapter

class SpacingItemDecoration(
    private val left: Int,
    private val top: Int,
    private val right: Int,
    private val bottom: Int,
    private val boolean: Boolean
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        if (parent.getChildAdapterPosition(view) == 0 && boolean) {
            outRect.left = left
            outRect.right = right
            outRect.bottom = bottom
            outRect.top = 50
        } else {
            outRect.left = left
            outRect.right = right
            outRect.bottom = bottom
            outRect.top = top
        }
    }


}