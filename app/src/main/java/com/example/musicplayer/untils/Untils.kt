package com.example.musicplayer.untils

import android.content.Context
import android.os.Build
import androidx.navigation.NavController
import com.example.musicplayer.R
import kotlinx.coroutines.*

fun Context.dp2pxI(dp:Int):Int = (resources.displayMetrics.density*dp).toInt()

fun Context.dp2pxF(dp:Int):Float = (resources.displayMetrics.density*dp)


//sdk大于二十三
fun SdkMoreThanM():Boolean{
    return Build.VERSION.SDK_INT > Build.VERSION_CODES.M
}
//获取color颜色中的资源判断
fun getResourcesColor(context: Context,resId:Int):Int{
    return if (SdkMoreThanM()){
        context.resources.getColor(R.color.themeRed,null)
    }else{
        context.resources.getColor(R.color.themeRed)
    }
}


//延迟跳转
fun NavController.delayNavigate(id:Int, scope: CoroutineScope){
    scope.launch(Dispatchers.IO) {
        delay(500)
        withContext(Dispatchers.Main){
            navigate(id)
        }
    }
}