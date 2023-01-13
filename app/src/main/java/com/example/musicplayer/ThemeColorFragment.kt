package com.example.musicplayer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.musicplayer.databinding.FragmentThemeColorBinding
import com.example.musicplayer.viewModel.SharedViewModel

class ThemeColorFragment : Fragment() {
    lateinit var binding: FragmentThemeColorBinding
    private val args: ThemeColorFragmentArgs by navArgs()
    val sharedViewModel: SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding=FragmentThemeColorBinding.inflate(layoutInflater, container, false)
        binding.sharemodel=sharedViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.button3.setOnClickListener {
            var img=ImageView(this.context)
            Glide.with(this)
                .load(args.menupicture.picture)
                .into(img);
            sharedViewModel.ThemePicture.postValue(menuPictureandhave(img,true))
            sharedViewModel.changeColor.postValue(true)

        }
        binding.imageView23.setOnClickListener {
            findNavController().navigateUp()
        }
        Glide.with(this)
            .load(args.menupicture.picture)
            .into(binding.imageView22);

    }


}