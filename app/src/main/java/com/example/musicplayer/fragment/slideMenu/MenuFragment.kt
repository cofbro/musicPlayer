package com.example.musicplayer.fragment.slideMenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.slidingpanelayout.widget.SlidingPaneLayout
import com.example.musicplayer.R
import com.example.musicplayer.databinding.FragmentFindBinding
import com.example.musicplayer.databinding.FragmentMenuBinding
import com.example.musicplayer.viewModel.SharedViewModel


class MenuFragment : Fragment() {
    lateinit var binding:FragmentMenuBinding
    private val model: SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentMenuBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.JumptoPlayerContent.postValue(true)
        binding.backtofind.setOnClickListener{
            findNavController().navigateUp()
        }
        binding.themecolorchange.setOnClickListener{
            MenuFragmentDirections.actionMenuFragmentToThemechangeColorFragment().apply {
                findNavController().navigate(this)
            }
        }
        binding.helpandresident.setOnClickListener{
            MenuFragmentDirections.actionMenuFragmentToMyhelpAndResidentFragment().apply {
                findNavController().navigate(this)
            }
        }
        binding.setting.setOnClickListener{
            MenuFragmentDirections.actionMenuFragmentToSettingFragment().apply {
                findNavController().navigate(this)
            }
        }
        binding.myaccount.setOnClickListener {
            MenuFragmentDirections.actionMenuFragmentToMyAccountFragment().apply {
                findNavController().navigate(this)
            }
        }

    }
}