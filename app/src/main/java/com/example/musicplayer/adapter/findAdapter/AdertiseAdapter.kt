package com.example.musicplayer.adapter.findAdapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.musicplayer.R

class AdvertiseAdapter(val context:Context): RecyclerView.Adapter<AdvertiseAdapter.MyViewHolder>() {
    private var advertisePhotos= arrayListOf<String>(
        "https://ts1.cn.mm.bing.net/th/id/R-C.3e21ec89ecc8101d09d0cbe4ddb5e9e1?rik=kd59yNmP%2fzVGAw&riu=http%3a%2f%2fimage.hnol.net%2fc%2f2018-09%2f04%2f18%2f20180904180406711-222325.jpg&ehk=AEPovlWJrsZmeFI7K7kyhlhkWjs6D2w8aP6X7v8E0cA%3d&risl=&pid=ImgRaw&r=0&sres=1&sresct=1",
        "https://ts1.cn.mm.bing.net/th/id/R-C.8a6c5479d956542bb2115f8ddef9f46b?rik=BPm12O%2fZC8owtw&riu=http%3a%2f%2fbpic.588ku.com%2fback_pic%2f00%2f12%2f26%2f97563b5c64babf8.jpg&ehk=%2fKjp72ir9HOc4FRmmAxIzKlNd788CHspLiNPQIhZiSw%3d&risl=&pid=ImgRaw&r=0",
         "https://img.51miz.com/preview/element/00/01/09/10/E-1091098-7C40B44F.jpg",
        "https://ts1.cn.mm.bing.net/th/id/R-C.d837206a39718892ae91e751e064a4df?rik=6yXlrCL3ys0b7Q&riu=http%3a%2f%2fimage.hnol.net%2fc%2f2018-09%2f04%2f18%2f201809041804548881-222325.jpg&ehk=j9%2fVTVp0Mg0Nkwf99dq7VWZp3BqP%2f4X2SXLIBQEnsrU%3d&risl=&pid=ImgRaw&r=0",
        "https://ts1.cn.mm.bing.net/th/id/R-C.ba19a6dc56ef13e59fda108f403bead0?rik=eCTpe0UvmbEAXA&riu=http%3a%2f%2fpic154.huitu.com%2fres%2f20201222%2f274785_20201222120413603060_1.jpg&ehk=Lp%2f8eBtMgPem0BcbYoi44SKRPUzZk3Z2bu20rdBOvf0%3d&risl=&pid=ImgRaw&r=0",
        "https://www.jammyfm.com/wordpress/wp-content/uploads/images/2017/12/14/1513182230494396.jpg",
        "https://ts1.cn.mm.bing.net/th/id/R-C.254e20d2ecebc2c256567e1573fdce7b?rik=k7FcYltf790Q2w&riu=http%3a%2f%2fbpic.588ku.com%2fback_pic%2f04%2f64%2f08%2f145873a04aec90d.jpg&ehk=9UDYsrMTAkgcUgR9Oczs2zI6%2b1V8HHIMauOMIJpP10g%3d&risl=&pid=ImgRaw&r=0"
    )
    private var mImgIds:List<Int> = listOf(R.drawable.calendar1, R.drawable.fm, R.drawable.songlist,
        R.drawable.ranking, R.drawable.live, R.drawable.song, R.drawable.star
    )
    override fun getItemCount(): Int {
        return advertisePhotos.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.activity_advertise_gallery_item,parent,false)
        return MyViewHolder(view)
    }

    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val letter = advertisePhotos[position]
        Glide.with(context)
            .load(letter)
            .apply {
                RequestOptions()
                    .transforms( CenterCrop(),  RoundedCorners(30))

            }
            .into(holder.letterview);
//        holder.letterview.setImageResource(letter)
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        var letterview = itemView.findViewById<ImageView>(R.id.advertistement_item_picture)
    }


}
