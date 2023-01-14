package com.example.musicplayer.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.musicplayer.databinding.PlaylistItemBinding

class SelfAdapter:RecyclerView.Adapter<SelfAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PlaylistItemBinding.inflate(inflater,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return 5
    }

    class MyViewHolder(val binding: PlaylistItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind() {
            Glide.with(binding.root.context)
                .load(com.example.musicplayer.R.drawable.ic_music_icon)
                .apply( RequestOptions().transforms(CenterCrop(), RoundedCorners(30)))
                .into(binding.listItemImageView)
        }
    }
}