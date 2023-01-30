package com.example.musicplayer.adapter.findAdapter

import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.ISWINDOWPLAY
import com.example.musicplayer.SongMessage
import com.example.musicplayer.databinding.ActivitySearchsongsGalleryItemBinding
import com.example.musicplayer.lastplayer_gloabal
import com.example.musicplayer.viewModel.SharedViewModel
import com.example.musicplayer.viewModel.ViewModleMain


class SearchSongsAdapter(var context: Context): RecyclerView.Adapter<SearchSongsAdapter.MyViewHolder>() {
    var mapsongs = mutableMapOf<Int, String>()
    var mapSinger = mutableMapOf<Int, String>()
    var mapSongsUrl = mutableMapOf<Int,String>()
    lateinit var binding: ActivitySearchsongsGalleryItemBinding
    private lateinit var model: SharedViewModel
    private lateinit var owner: LifecycleOwner
    override fun getItemCount(): Int {
        return mapsongs.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ActivitySearchsongsGalleryItemBinding.inflate(inflater)
        return MyViewHolder(binding)
    }
    class MyViewHolder(var binding: ActivitySearchsongsGalleryItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(songMessage: SongMessage){
            binding.searchsongname.text=songMessage.songName
            binding.searchsongsinger.text=songMessage.songSinger
            binding.searchsongplay.setOnClickListener {

                binding.sharemodel!!.isPlayerOn.postValue(true)
                var url = songMessage.SongUrl
                lastplayer_gloabal= MediaPlayer.create(itemView.context, url.toUri())
                binding.sharemodel!!.isPlayerOn.postValue(true)
                binding.sharemodel!!.nowPlayersongName.postValue(songMessage.songName)
                binding.sharemodel!!.nowPlayersongSingerName.postValue(songMessage.songSinger)
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
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(SongMessage(mapsongs[position].toString(),mapSinger[position].toString(),mapSongsUrl[position].toString(),position))
        binding.sharemodel=model
    }
    fun setModelAndLifeCycleOwner(aModel: SharedViewModel, aOwner: LifecycleOwner){
        model = aModel
        owner = aOwner
    }

}