package com.example.musicplayer.fragment.community

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.adapter.KtvLoveAdapter
import com.example.musicplayer.adapter.KtvRoomAdapter
import com.example.musicplayer.databinding.FragmentKtvBinding
import com.example.musicplayer.utils.SpacingItemDecoration
import com.example.musicplayer.utils.setChipWithEvent



class KtvFragment : Fragment() {
    private lateinit var binding:FragmentKtvBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentKtvBinding.inflate(layoutInflater,container,false)
        setChipWithEvent(requireActivity(),binding.chipGroup,binding)

        binding.recyclerViewLove.adapter = KtvLoveAdapter()
        binding.recyclerViewLove.layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
        binding.recyclerViewLove.addItemDecoration(SpacingItemDecoration(15,0,15,0))

        binding.recyclerViewRoom.adapter = KtvRoomAdapter()
        binding.recyclerViewRoom.layoutManager = GridLayoutManager(context,2,RecyclerView.VERTICAL,false)
        binding.recyclerViewRoom.addItemDecoration(SpacingItemDecoration(10,15,10,15))

        return binding.root
    }


}