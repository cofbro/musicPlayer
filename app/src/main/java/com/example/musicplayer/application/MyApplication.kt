package com.example.musicplayer.application

import android.app.Application
import android.util.Log
import cn.leancloud.LCCloud
import cn.leancloud.LCObject
import cn.leancloud.LeanCloud
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        LeanCloud.initialize(this,"PksCkBWumFbGrS4dtAFRZcGO-gzGzoHsz","C45TW07EO15WQIV1mcV6Ilol", "https://pksckbwu.lc-cn-n1-shared.com")
        val o = LCObject("NewTest")
        o.put("new","success")
        o.saveInBackground().subscribe(object : Observer<LCObject> {
            override fun onSubscribe(d: Disposable) {
                Log.d("chy","success")
            }

            override fun onNext(t: LCObject) {

            }

            override fun onError(e: Throwable) {

            }

            override fun onComplete() {

            }

        })
    }
}