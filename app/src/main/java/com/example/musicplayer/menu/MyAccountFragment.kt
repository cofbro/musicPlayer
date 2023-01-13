package com.example.musicplayer.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.musicplayer.R
import com.example.musicplayer.databinding.FragmentMyAccountBinding
import com.example.musicplayer.databinding.FragmentMyhelpAndResidentBinding

class MyAccountFragment : Fragment() {

    lateinit var binding: FragmentMyAccountBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentMyAccountBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


    }


}