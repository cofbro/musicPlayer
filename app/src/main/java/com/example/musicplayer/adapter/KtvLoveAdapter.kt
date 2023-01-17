package com.example.musicplayer.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.musicplayer.databinding.KtvLoveItemLayoutBinding

class KtvLoveAdapter:RecyclerView.Adapter<KtvLoveAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = KtvLoveItemLayoutBinding.inflate(inflater,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return 6
    }

    class MyViewHolder(val binding:KtvLoveItemLayoutBinding):RecyclerView.ViewHolder(binding.root){
        @SuppressLint("CheckResult")
        fun bind() {
            binding.ktvTextView1.text = "kpop"
            Glide.with(binding.root.context)
                .load(com.example.musicplayer.R.drawable.user_avatar)
                .apply( RequestOptions()
                    .transforms( CenterCrop(),  RoundedCorners(30)
                    ))
                .into(binding.imageView1)
        }
    }
}