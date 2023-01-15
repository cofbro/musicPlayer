package com.example.musicplayer

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.musicplayer.databinding.ActivityMainBinding
import com.example.musicplayer.model.SharedViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val model : SharedViewModel by viewModels ()
    private lateinit var iconfont: Typeface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.model = model
        binding.lifecycleOwner = this
        setContentView(binding.root)
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


}