package com.example.musicplayer.Utils

import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import android.widget.Toast
import cn.leancloud.LCFile
import cn.leancloud.LCQuery
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

class SongsUtil(private val context: Context, private var allMusicBinaryMap: MutableMap<String, String>?) {
    private val baseFilePath = context.filesDir.path + "/songs"

    // 对外暴露的播放方法
    fun playMusic(name: String, player: MediaPlayer) {
        getAllMusicBinaryDataOrChosen(name) {
            if (it != null) {
                if (isSongExist(it.key)) {
                    val uri = loadMusicUriFromLocalData(it.key)
                    initMusicPlayer(uri, player)
                    player.start()
                } else {
                    initMusicPlayer(it.value, player)
                    player.start()
                }

            }
        }
    }

    // 对外暴露的播放加缓存方法
    fun playMusicAndLoadingInCache(name: String, player: MediaPlayer) {
        getAllMusicBinaryDataOrChosen(name) {
            if (it != null) {
                initMusicPlayer(it.value, player)
                player.start()
                if (!isSongExist(it.key)) {
                    loadMusicBinaryDataFromLCInCache(it.key)
                }
            }
        }
    }

    // 拿到全部歌曲并且根据歌名搜索到匹配的歌曲
    private fun getAllMusicBinaryDataOrChosen(
        name: String,
        chosen: (Map.Entry<String, String>?) -> Unit = {}
    ) {
        getMusicInfoFromLC {
            allMusicBinaryMap = it
            chosen(getTheOneYouWant(name))
        }
    }

    // 根据歌曲名搜索
    private fun getTheOneYouWant(name: String): Map.Entry<String, String>? {
        allMusicBinaryMap!!.forEach {
            if (it.key.contains(name)) {
                return it
            }
        }
        return null
    }

    // 从 LC 上拿到歌曲的 url 和 歌名
    private fun getMusicInfoFromLC(
        successCallback: (MutableMap<String, String>) -> Unit = {}
    ) {
        val query = LCQuery<LCFile>("_File")
        query.findInBackground().subscribe(object : Observer<List<LCFile>> {
            override fun onSubscribe(d: Disposable) {}

            override fun onNext(t: List<LCFile>) {
                val map = mutableMapOf<String, String>()
                t.forEach {
                    map[it.name] = it.url
                }
                successCallback(map)
            }

            override fun onError(e: Throwable) {
                Toast.makeText(context, "暂无歌曲", Toast.LENGTH_SHORT).show()
            }

            override fun onComplete() {}
        })
    }

    // 判断该歌曲是否已经缓存
    private fun isSongExist(fullName: String): Boolean {
        val file = File("$baseFilePath/$fullName")
        if (file.exists()) {
            return true
        }
        return false
    }

    // 从本地加载
    private fun loadMusicUriFromLocalData(fullName: String): Uri {
        val file = File("$baseFilePath/$fullName")
        return Uri.fromFile(file)
    }

    // 初始化播放器 url
    private fun initMusicPlayer(url: String, mediaPlayer: MediaPlayer) {
        mediaPlayer.apply {
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
            setDataSource(url)
            prepare()
        }
    }

    // 初始化播放器 uri
    private fun initMusicPlayer(uri: Uri, mediaPlayer: MediaPlayer) {
        mediaPlayer.apply {
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
            setDataSource(context, uri)
            prepare()
        }
    }

    // 从 LC 上加载歌曲数据
    private fun loadMusicBinaryDataFromLCInCache(fullName: String) {
        val query = LCQuery<LCFile>("_File")
        query.whereEqualTo("name", fullName)
        query.findInBackground().subscribe(object : Observer<List<LCFile>> {
            override fun onSubscribe(d: Disposable) {}

            override fun onNext(t: List<LCFile>) {
                loadInCacheFile(t[0])
            }

            override fun onError(e: Throwable) {}

            override fun onComplete() {}
        })
    }

    // 存到 cache 里面
    private fun loadInCacheFile(lcFile: LCFile) {
        lcFile.dataStreamInBackground.subscribe(object : Observer<InputStream> {
            override fun onSubscribe(d: Disposable) {}

            override fun onNext(t: InputStream) {
                createDirectoryWithPath(baseFilePath)
                val file = createCacheFile(baseFilePath + "/" + lcFile.name)
                BufferedOutputStream(FileOutputStream(file)).use {
                    val buffer = ByteArray(1024)
                    var len = t.read(buffer, 0, 1024)
                    while (len != -1) {
                        it.write(buffer, 0, len)
                        len = t.read(buffer, 0, 1024)
                    }
                }
            }

            override fun onError(e: Throwable) {}

            override fun onComplete() {}
        })
    }

    // 创建文件夹
    private fun createDirectoryWithPath(path: String) {
        val file = File(path)
        if (!file.exists()) {
            file.mkdirs()
        }
    }

    // 根据歌曲名创建文件名
    private fun createCacheFile(path: String): File {
        return File(path)
    }

}