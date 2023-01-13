package com.example.musicplayer.viewModel


import android.app.Application
import android.media.MediaPlayer
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import cn.leancloud.LCFile
import cn.leancloud.LCObject
import cn.leancloud.LCQuery
import com.example.musicplayer.Utils.SongsUtil
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


class MainViewModel():ViewModel()  {
    var mapSongs_model =mutableMapOf<String, String>()
    var mapSongLists_picture_model = mutableMapOf<String, String>()
    var mapSongLists_songs_model = mutableMapOf<String, List<*>>()

    init {
            getLcAllSongLists()
            getLcAllSongs()//得到所有的数据
    }
    fun getLcAllSongLists(){
        val query = LCQuery<LCObject>("SongsLists")
        query.findInBackground().subscribe(object : Observer<List<LCObject>> {
            override fun onSubscribe(d: Disposable) {

            }
            override fun onNext(t: List<LCObject>) {
                t.forEach {
                    mapSongLists_picture_model[it.get("name").toString()]=it.get("songlist_picture").toString()
                    mapSongLists_songs_model [it.get("name").toString()]= it.get("songs") as List<*>
                }
            }

            override fun onError(e: Throwable) {

            }

            override fun onComplete() {
                Log.v("model",mapSongLists_songs_model.toString())
            }

        })
    }

    fun getLcAllSongs(){
        val query = LCQuery<LCFile>("_File")
        query.findInBackground().subscribe(object : Observer<List<LCFile>> {
            override fun onSubscribe(d: Disposable) {

            }
            override fun onNext(t: List<LCFile>) {

                t.forEach {
                    mapSongs_model[it.name]=it.url
                }
            }
            override fun onError(e: Throwable) {
            }

            override fun onComplete() {

            }
        })


    }
}