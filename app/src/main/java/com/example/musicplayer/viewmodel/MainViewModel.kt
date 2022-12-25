package com.example.musicplayer.viewmodel


import android.app.Application
import android.media.MediaPlayer
import androidx.lifecycle.AndroidViewModel
import com.example.musicplayer.utils.SongsUtil


class MainViewModel(app: Application): AndroidViewModel(app) {
    private var allMusicBinaryMap: MutableMap<String, String>? = null
    private val songsUtil = SongsUtil(app, allMusicBinaryMap)

    // 播放
    fun playMusic(name: String, player: MediaPlayer) {
        songsUtil.playMusic(name, player)
    }

    // 播放 + 缓存
    fun playMusicAndLoadInCache(name: String, player: MediaPlayer) {
        songsUtil.playMusicAndLoadingInCache(name, player)
    }
}