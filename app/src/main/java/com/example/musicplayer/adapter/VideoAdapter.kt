package com.example.musicplayer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.musicplayer.R
import com.example.musicplayer.databinding.FragmentVideoBinding
import com.example.musicplayer.databinding.VideoItemLayoutBinding

class VideoAdapter :RecyclerView.Adapter<VideoAdapter.MyViewHolder>() {

    class MyViewHolder(val binding:VideoItemLayoutBinding):RecyclerView.ViewHolder(binding.root){
        fun bind() {
            //绑定数据
            Glide.with(binding.root.context)
                .load(R.drawable.user_avatar)
                .apply(RequestOptions()
                    .transforms(CenterCrop(),RoundedCorners(30)))
                .into(binding.fragmentVideoImageView)
        }

    }

    //item显示的样式 布局
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //0.创建LayoutInflater布局解析器
        val inflater = LayoutInflater.from(parent.context)
        val binding = VideoItemLayoutBinding.inflate(inflater,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //0.取出需要的数据
        val userName = userNameList[position]
        //1.将数据显示到ViewHolder存储的View的对应控件中
        holder.binding.userNameText.text = userName
        holder.bind()
    }

    override fun getItemCount(): Int {
        return userNameList.size
    }

    //数据源
    val userNameList = listOf("A","B","C","D","E","F","G","H","I","J","K")

}