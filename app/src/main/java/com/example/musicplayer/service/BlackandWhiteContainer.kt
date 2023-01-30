package com.example.musicplayer.service

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.Log
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import com.example.musicplayer.ISWINDOWPLAY
import com.example.musicplayer.R
import com.example.musicplayer.Utils.Utils
import com.example.musicplayer.Utils.Utils.dp2x
import com.example.musicplayer.lastplayer_gloabal
import com.example.musicplayer.viewModel.SharedViewModel
import com.example.musicplayer.viewModel.ViewModleMain
import kotlin.random.Random

class BlackandWhiteContainer:ViewGroup {
    var image_length = 0
    val spaceMargin = context.dp2x(3)
    var backInt = 0
    var thisChange=false

    private lateinit var model: SharedViewModel
    private lateinit var owner: LifecycleOwner

    constructor(context: Context) : super(context) {
        UIinit()

    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        UIinit()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun UIinit() {
        for (row in 0..1) {
            for (column in 0..3) {
                if (row == 0) {
                    backInt = if (column == 1) {
                        R.drawable.left
                    } else {
                        R.drawable.xback
                    }
                }
                if (row == 1 && column == 0) {
                    backInt = R.drawable.left
                }
                if (row == 1 && column == 1) {
                    if (ViewModleMain.isWindowPlay.value == true) {
                        backInt = R.drawable.ic_play
                    } else {
                        backInt = R.drawable.ic_stop
                    }
                }
                if (row == 1 && column == 2) {
                    backInt = R.drawable.right
                }
                if (row == 1 && column == 3) {
                    backInt = R.drawable.xback
                }
                var imageview = ImageView(context).apply {
                    background = context.getDrawable(backInt)
                    tag = (row * 4 + column).toString()
                    scaleType = ImageView.ScaleType.FIT_XY
                }
                if (row == 1 && column == 1) {
                    imageview.setOnClickListener {
//                        Log.v("opoooo",model.isShowWindow.toString())
                        if (ViewModleMain.isWindowPlay.value==true) {
                            ViewModleMain.isWindowPlay.postValue(false)
                            it.background = context.getDrawable(R.drawable.ic_stop)
                            lastplayer_gloabal?.pause()
//                            if (model.player_global.value!=null){
//                                model.player_global.value!!.pause()
//                            }
                        } else {
                            it.background = context.getDrawable(R.drawable.ic_play)
                            ViewModleMain.isWindowPlay.postValue(true)
//                            if (model.player_global.value!=null){
//                                model.player_global.value!!.start()
//                            }
                            lastplayer_gloabal?.start()
                        }
                    }
                }
                if (row == 1 && column == 3) {
                      imageview.setOnClickListener{
                          closeAllSuspendWindow()
                      }
                }
                if (row==0&&column==1){
                    thisChange=true
                }
                if (thisChange){
                    var textView=TextView(context).apply {
                        text=ViewModleMain.songname.value
                    }
                    addView(textView)
                }else{
                    addView(imageview)
                }
                thisChange=false





            }


        }
    }

    fun image_layout() {
        for (row in 0..1) {
            for (column in 0..3) {
                val left = column * (image_length + spaceMargin)
                val top = row * (image_length + spaceMargin)
                val right = left + image_length
                val bottom = top + image_length
                val index = row * 4 + column
                val image = getChildAt(index)
                image.layout(left.toInt(), top.toInt(), right.toInt(), bottom.toInt())
            }
        }
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        image_layout()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        image_length = ((width - spaceMargin * 3) / 4).toInt()
    }

    fun setModelAndLifeCycleOwner(aModel: SharedViewModel, aOwner: LifecycleOwner) {
        model = aModel
        owner = aOwner
    }

    fun closeAllSuspendWindow() {
//        model.isShowSuspendWindow.postValue(false)
//        model.isShowWindow.postValue(false)
        ViewModleMain.isShowSuspendWindow.postValue(false)
        ViewModleMain.isShowWindow.postValue(false)
//    }

    }
}