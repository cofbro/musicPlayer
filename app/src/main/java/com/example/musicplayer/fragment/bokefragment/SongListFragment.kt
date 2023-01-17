package com.example.musicplayer.fragment.bokefragment

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.adapter.SongListAdapter
import com.example.musicplayer.databinding.FragmentSongListBinding
import com.example.musicplayer.utils.SpacingItemDecoration
import com.example.musicplayer.viewmodel.MainViewModel


class SongListFragment : Fragment() {
    private val mainViewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentSongListBinding
    private lateinit var allMusicBinaryData: MutableMap<String, String>

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSongListBinding.inflate(layoutInflater, container, false)

        val songListAdapter = SongListAdapter(mainViewModel)
        mainViewModel.getAllMusicDataFromLC(songListAdapter)

        binding.handledRecyclerView.apply {
            adapter = songListAdapter
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            addItemDecoration(SpacingItemDecoration(0, 0, 0, 0, true))
        }





        binding.handledScrollView.setScrollTopListener {
            if (it) {
                binding.topConstraintLayout.apply {
                    setBackgroundColor(Color.parseColor("#C6938A"))
                    binding.topNameTextView.text = ""
                    translationZ = 0f
                }
            } else {
                binding.topConstraintLayout.apply {
                    setBackgroundColor(Color.parseColor("#EBB88177"))
                    binding.topNameTextView.text = "爱抽烟屁股的彦祖"
                    translationZ = 20f
                }
            }


        }


        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.backUp.setOnClickListener {
            findNavController().navigateUp()
        }
    }


}