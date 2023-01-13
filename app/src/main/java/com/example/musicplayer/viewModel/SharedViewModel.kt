package com.example.musicplayer.viewModel

import android.media.MediaPlayer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.musicplayer.menuPictureandhave

class SharedViewModel() :ViewModel(){
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
}