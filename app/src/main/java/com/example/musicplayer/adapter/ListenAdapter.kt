package com.example.musicplayer.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.R
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.musicplayer.databinding.ItemLayout1Binding

class ListenAdapter: RecyclerView.Adapter<ListenAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLayout1Binding.inflate(inflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return 6
    }

    class MyViewHolder(val binding: ItemLayout1Binding): RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("CheckResult")
        fun bind() {
            binding.textView.text = "勇敢点开，我们就有故事"
            Glide.with(binding.root.context)
                .load(com.example.musicplayer.R.drawable.item1)
                .apply( RequestOptions()
                    .transforms( CenterCrop(),  RoundedCorners(30)
                    ))
                .into(binding.imageView)
        }
    }

}