package com.example.musicplayer
import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.navigation.findNavController

class ClickEvent {
    fun backToLastFragment(view:View){
        view.findNavController().navigateUp()
    }


    fun getPictureFromAlbum(view: View){
        Log.v("wd","1111111111111")
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        view.context.startActivity(intent)
    }
    fun stepToEditFragment(view: View){
        view.findNavController().navigate(R.id.action_followFragment_to_editStateFragment)
    }

}