package com.example.musicplayer

import android.app.Application
import android.content.Context
import cn.leancloud.LeanCloud
import me.weishu.reflection.Reflection

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
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        Reflection.unseal(base)
    }
}