package com.example.musicplayer.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.*
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.musicplayer.NetWork
import com.example.musicplayer.R
import com.example.musicplayer.databinding.FragmentAdBinding
import com.example.musicplayer.untils.delayNavigate

class AdFragment : Fragment() {
    lateinit var binding: FragmentAdBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAdBinding.inflate(inflater,container,false)
        Glide
            .with(this)
            .load(NetWork.fetchImage())
            .into(binding.advImageView)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val window = activity?.window
        val controller = WindowInsetsControllerCompat(window!!, window.decorView)
        window.statusBarColor = Color.WHITE
        controller.hide(WindowInsetsCompat.Type.statusBars())
    }
    override fun onResume() {
        super.onResume()
        binding.timeoutJumpView.startTimer(3000){
            findNavController().delayNavigate(
                R.id.action_adFragment_to_findFragment,lifecycleScope
            )
        }
    }

}