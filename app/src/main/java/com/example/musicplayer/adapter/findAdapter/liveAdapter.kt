package com.example.musicplayer.adapter.findAdapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicplayer.R

class liveAdapter(val context: Context) : RecyclerView.Adapter<liveAdapter.MyViewHolder>() {
    private var letterList = emptyList<Char>()
    private var mImgIds:List<String> = listOf("https://tse2-mm.cn.bing.net/th/id/OIP-C.OtTETcIUeXIYin0SlYp-6wHaEK?pid=ImgDet&rs=1",
        "https://img.youxigt.com/file/2018-09-27/bc43bc2adb87d26327c95b3ddddd28ee.jpg",
        "https://n.sinaimg.cn/sinakd20201008ac/200/w640h360/20201008/bee5-kaaxtfn9104499.jpg",
        "https://ts1.cn.mm.bing.net/th/id/R-C.96220473d2d4a55ea729d31c9f0ee28b?rik=m%2fg83NcS7Nc%2bbQ&riu=http%3a%2f%2fwww.shcaoan.com%2fwy%2fpic1%2f202002%2f20200221143729492.png&ehk=5uZmjiJSMhR5CNkbfiw062UmOATvaVsG0lUoMCa6804%3d&risl=&pid=ImgRaw&r=0",
        "https://tse4-mm.cn.bing.net/th/id/OIP-C.-tJNoQbbsihk82CmKc8NogAAAA?pid=ImgDet&rs=1",
        "https://img.zcool.cn/community/01b7945cd14f23a8012141681fc76c.jpg@1280w_1l_2o_100sh.jpg"
    )
    private var mIds:List<String> = listOf("Cs:go道哥","指法芬芳张大仙","阿赖","吕德华","义孙耀阳","恐怖直播")
    @SuppressLint("NotifyDataSetChanged")
    fun setData(newData: List<Char>){
        letterList = newData
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return mImgIds.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.activity_live_gallery_item,parent,false)
        return MyViewHolder(view)
    }
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        var letterview = itemView.findViewById<ImageView>(R.id.id_index_gallery_item_image_live)
        var lettertext = itemView.findViewById<TextView>(R.id.text_item_live)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val letter = mImgIds[position]
        Glide.with(context)
            .load(letter)
            .into(holder.letterview);
        holder.lettertext.text = mIds[position]
    }


}
