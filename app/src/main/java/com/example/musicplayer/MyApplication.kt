package com.example.musicplayer

import android.app.Application
import cn.leancloud.LeanCloud

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        LeanCloud.initialize(
            this,
            "PksCkBWumFbGrS4dtAFRZcGO-gzGzoHsz",
            "C45TW07EO15WQIV1mcV6Ilol",
            "https://pksckbwu.lc-cn-n1-shared.com"
        )

    }
}