package com.example.musicplayer.viewmodel


import android.annotation.SuppressLint
import android.app.Application
import android.media.MediaPlayer
import android.view.View
import androidx.lifecycle.AndroidViewModel
import com.example.musicplayer.adapter.SongListAdapter
import com.example.musicplayer.databinding.SongListItemBinding
import com.example.musicplayer.utils.SongsUtil


class MainViewModel(app: Application) : AndroidViewModel(app) {
    private var mediaPlayer = MediaPlayer()
    private var allMusicBinaryMap: MutableMap<String, String>? = null
    private var allMusicBinaryList: ArrayList<SongsUtil.SongPair>? = null
    private val songsUtil = SongsUtil(app, allMusicBinaryMap)

    // 播放
    fun playMusic(name: String, player: MediaPlayer) {
        songsUtil.playMusic(name, player)
    }

    // 播放 + 缓存
    fun playMusicAndLoadInCache(name: String, player: MediaPlayer) {
        songsUtil.playMusicAndLoadingInCache(name, player)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun getAllMusicDataFromLC(adapter: SongListAdapter) {
        songsUtil.getMusicInfoFromLC(getListCallback = { list -> allMusicBinaryList = list }) {
            this.allMusicBinaryMap = it
            adapter.notifyDataSetChanged()
        }
    }

    fun getAllMusicBinaryMap(): MutableMap<String, String>? {
        return allMusicBinaryMap
    }

    fun bindClickEventInAdapter(binding: SongListItemBinding, position: Int, itemView: View) {
        if (allMusicBinaryList != null) {
            binding.songName.text = allMusicBinaryList!![position].songName
            itemView.setOnClickListener {
                if (mediaPlayer.isPlaying) {
                    mediaPlayer.reset()
                }
                playMusic(allMusicBinaryList!![position].songName, mediaPlayer)
            }
        }
    }
}