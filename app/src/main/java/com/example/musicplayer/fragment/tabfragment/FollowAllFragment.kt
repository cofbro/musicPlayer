package com.example.musicplayer.fragment.tabfragment

import android.content.res.AssetManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.R
import com.example.musicplayer.adapter.FollowAdapter
import com.example.musicplayer.databinding.FragmentFollowAllBinding
class FollowAllFragment : Fragment() {
   private lateinit var binding:FragmentFollowAllBinding
   private lateinit var adapter:FollowAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFollowAllBinding.inflate(inflater,container,false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
         adapter = FollowAdapter()
        binding.recyclerview.layoutManager = LinearLayoutManager(requireActivity())
        binding.recyclerview.adapter = adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}