package com.example.musicplayer.fragment.tabfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicplayer.R
import com.example.musicplayer.adapter.DongtaiCommentAdapter
import com.example.musicplayer.databinding.FragmentDontaiCommentsBinding

class DontaiCommentsFragment : Fragment() {
    private lateinit var binding:FragmentDontaiCommentsBinding
    private lateinit var adapter: DongtaiCommentAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDontaiCommentsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = DongtaiCommentAdapter()
        binding.recyclerview.layoutManager = LinearLayoutManager(requireActivity())
        binding.recyclerview.adapter = adapter
    }
}