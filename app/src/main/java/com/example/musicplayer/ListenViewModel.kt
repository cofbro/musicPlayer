package com.example.musicplayer

import android.content.Context
import android.util.Log
import androidx.core.net.toUri
import androidx.lifecycle.ViewModel
import cn.leancloud.LCFile
import cn.leancloud.LCQuery
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import retrofit2.http.Url
import java.io.BufferedOutputStream
import java.io.FileOutputStream
import java.io.InputStream
import java.net.URL

class ListenViewModel : ViewModel() {

    var songTURL="http://lc-PksCkBWu.cn-n1.lcfile.com/74JnS993dvXcJLNF51w7o3pLehfoIxqN/%E5%91%A8%E6%9D%B0%E4%BC%A6%20-%20%E4%B8%83%E9%87%8C%E9%A6%99.ogg"
    var songUrl="http://lc-PksCkBWu.cn-n1.lcfile.com/74JnS993dvXcJLNF51w7o3pLehfoIxqN/%E5%91%A8%E6%9D%B0%E4%BC%A6%20-%20%E4%B8%83%E9%87%8C%E9%A6%99.ogg".toUri()
    fun getMusicBinaryDataFromLC(context: Context) {
        val query = LCQuery<LCFile>("_File")
        query.whereEqualTo("name", "Red Velvet (레드벨벳) - 过山车 (On A Ride).mp3")
        query.findInBackground().subscribe(object : Observer<List<LCFile>>{
            override fun onSubscribe(d: Disposable) {}

            override fun onNext(t: List<LCFile>) {
                t.find {
                    songUrl=it.url.toUri()
                    Log.v("wi", songUrl.toString())
                    true
                }
            }

            override fun onError(e: Throwable) {}

            override fun onComplete() {}
        })
    }
}