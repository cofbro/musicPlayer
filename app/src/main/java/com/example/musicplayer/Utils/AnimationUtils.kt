package com.example.musicplayer.Utils

import android.animation.ObjectAnimator
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView

fun Animation.setAnimationStatusChangeListener(
    onStart:(Animation?)->Unit={},
    onEnd:(Animation?)->Unit={},
    onRepeat:(Animation?)->Unit={}
){
    this.setAnimationListener(object :Animation.AnimationListener{
        override fun onAnimationStart(animation: Animation?) {
            onStart(animation)
        }

        override fun onAnimationEnd(animation: Animation?) {
            onEnd(animation)
        }

        override fun onAnimationRepeat(animation: Animation?) {
            onRepeat(animation)
        }

    })
}

fun View.startAnimationWithListener(
    resId: Int,
    onStart:(Animation?)->Unit={},
    onEnd:(Animation?)->Unit={},
    onRepeat:(Animation?)->Unit={}
){
    val animation = AnimationUtils.loadAnimation(this.context,resId)
    animation.setAnimationStatusChangeListener (
        onStart = { onStart(it) },
        onEnd = { onEnd(it) },
        onRepeat = { onRepeat(it) }
    )
    this.startAnimation(animation)
}

fun showBottomNavigationView(view: View) {
    ObjectAnimator.ofFloat(view,"translationY",0f).apply {
        duration = 0
    }.start()
}

fun hideBottomNavigationView(view: View) {
    ObjectAnimator.ofFloat(view,"translationY",200f).apply {
        duration = 0
    }.start()
}
fun hidePlayerContentBottomNavigationView(view: View) {
    ObjectAnimator.ofFloat(view,"translationY",400f).apply {
        duration = 0
    }.start()
}
fun showPlayerContentBottomNavigationView(view: View) {
    ObjectAnimator.ofFloat(view,"translationY",0f).apply {
        duration = 0
    }.start()
}