package com.example.musicplayer.fragment.community

import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.R
import com.example.musicplayer.adapter.VideoAdapter
import com.example.musicplayer.databinding.FragmentVideoBinding
import com.example.musicplayer.utils.SpacingItemDecoration
import java.io.File

class VideoFragment : Fragment() {
    private lateinit var binding:FragmentVideoBinding
    private lateinit var videoView: VideoView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //bindView()

        binding = FragmentVideoBinding.inflate(layoutInflater,container,false)

        binding.recyclerView.adapter = VideoAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireActivity(),RecyclerView.VERTICAL,false)
        binding.recyclerView.addItemDecoration(SpacingItemDecoration(15,30,10,15))
/*
        videoView.setOnClickListener{
            initVideoPath()
        }


 */
        return binding.root
    }
/*
    private fun bindView() {
        //播放路径
        var url = ""
        videoView = binding.recyclerView.findViewById(videoView.id)
        videoView.setVideoPath(url)
        //设置焦点
        videoView.requestFocus()
        //开始播放
        videoView.start()
    }


 */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
/*
    //视频播放初始化
    private fun initVideoPath(){
        //本地视频
        var mMediaController = MediaController(context)
        val uri = "android.resource://com.example.musicplayer/"+ R.raw.antifragile
        videoView.setVideoPath(Uri.parse(uri).toString())
        videoView.setMediaController(mMediaController)

    }

 */
}