package com.example.musicplayer

import android.util.Log
import android.view.View
import androidx.navigation.findNavController
import com.example.musicplayer.viewModel.SharedViewModel
import com.example.musicplayer.viewModel.ViewModleMain

class Onclick {
    fun find_song_list_onclick(view: View, model: SharedViewModel){//搜索界面歌单跳转到歌单
        model.isLastFragment_findFragment.postValue(true)
        model.shouldShow_bottom_NavigationView.postValue(false)
        model.should_up_Show_play_View.postValue(false)
    }
    fun searchFragment_to_find(view: View,model: SharedViewModel){//搜索界面回到主界面
        model.shouldShow_bottom_NavigationView.postValue(true)
        model.should_up_Show_play_View.postValue(true)
        view.findNavController().navigateUp()
    }
    fun setMusicCanPlaybk(view:View,model: SharedViewModel){
        Log.v("woow","soso")
         if (model.shouldPlaywindow.value==true){
             model.shouldPlaywindow.postValue(false)
         }else{
             model.shouldPlaywindow.postValue(true)
         }
    }
//    fun findFragment_to_search(view: View,model: com.example.musicplayer.viewModel.SharedViewModel){//主界面到搜索界面
//        var i = "周"
//        FindFragmentDirections.actionFindFragmentToSearchFragment(SearchS(i)).apply {
//            view.findNavController().navigate(this)
////                Timer().schedule(3000){
////                    loadingDialog!!.cancel()
////                }
//        }
//        model.shouldShow_bottom_NavigationView.postValue(false)
//        model.should_up_Show_play_View.postValue(false)
//    }
    fun songListFragment_to_Last(view: View,model: SharedViewModel){//歌单到主界面或者搜索界面
        if(model.isLastFragment_findFragment.value==true){
            model.shouldShow_bottom_NavigationView.postValue(true)
            model.should_up_Show_play_View.postValue(true)
        }else{
            model.shouldShow_bottom_NavigationView.postValue(false)
            model.should_up_Show_play_View.postValue(false)
        }
        view.findNavController().navigateUp()
    }
//    fun search_song_list_onclick(view: View, model: com.example.musicplayer.viewModel.SharedViewModel){//搜索界面的歌单跳转
//        model.isLastFragment_findFragment.postValue(false)
//        model.shouldShow_bottom_NavigationView.postValue(false)
//        model.should_up_Show_play_View.postValue(false)
//    }
    fun make_player_stop_or_start(view: View,model: SharedViewModel){
    if (model.isPlayerOn.value==true){
        model.isPlayerOn.postValue(false)
        ViewModleMain.isWindowPlay.postValue(false)
        if(model.player_global.value!=null){
            model.player_global.value!!.pause()

            Log.v("ooo", model.player_global.value!!.duration.toString())
        }
    }else{
        model.isPlayerOn.postValue(true)
        ViewModleMain.isWindowPlay.postValue(true)//全局
        if(model.player_global.value!=null){
            model.player_global.value!!.start()
        }

      }
    }
    fun get_to_musicplayerContent(view: View,sharedViewModel: SharedViewModel){
           sharedViewModel.JumptoPlayerContent.postValue(true)
    }



}
