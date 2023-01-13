package com.example.musicplayer.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.musicplayer.R
import com.example.musicplayer.databinding.FragmentWelcomeBinding
import com.example.musicplayer.untils.startAnimationWithListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WelcomeFragment : Fragment() {
    lateinit var binding:FragmentWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcomeBinding.inflate(
            inflater,container,false
        )
        return binding.root
    }

    //交互时开始界面切换
    override fun onResume() {
        super.onResume()
        binding.bottomTextView2.startAnimationWithListener(R.anim.text_up_scale_anim)
        binding.bottomTextView1.startAnimationWithListener(
            R.anim.text_up_scale_anim,
            onEnd = {
                navigateToNextScreen()
            }
        )
    }

    //延时切换的封装方法
    fun navigateToNextScreen(){
        //3秒后切换
        lifecycleScope.launch(Dispatchers.IO) {
            delay(1500)
            withContext(Dispatchers.Main){
                findNavController().navigate(R.id.action_welcomeFragment_to_adFragment)
            }
        }
    }
}