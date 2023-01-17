package com.example.musicplayer.fragment.community

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.R
import com.example.musicplayer.adapter.SquareAdapter
import com.example.musicplayer.databinding.FragmentSquareBinding
import com.example.musicplayer.utils.SpacingItemDecoration
import com.example.musicplayer.utils.setChipWithEvent
import com.example.musicplayer.utils.setFirstRecyclerView


class SquareFragment : Fragment() {
    private lateinit var binding:FragmentSquareBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSquareBinding.inflate(layoutInflater,container,false)

        binding.recyclerView.adapter = SquareAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)


        return binding.root
    }

}