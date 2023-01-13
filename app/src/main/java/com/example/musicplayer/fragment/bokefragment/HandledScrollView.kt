package com.example.musicplayer.fragment.bokefragment

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.core.widget.NestedScrollView

class HandledScrollView : NestedScrollView {
    private var scrollTopListener: (isTop: Boolean) -> Unit = {}

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    fun setScrollTopListener(scrollTopListener: (isTop: Boolean) -> Unit) {
        this.scrollTopListener = scrollTopListener
    }


    override fun onNestedPreScroll(target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {
        if (scrollY > 200f) {
            scrollTopListener(false)
        } else {
            scrollTopListener(true)
        }
        if (dy > 0 && scrollY < 500f) {
            scrollBy(0, dy)
            consumed[1] = dy
        }
    }

}