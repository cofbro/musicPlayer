package com.example.musicplayer

import android.util.Log
import kotlin.random.Random

object NetWork {
    private val imageList = listOf(
        "https://ts1.cn.mm.bing.net/th/id/R-C.fcd6e5546b73db06f984108f049523bb?rik=C4Vv8PAJA3mIoQ&riu=http%3a%2f%2fpic.3gbizhi.com%2f2017%2f0819%2f20170819013440526.jpg&ehk=guPmPZVxqntG%2bJ2WjPAcUsFusByItgMwbdah6c2Trqw%3d&risl=&pid=ImgRaw&r=0",
        )

    //随机获取一张图片
    fun fetchImage():String{

        val index = Random(System.currentTimeMillis()).nextInt(imageList.size)
        Log.v("tt", index.toString())
        return imageList[index]
    }
}