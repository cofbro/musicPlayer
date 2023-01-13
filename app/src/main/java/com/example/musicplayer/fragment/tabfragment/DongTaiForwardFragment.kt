package com.example.musicplayer.fragment.tabfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicplayer.R
import com.example.musicplayer.adapter.DongtaiCommentAdapter
import com.example.musicplayer.adapter.DongtaiForwardAdapter
import com.example.musicplayer.databinding.FragmentDongtaiForwardBinding
import com.example.musicplayer.databinding.FragmentDontaiCommentsBinding

class DongTaiForwardFragment : Fragment() {
    private lateinit var binding: FragmentDongtaiForwardBinding
    private lateinit var adapter: DongtaiForwardAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDongtaiForwardBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = DongtaiForwardAdapter()
        binding.recyclerview.layoutManager = LinearLayoutManager(requireActivity())
        binding.recyclerview.adapter = adapter
    }

}