package com.example.musicplayer

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.musicplayer.Utils.hideBottomNavigationView
import com.example.musicplayer.Utils.showBottomNavigationView

@BindingAdapter("should_up_Show_play")
fun View.should_up_Show_play(show:Boolean) {
    if (show) { //现在需要显示
        showBottomNavigationView(this)
    } else {
        hideBottomNavigationView(this)
    }
}
//@BindingAdapter("changeMenuBk")
//fun ViewGroup.changeMenuBk(menuPictureandhave: menuPictureandhave) {
//    if (menuPictureandhave.have) {
//        this.background = menuPictureandhave.picture.background
//    }
//}


@BindingAdapter("setPlayer_picture")
fun ImageView.setPlayer_picture(show: Boolean){
     if(show){
         setImageResource(R.drawable.ic_stop)
     }
    else
     {
         setImageResource(R.drawable.openmusic)
     }
}
@BindingAdapter("setPlayer_songname")
fun TextView.setPlayer_songname(name:String){
    this.text=name
}
@BindingAdapter("shouldShow_bottomnavigation")
fun View.shouldShow_bottomnavigation(show:Boolean) {
    if (show){ //现在需要显示
        showBottomNavigationView(this)
    }else{
        hideBottomNavigationView(this)
    }
}

