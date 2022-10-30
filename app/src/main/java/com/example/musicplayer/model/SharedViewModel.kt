package com.example.musicplayer.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel :ViewModel() {
    var shouldShowNavigationView = MutableLiveData(false)
}