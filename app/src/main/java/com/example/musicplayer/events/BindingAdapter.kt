package com.example.musicplayer.events

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import com.example.musicplayer.untils.hideBottomNavigationView
import com.example.musicplayer.untils.showBottomNavigationView
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView

@BindingAdapter("shouldShow")
fun View.shouldShow(show:Boolean) {
    if (show){ //现在需要显示
            showBottomNavigationView(this)
    }else{
           hideBottomNavigationView(this)

    }
}