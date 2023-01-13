package com.example.musicplayer

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SongList (
    var songListName:String,
    var SongBackPicture:String,
    var isFindToSonglist:Boolean
        ): Parcelable
@Parcelize
data class SongListsContainer(
    var songNameList:List<String>,
    var songPeople:List<String>
) : Parcelable
data class SongMessage(
    var songName:String,
    var songSinger:String,
    var SongUrl:String,
    var position:Int

)
