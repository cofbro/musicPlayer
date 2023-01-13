package com.example.musicplayer.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.musicplayer.R
import com.example.musicplayer.databinding.ItemLayout1Binding

class ListenAdapter: RecyclerView.Adapter<ListenAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLayout1Binding.inflate(inflater, parent, false)
        return MyViewHolder(binding,parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return 6
    }

    class MyViewHolder(val binding: ItemLayout1Binding, private val parent: ViewGroup): RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("CheckResult")
        fun bind() {
            binding.textView.text = "勇敢点开，我们就有故事"
            Glide.with(binding.root.context)
                .load(R.drawable.item1)
                .apply( RequestOptions()
                    .transforms( CenterCrop(),  RoundedCorners(30)
                    ))
                .into(binding.imageView)

            itemView.setOnClickListener {
                parent.findNavController().navigate(R.id.action_bokeFragment_to_songListFragment)
            }
        }
    }

}