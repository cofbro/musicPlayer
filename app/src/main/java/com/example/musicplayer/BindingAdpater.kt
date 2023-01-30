package com.example.musicplayer

import android.annotation.SuppressLint
import android.opengl.Visibility
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.Switch
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import com.example.musicplayer.Utils.hideBottomNavigationView
import com.example.musicplayer.Utils.hidePlayerContentBottomNavigationView
import com.example.musicplayer.Utils.showBottomNavigationView
import com.example.musicplayer.Utils.showPlayerContentBottomNavigationView
import com.example.musicplayer.viewModel.SharedViewModel
import com.example.musicplayer.viewModel.ViewModleMain

@BindingAdapter("should_up_Show_play")
fun View.should_up_Show_play(model: Boolean) {
                if(model){
                    showBottomNavigationView(this)
                }else{
                    hideBottomNavigationView(this)
                }


        }
@BindingAdapter("shouldGotoPlayerContent")
fun View.shouldGotoPlayerContent(model: Boolean){
    if (model){
        hidePlayerContentBottomNavigationView(this)
    }else{
        showPlayerContentBottomNavigationView(this)
    }
}
@SuppressLint("UseSwitchCompatOrMaterialCode")
@BindingAdapter("shouldPlaybk")
fun Switch.shouldPlaybk(model: SharedViewModel){
    if (this.isChecked){
        model.shouldPlaybk.postValue(true)
    }else{
        model.shouldPlaybk.postValue(false)
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
             setImageResource(R.drawable.openmusic)
     }
    else
     {
             setImageResource(R.drawable.ic_stop)
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
@BindingAdapter("shouldOnPlayerDraw")
fun SeekBar.shouldOnPlayerDraw(progress:Int){
    this.setProgress(progress,true)
}


