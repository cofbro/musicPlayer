package com.example.musicplayer.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.R
import com.example.musicplayer.databinding.RecyclerviewFollowItemBinding
import com.example.musicplayer.fragment.FindFragment
import com.example.musicplayer.fragment.FollowFragment
import com.example.musicplayer.fragment.FollowFragmentDirections

class FollowAdapter :RecyclerView.Adapter<FollowAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecyclerviewFollowItemBinding.inflate(inflater, parent, false)
        return MyViewHolder(binding,parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return 10
    }

    class MyViewHolder(private val binding: RecyclerviewFollowItemBinding, private val parent: ViewGroup):RecyclerView.ViewHolder(binding.root){
        fun bind(){
            itemView.setOnClickListener {
                Log.d("chy","111111111111111111111111111111")
                parent.findNavController().navigate(R.id.action_followFragment_to_dongtaiFragment)
            }
        }
    }
    private var pageList = emptyList<Fragment>()
}