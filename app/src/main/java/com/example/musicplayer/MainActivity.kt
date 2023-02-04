package com.example.musicplayer

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.slidingpanelayout.widget.SlidingPaneLayout
import com.example.musicplayer.databinding.ActivityMainBinding
import com.example.musicplayer.fragment.FindFragmentDirections
import com.example.musicplayer.service.BlackandWhiteContainer

import com.example.musicplayer.viewModel.SharedViewModel
import java.lang.reflect.Field


class MainActivity : AppCompatActivity(),SlidingPaneLayout.PanelSlideListener {
    private lateinit var binding: ActivityMainBinding
    private var showSlide = false
    private val sharedViewModel: SharedViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
//        initSlideBackClose()
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater, null, false)
        setContentView(binding.root)
        binding.sharemodel=sharedViewModel
        binding.click=Onclick()
        binding.lifecycleOwner=this

//        binding.texttocontent.setOnClickListener {
//            FindFragmentDirections.actionFindFragmentToPlayerMusicEnterFragment().apply {
//                it.findNavController().navigate(this)
//            }
//        }
        binding.cardView4.setOnClickListener {
            if (binding.fragmentContainerView.findNavController().currentDestination?.id==R.id.findFragment){
                sharedViewModel.JumptoPlayerContent.postValue(true)
                binding.fragmentContainerView.findNavController().navigate(FindFragmentDirections.actionFindFragmentToPlayerContentFragment())}
        }

        //全屏
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

    }
    override fun onResume() {
        super.onResume()
        val controller = WindowInsetsControllerCompat(window, window.decorView)
        //状态栏透明
        window.statusBarColor = Color.TRANSPARENT
        window.navigationBarDividerColor = resources.getColor(R.color.themeRed, null)
        //状态栏黑字
        controller.isAppearanceLightStatusBars = true

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        binding.bottomNavigationView.setupWithNavController(navHostFragment.navController)
    }


    private fun initSlideBackClose() {
        if (isSupportSwipeBack()) {
            val slidingPaneLayout = SlidingPaneLayout(this)
            // 通过反射改变mOverhangSize的值为0，
            // 这个mOverhangSize值为菜单到右边屏幕的最短距离，
            // 默认是32dp，现在给它改成0
            try {
                val overhangSize: Field =
                    SlidingPaneLayout::class.java.getDeclaredField("mOverhangSize")
                overhangSize.isAccessible = true
                overhangSize.set(slidingPaneLayout, 0)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            slidingPaneLayout.addPanelSlideListener(this)

            slidingPaneLayout.sliderFadeColor = resources
                .getColor(android.R.color.transparent)

            // 左侧的透明视图
            val leftView = View(this)
            leftView.layoutParams =
                ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT)
            slidingPaneLayout.addView(leftView, 0)
            val decorView = window.decorView as ViewGroup


            // 右侧的内容视图
            val decorChild = decorView.getChildAt(0) as ViewGroup
            decorChild.setBackgroundColor(resources
                .getColor(android.R.color.white))
            decorView.removeView(decorChild)
            decorView.addView(slidingPaneLayout)

            // 为 SlidingPaneLayout 添加内容视图
            slidingPaneLayout.addView(decorChild, 1)
        }
    }
    protected fun isSupportSwipeBack(): Boolean {
        return true
    }
    override fun onPanelSlide(panel: View, slideOffset: Float) {
        TODO("Not yet implemented")
    }

    override fun onPanelOpened(panel: View) {
        finish()
    }

    override fun onPanelClosed(panel: View) {
        TODO("Not yet implemented")
    }
}