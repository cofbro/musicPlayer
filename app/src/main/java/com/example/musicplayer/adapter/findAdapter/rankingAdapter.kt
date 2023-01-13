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

class rankingAdapter(val context: Context): RecyclerView.Adapter<rankingAdapter.MyViewHolder>() {
    private var title:List<String> = listOf("云音乐国电榜","编辑推荐榜","云音乐欧美新歌榜")
    private var mImgIds:List<String> = listOf("https://ts1.cn.mm.bing.net/th/id/R-C.5d56cbb04f7e86187c7d0ff8d4565ed8?rik=mjvzWysq9eFr3w&riu=http%3a%2f%2fi1.hdslb.com%2fbfs%2farchive%2f7c9758e7424aab5e7529f550ce29ecf882eded1a.jpg&ehk=S8P4NK3wMO48Dgocd29CZVlX3C3dbtgRqLXwwVx%2b4eE%3d&risl=&pid=ImgRaw&r=0",
        "https://ts1.cn.mm.bing.net/th/id/R-C.8310e5002b8f1d03028b617e9a7aab06?rik=foyeJjCXjIFP2w&riu=http%3a%2f%2f5b0988e595225.cdn.sohucs.com%2fimages%2f20190109%2f930ae48449d241a59e8f2ebf11b20b14.jpeg&ehk=2uW3INRAl9IDmqrBW5QyFeXN4OFuWmpLWADbT0MKvcw%3d&risl=&pid=ImgRaw&r=0",
        "https://bbs.musicool.cn/data/attachment/forum/201909/17/195117l1431l1625991m55.jpg",
        "https://ts1.cn.mm.bing.net/th/id/R-C.cffa118e3990337ae0e0b84c0305d379?rik=fQpmQB0jBNhILw&riu=http%3a%2f%2fhimg2.huanqiu.com%2fattachment2010%2f2019%2f0130%2f20190130061043853.jpg&ehk=52KBhS8RD%2fq1pwDi7pScm2PLs%2fzWwhWMb5Um03maSv0%3d&risl=&pid=ImgRaw&r=0",
        "https://tse3-mm.cn.bing.net/th/id/OIP-C.mFvnfMbAowQGN4qgiErjCwHaFP?pid=ImgDet&rs=1",
        "https://p1.ssl.qhmsg.com/t01e3aaa9e250735eb9.jpg",
        "https://tse3-mm.cn.bing.net/th/id/OIP-C.CzGqpoFaXeG2R2VHuj2KFgAAAA?pid=ImgDet&rs=1",
        "https://ts1.cn.mm.bing.net/th/id/R-C.9e19885d91e3a160dccb4cf1550c7893?rik=8loXafvLIPTjXQ&riu=http%3a%2f%2fimg.cvtvcn.com%2fgroup1%2fM00%2f00%2fC6%2fCi0qzVkdVcyAUqLMAABpC3HVTEg44..jpg&ehk=v9WiCGgsyVVGyEdqBi7KW%2bnrTZ3Y3LbzUjziPDe6DtM%3d&risl=&pid=ImgRaw&r=0",
        "https://y.qq.com/music/photo_new/T002R300x300M000002Rg4zL2TADpg_2.jpg?max_age=2592000"


    )
    private var mIds:List<String> = listOf("SOLO","七里香","说好不哭","起风了",
        "再见,夏天","过山车",
        "演员","好像在哪见过你","想去海边")
    @SuppressLint("NotifyDataSetChanged")

    override fun getItemCount(): Int {
        return title.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.activity_ranking_gallery_item,parent,false)
        return MyViewHolder(view)
    }
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        var letterview_toptag = itemView.findViewById<TextView>(R.id.toptag)
        var letterview_top1_view = itemView.findViewById<ImageView>(R.id.imageView1_ranking_top1)
        var letterview_top2_view = itemView.findViewById<ImageView>(R.id.imageView1_ranking_top2)
        var letterview_top3_view = itemView.findViewById<ImageView>(R.id.imageView1_ranking_top3)
        var letterview_top1 = itemView.findViewById<TextView>(R.id.top1)
        var letterview_top2 = itemView.findViewById<TextView>(R.id.top2)
        var letterview_top3 = itemView.findViewById<TextView>(R.id.top3)

    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.letterview_toptag.text = title[position]
        urlToDrawable(context,mImgIds[position*3],holder.letterview_top1_view)
        urlToDrawable(context,mImgIds[position*3+1],holder.letterview_top2_view)
        urlToDrawable(context,mImgIds[position*3+2],holder.letterview_top3_view)
        holder.letterview_top1.text =  mIds[position*3]
        holder.letterview_top2.text = mIds[position*3+1]
        holder.letterview_top3.text = mIds[position*3+2]


    }
    fun urlToDrawable(context: Context,url:String,fin:ImageView){
        Glide.with(context)
            .load(url)
            .into(fin);
    }


}
