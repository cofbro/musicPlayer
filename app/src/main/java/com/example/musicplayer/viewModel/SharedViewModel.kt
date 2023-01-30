package com.example.musicplayer.viewModel

import android.app.Application
import android.media.MediaPlayer
import android.util.Log
import androidx.annotation.NonNull
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.musicplayer.ISWINDOWPLAY
import com.example.musicplayer.lastplayer_gloabal
import com.example.musicplayer.menuPictureandhave


class SharedViewModel : ViewModel() {
    var should_up_Show_play_View = MutableLiveData(true)
    var shouldShow_bottom_NavigationView= MutableLiveData(true)
    var isLastFragment_findFragment = MutableLiveData(true)
    var isPlayerOn=MutableLiveData(false)
    var player_global = MutableLiveData<MediaPlayer>()
    var nowPlayersongName=MutableLiveData<String>("唱响歌曲")
    var nowPlayersongSingerName=MutableLiveData<String>("畅想歌曲")
    var changeColor=MutableLiveData(false)
    var ThemePicture=MutableLiveData<menuPictureandhave>().apply {
        this.value?.have=false
    }
    var shouldPlaybk=MutableLiveData(false)
    var shouldPlaywindow=MutableLiveData(false)//是否点击文体，显示
    var JumptoPlayerContent=MutableLiveData(false)//判断是否进入播放器界面
    //悬浮窗口创建 移除  基于无障碍服务
    var isShowWindow = MutableLiveData<Boolean>()
    //悬浮窗口创建 移除

    var isShowSuspendWindow = MutableLiveData<Boolean>()

    //悬浮窗口显示 隐藏
    var isVisible = MutableLiveData<Boolean>()
}