package com.example.musicplayer.untils

import android.icu.util.HebrewCalendar.AV
import cn.leancloud.LCObject
import kotlin.reflect.typeOf

//创建对象存入云端
fun createClassAndUpload(){
    //创建一个云对象
    val Todo = LCObject("Todo")
    //给对象中的属性赋值
    Todo.put("text","用一个词来形容你的2022------")
//    Todo.put("picture_URL",)
}