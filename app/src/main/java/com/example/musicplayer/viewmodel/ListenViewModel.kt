package com.example.musicplayer.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import cn.leancloud.LCFile
import cn.leancloud.LCQuery
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.io.BufferedOutputStream
import java.io.FileOutputStream
import java.io.InputStream

class ListenViewModel : ViewModel() {
    fun getMusicBinaryDataFromLC(context: Context) {
        val query = LCQuery<LCFile>("_File")
        query.whereEqualTo("name", "Red Velvet (레드벨벳) - 过山车 (On A Ride).mp3")
        query.findInBackground().subscribe(object : Observer<List<LCFile>>{
            override fun onSubscribe(d: Disposable) {}

            override fun onNext(t: List<LCFile>) {
                t[0].dataStreamInBackground.subscribe(object : Observer<InputStream> {
                    override fun onSubscribe(d: Disposable) {}

                    override fun onNext(t: InputStream) {
                        val filePath = context.filesDir.path + "mis"
                        BufferedOutputStream(FileOutputStream(filePath)).use {
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

            override fun onError(e: Throwable) {}

            override fun onComplete() {}
        })
    }
}