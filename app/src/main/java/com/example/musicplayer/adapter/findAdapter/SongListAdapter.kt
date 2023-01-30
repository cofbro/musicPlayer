package com.example.musicplayer.adapter.findAdapter

import android.annotation.SuppressLint
import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.SongMessage
import com.example.musicplayer.databinding.ActivitySonglistGalleryItemBinding
import com.example.musicplayer.lastplayer_gloabal
import com.example.musicplayer.viewModel.SharedViewModel
import com.example.musicplayer.viewModel.ViewModleMain

class SongListAdapter(var context: Context):RecyclerView.Adapter<SongListAdapter.MyViewHolder>() {
    var mSongList_names =mutableMapOf<Int, String>()
    var mSongList_song_url = mutableMapOf<Int, String>()
    private lateinit var model: SharedViewModel
    private lateinit var owner: LifecycleOwner
    lateinit var binding:ActivitySonglistGalleryItemBinding
    override fun getItemCount(): Int {
        return mSongList_names.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ActivitySonglistGalleryItemBinding.inflate(inflater)
        return MyViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(SongMessage(mSongList_names[position].toString(),"null",mSongList_song_url[position].toString(),position))
        binding.sharemodel=model
    }
    fun setModelAndLifeCycleOwner(aModel: SharedViewModel, aOwner: LifecycleOwner){
        model = aModel
        owner = aOwner
    }
    @SuppressLint("SetTextI18n")
    class MyViewHolder(var binding:ActivitySonglistGalleryItemBinding ): RecyclerView.ViewHolder(binding.root){
        fun bind(songMessage: SongMessage){
            binding.songlistName.text=songMessage.songName
            binding.songlistNumber.text="${songMessage.position+1}"
            binding.songplayer.setOnClickListener {
                val url = songMessage.SongUrl
                ViewModleMain.isWindowPlay.postValue(true)
                lastplayer_gloabal = MediaPlayer.create(itemView.context, url.toUri())
                binding.sharemodel!!.isPlayerOn.postValue(true)
                binding.sharemodel!!.nowPlayersongName.postValue(songMessage.songName)
                binding.sharemodel!!.nowPlayersongSingerName.postValue(songMessage.songSinger)
                ViewModleMain.songname.postValue(songMessage.songName)
                if ( binding.sharemodel!!.player_global.value ==null){
                    binding.sharemodel!!.player_global.postValue(lastplayer_gloabal)
                }else{
                    binding.sharemodel!!.player_global.value!!.stop()
                    binding.sharemodel!!.player_global.postValue(lastplayer_gloabal)
                }
                lastplayer_gloabal!!.start()
            }
        }


    }


}