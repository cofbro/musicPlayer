package com.example.musicplayer.fragment

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.musicplayer.ListenViewModel
import com.example.musicplayer.R
import com.example.musicplayer.databinding.FragmentFollowBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

class FollowFragment : Fragment() {
    private lateinit var binding: FragmentFollowBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFollowBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.left.setOnClickListener{
            binding.scrollView.closePane()
        }
        binding.buttonMain.setOnClickListener{
            binding.scrollView.openPane()
        }
    }

}