package com.example.musicplayer

import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.musicplayer.databinding.ActivityMainBinding
import com.example.musicplayer.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    private val player = MediaPlayer()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater, null, false)
        setContentView(binding.root)

        //全屏
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        // 注意 player 需要是全局变量
        //mainViewModel.playMusic("过山车", player)
    }

    override fun onResume() {
        super.onResume()
        val controller = WindowInsetsControllerCompat(window, window.decorView)
        //状态栏透明
        window.statusBarColor = Color.TRANSPARENT
        window.navigationBarDividerColor = resources.getColor(R.color.themeRed, null)
        //状态栏黑字
        controller.isAppearanceLightStatusBars = true

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        binding.bottomNavigationView.setupWithNavController(navHostFragment.navController)

    }
}