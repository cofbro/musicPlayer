package com.example.musicplayer.animatior

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.core.animation.addListener
import com.example.musicplayer.R
import com.example.musicplayer.untils.dp2pxF
import com.example.musicplayer.untils.getResourcesColor

class TimeOutJumpView :View {
    private val mStrokeWidth = context.dp2pxF(5)
    //背景画笔
    private val bgPaint = Paint().apply {
        style = Paint.Style.STROKE
        color = Color.GRAY
        strokeWidth = mStrokeWidth
    }
    //前景画笔
    private val arcPaint = Paint().apply {
        style = Paint.Style.STROKE
        color = getResourcesColor(context, R.color.themeRed)
        strokeWidth = mStrokeWidth
    }
    //文本画笔
    private val textPaint = Paint().apply {
        color = Color.BLACK
        textSize = context.dp2pxF(15)
    }
    //圆的半径
    private var mRadius = 0f
    //文字
    private val mText = "跳转"
    private var mTextX = 0f
    private var mTextY = 0f
    //圆弧的弧度
    private var sweepAngel = 0f
    //动画对象
    private lateinit var circleProgressAnimator: ValueAnimator


    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        //计算圆的半径
        mRadius = (width - 2*mStrokeWidth)/2
        val rect = getTextSize(mText,textPaint)
        mTextX = (width-rect.width())/2f
        mTextY = getTextBaseline(paint = textPaint)
    }

    override fun onDraw(canvas: Canvas?) {
        //绘制背景圆形
        canvas?.let {
            //背景绘制（圆形和文字）
            it.drawCircle(width/2f,height/2f,mRadius,bgPaint)
            it.drawText(mText,mTextX,mTextY,textPaint)
            //绘制进度弧
            it.drawArc(mStrokeWidth,mStrokeWidth,width-mStrokeWidth,height-mStrokeWidth,
                270f,sweepAngel,false,arcPaint
            )
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_DOWN){
            stopTimer()
        }
        return true
    }

    //测量字符串的尺寸
    fun getTextSize(text:String,paint: Paint): Rect {
        val rect = Rect()
        paint.getTextBounds(text,0,text.length,rect)
        return rect
    }

    //计算字体baseLine坐标  centerY  + (b+t)/2-b
    fun getTextBaseline(paint: Paint):Float{
        val fontMetrics = paint.fontMetrics
        val bottom = fontMetrics.bottom
        val top = fontMetrics.top
        return height/2f + (bottom-top)/2f- bottom
    }

    //启动动画的方法给外调用
    fun startTimer(aduration: Long,callBack:()->Unit = { }){
        circleProgressAnimator = ValueAnimator.ofFloat(0f,360f).apply {
            duration = aduration
            interpolator = LinearInterpolator()
            addUpdateListener {
                sweepAngel = it.animatedValue as Float
                invalidate()
            }
            addListener(onEnd = {
                callBack()
            })
            start()
        }
    }

    //手动跳转界面
    fun stopTimer(){
        circleProgressAnimator.cancel()
    }
}