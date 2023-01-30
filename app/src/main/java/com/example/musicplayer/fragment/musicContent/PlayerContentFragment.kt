package com.example.musicplayer.fragment.musicContent

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.*
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.SeekBar
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.musicplayer.Onclick
import com.example.musicplayer.R
import com.example.musicplayer.Utils.ItemViewTouchListener
import com.example.musicplayer.Utils.Utils
import com.example.musicplayer.Utils.Utils.REQUEST_FLOAT_CODE
import com.example.musicplayer.databinding.FragmentPlayerContentBinding
import com.example.musicplayer.viewModel.SharedViewModel
import com.example.musicplayer.viewModel.ViewModleMain
class PlayerContentFragment : Fragment() {
    lateinit var binding:FragmentPlayerContentBinding
    private val model: SharedViewModel by activityViewModels()
    var totelTime=0
    var handler: Handler? =null
    private var floatRootView: View? = null//悬浮窗View
    private var isReceptionShow = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding =FragmentPlayerContentBinding.inflate(layoutInflater, container, false)
        binding.sharemodel = model
        binding.click = Onclick()
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    @SuppressLint("CutPasteId")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.opentheplaybk.setOnClickListener {
            Utils.checkAccessibilityPermission(requireActivity()) {
                ViewModleMain.isShowWindow.postValue(true)
                model.isShowWindow.postValue(true)
                isReceptionShow = true
            }

        }
        binding.closeplaywindows.setOnClickListener {
            closeAllSuspendWindow()
        }

        //设置下方导航
        if ( binding.sharemodel!!.player_global.value !=null)
        {
            Log.v("ioo", binding.sharemodel!!.player_global.value!!.duration.toString())
        }

        model.JumptoPlayerContent.postValue(true)
        binding.backs.setOnClickListener {
            findNavController().navigateUp()
            model.JumptoPlayerContent.postValue(false)
        }

        if(model.player_global.value!=null){
            totelTime=model.player_global.value?.duration!!
            binding.seekBarPostiont.max= model.player_global.value?.duration!!//设置长度
            binding.seekBarPostiont.progress = model.player_global.value?.currentPosition!!//设置当前的播放位置
        }
//
        binding.seekBarvolumet.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                var volumeNum=progress/100f
                if (model.player_global.value!=null){
                    model.player_global.value!!.setVolume(volumeNum,volumeNum)
                }//设置音乐音量

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        binding.seekBarPostiont.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                //实现点击后，音乐切换到指定位置
                if (fromUser){
                    if(model.player_global.value!=null){
                        model.player_global.value!!.seekTo(progress)
                        binding.seekBarPostiont.progress=progress
                    }

                }

            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
//               防止在拖动进度条进行进度设置时与Thread更新播放进度条冲突

            }
            @SuppressLint("SetTextI18n")
            override fun onStopTrackingTouch(seekBar: SeekBar?) {


            }

        }


        )

        //更新UI
        handler=object :Handler(Looper.getMainLooper()){
            override fun handleMessage(msg: Message) {
                var currentPostion=msg.what
                //更新滑动的音乐
                binding.seekBarPostiont.progress=currentPostion
                //更新label->时间
                var elapsedTime=createTimeLabel(currentPostion)
                //设置当前位置
                binding.nowProgresst.text=elapsedTime

                var remainTime=createTimeLabel(totelTime-currentPostion)
                //设置还剩多少
                binding.endProgresst.text=remainTime
            }
            fun createTimeLabel(time:Int): String {
                var  min=time/1000/60
                var sec=time/1000%60
                var timeLabel= "$min:"
                if (sec<10 ){
                    timeLabel+="0"

                }
                timeLabel+=sec.toString()
                return timeLabel
            }
        }
        //Thread 更新线程
        Thread {
            while (model.player_global.value != null) {
                try {
                    var msg = Message()
                    msg.what = model.player_global.value!!.currentPosition
                    handler!!.sendMessage(msg)
                    Thread.sleep(1000)
                } catch (o: InterruptedException) {
                }

            }
        }.start()






    }
    /**
     * 应用界面内显示悬浮球
     */
    @SuppressLint("ClickableViewAccessibility")
    private fun showCurrentWindow() {
        var layoutParam = WindowManager.LayoutParams().apply {
            //设置大小 自适应
            width = ViewGroup.LayoutParams.WRAP_CONTENT
            height = ViewGroup.LayoutParams.WRAP_CONTENT
            flags =
                WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL or WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
        }
        // 新建悬浮窗控件
        floatRootView = LayoutInflater.from(requireActivity()).inflate(R.layout.activity_float_item, null)
        //设置拖动事件
        floatRootView?.setOnTouchListener(ItemViewTouchListener(layoutParam, requireActivity().windowManager))
        // 将悬浮窗控件添加到WindowManager
        requireActivity().windowManager.addView(floatRootView, layoutParam)
    }


    /**
     * 关闭所有悬浮窗
     */
    fun closeAllSuspendWindow() {
        if (!Utils.isNull(floatRootView)) {
            if (!Utils.isNull(floatRootView?.windowToken)) {
                if (!Utils.isNull( requireActivity().windowManager)) {
                    requireActivity().windowManager?.removeView(floatRootView)
                }
            }
        }
//        model.isShowSuspendWindow.postValue(false)
//        model.isShowWindow.postValue(false)
        ViewModleMain.isShowSuspendWindow.postValue(false)
        ViewModleMain.isShowWindow.postValue(false)
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_FLOAT_CODE) {
            if (Settings.canDrawOverlays(requireActivity())) {

            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onResume() {
        super.onResume()
        if (isReceptionShow) {
            ViewModleMain.isVisible.postValue(true)
        }
    }

    override fun onStop() {
        super.onStop()
        if (isReceptionShow) {
            ViewModleMain.isVisible.postValue(false)
        }
    }
    }


