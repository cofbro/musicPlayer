package com.example.musicplayer


import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.core.content.PackageManagerCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.musicplayer.databinding.ActivityMainBinding
import com.example.musicplayer.model.SharedViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val model : SharedViewModel by viewModels ()
    var isReadable = false
    var isWritable = false
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
<<<<<<< HEAD
=======
        //检查权限
        checkPermission()
        //申请权限
        requestPermission()
    }

    override fun onStart() {
        super.onStart()
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        binding.bottomNavigationView.setupWithNavController(navHostFragment.navController)

>>>>>>> origin/wd
    }

    override fun onResume() {
        super.onResume()
        val controller = WindowInsetsControllerCompat(window, window.decorView)
        //状态栏透明
        window.statusBarColor = Color.TRANSPARENT
        window.navigationBarDividerColor = resources.getColor(R.color.themeRed, null)
        //状态栏黑字
        controller.isAppearanceLightStatusBars = true
<<<<<<< HEAD

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        binding.bottomNavigationView.setupWithNavController(navHostFragment.navController)
=======
    }
    //检查权限
    fun checkPermission(){
        isReadable = ContextCompat.checkSelfPermission(
            this,android.Manifest.permission.READ_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED
        isWritable = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
            true
        }else{
            ContextCompat.checkSelfPermission(
                this,android.Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        }
    }
    fun requestPermission(){
     //创建保存权限的对象
        var permissionArray = arrayListOf<String>()
        //创建一个launcher对象
        var resultLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ){
            isReadable = it[android.Manifest.permission.READ_EXTERNAL_STORAGE]?:false
            isWritable = it[android.Manifest.permission.WRITE_EXTERNAL_STORAGE]?:false
        }
        if (!isWritable){
            permissionArray.add(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        if (!isReadable){
            permissionArray.add(android.Manifest.permission.READ_EXTERNAL_STORAGE)
        }
        resultLauncher.launch(permissionArray.toTypedArray())
>>>>>>> origin/wd
    }

}