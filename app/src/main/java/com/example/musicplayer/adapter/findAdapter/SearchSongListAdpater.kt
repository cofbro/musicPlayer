package com.example.musicplayer.adapter.findAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicplayer.Onclick
import com.example.musicplayer.SearchFragmentDirections
import com.example.musicplayer.SongList
import com.example.musicplayer.databinding.ActivitySearchsonglistGalleryItemBinding
import com.example.musicplayer.viewModel.SharedViewModel

class SearchSongListAdpater (var context: Context): RecyclerView.Adapter<SearchSongListAdpater.MyViewHolder>() {
    var mapsongLists_name = mutableMapOf<Int, String>()
    var mapsongLists_picture_url = mutableMapOf<Int, String>()
    lateinit var binding: ActivitySearchsonglistGalleryItemBinding
    private lateinit var model: SharedViewModel
    private lateinit var owner: LifecycleOwner
    override fun getItemCount(): Int {
        return mapsongLists_name.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ActivitySearchsonglistGalleryItemBinding.inflate(inflater)
        return MyViewHolder(binding)
    }
    class MyViewHolder(val binding: ActivitySearchsonglistGalleryItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(songList: SongList){
            binding.searchsonglistName.text=songList.songListName
            Glide.with(itemView)
                .load(songList.SongBackPicture)
                .into( binding.searchSonglistPicture);
            binding.searchSonglistConstraint.setOnClickListener {
                this.binding.sharemodel!!.isLastFragment_findFragment.postValue(false)
                val action = SearchFragmentDirections.actionSearchFragmentToSongListFragment(songList)
                it.findNavController().navigate(action)
            }


        }
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(SongList(mapsongLists_name[position].toString(),mapsongLists_picture_url[position].toString(),false))
        binding.click= Onclick()
        binding.sharemodel=model
    }
    fun setModelAndLifeCycleOwner(aModel: SharedViewModel, aOwner: LifecycleOwner){
        model = aModel
        owner = aOwner
    }

}