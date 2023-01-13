package com.example.musicplayer.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.adapter.menuAdapter.ThemeColorAdapter
import com.example.musicplayer.databinding.FragmentThemechangeColorBinding


class ThemechangeColorFragment : Fragment() {

     lateinit var binding:FragmentThemechangeColorBinding
     lateinit var SelectcolorChangeAdapter:ThemeColorAdapter
    lateinit var StarscolorChangeAdapter:ThemeColorAdapter
    lateinit var FestivalcolorChangeAdapter:ThemeColorAdapter
    lateinit var cartooncolorChangeAdapter:ThemeColorAdapter
    lateinit var simplecolorChangeAdapter:ThemeColorAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding=FragmentThemechangeColorBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.backtotheme.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.backtotheme.setOnClickListener {
            findNavController().navigateUp()
        }
        SelectcolorChangeAdapter= ThemeColorAdapter(1)//精选
        binding.selection.apply {
            adapter=SelectcolorChangeAdapter
            layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL,false)
        }
        StarscolorChangeAdapter= ThemeColorAdapter(2)//明星
        binding.stars.apply {
            adapter=StarscolorChangeAdapter
            layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL,false)
        }
        FestivalcolorChangeAdapter= ThemeColorAdapter(3)//节日
        binding.festival.apply {

            adapter=FestivalcolorChangeAdapter
            layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL,false)
        }
        cartooncolorChangeAdapter= ThemeColorAdapter(4)//卡通
        binding.cartoon.apply {

            adapter= cartooncolorChangeAdapter
            layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL,false)
        }
        simplecolorChangeAdapter= ThemeColorAdapter(5)//简约
        binding.simple.apply {
            adapter= simplecolorChangeAdapter
            layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL,false)
        }


    }


}