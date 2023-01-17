package com.example.musicplayer.fragment

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat.getSystemService
import androidx.recyclerview.widget.GridLayoutManager
import com.example.musicplayer.ClickEvent
import com.example.musicplayer.R
import com.example.musicplayer.adapter.EditImportPictureAdapter
import com.example.musicplayer.databinding.FragmentEditStateBinding
import com.example.musicplayer.untils.GifSizeFilter
import com.zhihu.matisse.Matisse
import com.zhihu.matisse.MimeType
import com.zhihu.matisse.engine.impl.GlideEngine
import com.zhihu.matisse.filter.Filter
import com.zhihu.matisse.internal.entity.CaptureStrategy


class EditStateFragment : Fragment(), EditImportPictureAdapter.OnItemClickListener {
    private val REQUEST_CODE_CHOOSE = 300 //照片选择回调
    private var mSelectedObtainPathResult = mutableListOf<String>()

    //最大能上传的照片数
    private val maxNum = 9
    private val adapter =EditImportPictureAdapter(mSelectedObtainPathResult,maxNum)

    private lateinit var binding:FragmentEditStateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditStateBinding.inflate(layoutInflater,container,false)
        binding.clickEvent = ClickEvent()
        initRecyclerView()
        return binding.root
    }

    /**
     * RecyclerView相关配置
     */
    private fun initRecyclerView(){
        binding.mRecyclerview.layoutManager =GridLayoutManager(context,3)
        binding.mRecyclerview.adapter = adapter
        adapter.setOnMyClickListener(this)
    }
    /**
     * 选择图片
     */
    private fun selectPhoto(num:Int){
        Matisse.from(this)
            .choose(MimeType.ofImage())//选择类
            //拍照需要的两个
            .capture(true)
            .captureStrategy(
                CaptureStrategy(
                    true,
                    "com.example.musicplayer.fileprovider",
                    "test"
                )
            )//最后文件存储地址:Picture/test
            .countable(true)//选择时是否计数
            .maxSelectable(num)//最大可选择数
            .addFilter(GifSizeFilter(320,320,5*Filter.K*Filter.K))//过滤器5M
            .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT)//选择方向
            .thumbnailScale(0.85f)//刚进入图片选择页面后图片的清晰度
            .imageEngine(GlideEngine())//图片引擎
            .theme(com.zhihu.matisse.R.style.Matisse_Dracula)//主题使用默认的
            .originalEnable(true)//原图按钮
            .forResult(REQUEST_CODE_CHOOSE)//请求码
    }

    override fun onItemAddClick(position: Int) {
        selectPhoto(maxNum-mSelectedObtainPathResult.size)
    }

    override fun onItemDelClick(position: Int) {
        mSelectedObtainPathResult.removeAt(position)
        adapter.notifyDataSetChanged()
    }
    //日后可增加图片放大缩小查看功能
    override fun onItemPicClick(position: Int) {
        Toast.makeText(context,"点击图片",Toast.LENGTH_SHORT).show()
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("Not yet implemented")
    }

    /**
     * 选择照片后的回调
     */
    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK) {
            //获取到的地址只是相对地址，但可以给图片加载，若要上传图片，需获取真实本地地址
            mSelectedObtainPathResult.addAll(Matisse.obtainPathResult(data)) //真实地址
            Log.i("ceshi", "onActivityResult:获取到的地址为: " + mSelectedObtainPathResult[0])
           adapter.notifyDataSetChanged()

        }
    }
}