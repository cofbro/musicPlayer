package com.example.musicplayer

import android.os.Parcelable
import android.text.Editable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchS(
    var searchText: String
): Parcelable