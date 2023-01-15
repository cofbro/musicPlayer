package com.example.musicplayer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.musicplayer.R
import com.example.musicplayer.databinding.SquareItemLayoutBinding

//圆括号是构造函数 要被实例化
//尖括号是接口不加圆括号 不能被实例化
class SquareAdapter:RecyclerView.Adapter<SquareAdapter.MyViewHolder>() {
    class MyViewHolder(val binding:SquareItemLayoutBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(){
            binding.squareUserNameText.text = "一块兔土司"
            Glide.with(binding.root.context)
                .load(R.drawable.user_avatar)
                .apply( RequestOptions()
                    .transforms( CenterCrop(),  RoundedCorners(30)
                    ))
                .into(binding.squareAvatarPic)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = SquareItemLayoutBinding.inflate(inflater,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return 10
    }

}