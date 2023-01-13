package com.example.musicplayer.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.databinding.SongListItemBinding
import com.example.musicplayer.viewmodel.MainViewModel

class SongListAdapter(private val mainViewModel: MainViewModel) :
    RecyclerView.Adapter<SongListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = SongListItemBinding.inflate(inflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        val data = mainViewModel.getAllMusicBinaryMap()
        if (data != null) {
            return data.size
        }
        return 0
    }

    inner class MyViewHolder(private val binding: SongListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            mainViewModel.bindClickEventInAdapter(binding, position, itemView)
        }

    }
}