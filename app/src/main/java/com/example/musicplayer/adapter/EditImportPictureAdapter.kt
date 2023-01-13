package com.example.musicplayer.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicplayer.R
import com.example.musicplayer.fragment.EditStateFragment

class EditImportPictureAdapter(
    private val data: MutableList<String>,
    private val maxNum: Int
): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    val ADD_ITEM = 1
    val PIC_ITEM = 2
    private var onItemClickListener: OnItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            ADD_ITEM -> {
                var view =
                    LayoutInflater.from(parent.context).inflate(R.layout.edit_add_pic, parent, false)
                return AddViewHolder(view)
            }
            else -> {
                var view = LayoutInflater.from(parent.context).inflate(R.layout.edit_del_pic, parent, false)
                return PicViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //加号的布局
        if (holder is AddViewHolder){
            holder.itemView.setOnClickListener {
                onItemClickListener?.onItemAddClick(position)
            }
        }
        //加载图片的布局
        else {
            Glide.with(holder.itemView.context).load(data[position])
                .into((holder as PicViewHolder).pic)
            Log.v("wd","2222222222222")
            holder.pic.setOnClickListener {
                onItemClickListener?.onItemPicClick(position)
            }
            holder.del.setOnClickListener {
                onItemClickListener?.onItemDelClick(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return if(data.size<maxNum){
            data.size+1
        }else{
            data.size
        }
    }
    /**
     * 当data.size()达到最大值时，返回图片布局，
     * 否则按照逻辑：如果position + 1 == itemCount返回添加布局，不等于返回图片布局
     * (因为如果当前位置+1=itemCount，则代表它是最后一个，因为位置是从0计数的，而itemCount是从1计数)
     */
    override fun getItemViewType(position: Int): Int {

        return if(data.size==maxNum){
            PIC_ITEM
        }else{
            if (position + 1 == itemCount) {
                ADD_ITEM
            } else {
                PIC_ITEM
            }
        }

    }
    //加号布局
    inner class AddViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    //普通布局
    inner class PicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pic: ImageView = itemView.findViewById(R.id.ivImage)
        val del: ImageView = itemView.findViewById(R.id.ivDelete)
    }

    //设置接口回调来实现点击功能
    fun setOnMyClickListener(onClickListener: EditStateFragment) {
        onItemClickListener = onClickListener
    }

    interface OnItemClickListener : AdapterView.OnItemClickListener {
        //点击增加按键
        fun onItemAddClick(position: Int)

        //点击删除按键
        fun onItemDelClick(position: Int)

        //点击图片
        fun onItemPicClick(position: Int)
    }


}