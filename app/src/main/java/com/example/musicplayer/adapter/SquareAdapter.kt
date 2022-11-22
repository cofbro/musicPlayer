package com.example.musicplayer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.R

//圆括号是构造函数 要被实例化
//尖括号是接口不加圆括号 不能被实例化
class SquareAdapter:RecyclerView.Adapter<SquareAdapter.MyViewHolder>() {
    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        val userNameButton = view.findViewById<TextView>(R.id.userNameText)
    }

    //数据源
    val userNameList = listOf("A","B","C","D","E","F","G","H","I","J","K")

    //item显示的样式 布局
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //0.创建LayoutInflater布局解析器
        val inflater = LayoutInflater.from(parent.context)
        //1.将xml中的view解析出来 LayoutInflater 不要加到父容器上
        val view = inflater.inflate(R.layout.fragment_video,parent,false)
        //2.创建ViewHolder对象
        return MyViewHolder(view)
    }

    //将数据绑定到这个ViewHolder中
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //0.取出需要的数据
        val userName = userNameList[position]
        //1.将数据显示到ViewHolder存储的View的对应控件中
        holder.userNameButton.text = userName
    }

    override fun getItemCount(): Int {
        return userNameList.size
    }


}