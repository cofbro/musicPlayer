package com.example.musicplayer.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.R
import com.example.musicplayer.adapter.SelfAdapter
import com.example.musicplayer.databinding.FragmentSelfBinding


class SelfFragment : Fragment() {
    private lateinit var binding: FragmentSelfBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelfBinding.inflate(layoutInflater, container, false)
        binding.createListRecyclerView.adapter = SelfAdapter()
        binding.createListRecyclerView.layoutManager =
            LinearLayoutManager(requireActivity(),RecyclerView.VERTICAL,false)
        binding.likeListRecyclerView.adapter = SelfAdapter()
        binding.likeListRecyclerView.layoutManager =
            LinearLayoutManager(requireActivity(),RecyclerView.VERTICAL,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //将viewPager与tabLayout关联

    }
}