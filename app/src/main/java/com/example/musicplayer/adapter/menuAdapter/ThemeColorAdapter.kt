package com.example.musicplayer.adapter.menuAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicplayer.adapter.findAdapter.SongListAdapter
import com.example.musicplayer.databinding.ActivitySonglistGalleryItemBinding
import com.example.musicplayer.databinding.ActivityThemecolorChangeItemBinding
import com.example.musicplayer.menu.ThemechangeColorFragmentDirections
import com.example.musicplayer.menu.menuPicture


class ThemeColorAdapter(var style: Int):RecyclerView.Adapter<ThemeColorAdapter.MyViewHolder>()  {
    lateinit var binding: ActivityThemecolorChangeItemBinding

    var selectionPicture= listOf<String>(
        "https://ts1.cn.mm.bing.net/th/id/R-C.df4462fabf18edd07195679a5f8a37e5?rik=FnNvr9jWWjHCVQ&riu=http%3a%2f%2fseopic.699pic.com%2fphoto%2f50059%2f8720.jpg_wh1200.jpg&ehk=ofb4q76uCls2S07aIlc8%2bab3H5zwrmj%2bhqiZ%2fyw3Ghw%3d&risl=&pid=ImgRaw&r=0"
    ,"https://www.yulumi.cn/gl/uploads/allimg/201121/11200I923-1.jpg",
        "https://pic3.zhimg.com/v2-c6ae9c3aff36b9b221258f6a90577902_r.jpg",
        "https://tse4-mm.cn.bing.net/th/id/OIP-C.s1cqCWEM83XdsIP4XxsrVgHaEo?pid=ImgDet&rs=1",
        "https://ts1.cn.mm.bing.net/th/id/R-C.153336a9a988f98b20a7222bc17e268b?rik=9zakYwd7R8WqrA&riu=http%3a%2f%2fimage.qianye88.com%2fpic%2f03ce2c341c735352456017f282e3a851&ehk=Bzh%2bN6ccxHmlxrJay9S0hH45K1ZPjCaruNxu5GCg8EM%3d&risl=&pid=ImgRaw&r=0"
    )
    var starsPicture= listOf<String>(
        "https://tse1-mm.cn.bing.net/th/id/OIP-C.GOcZatwARU1DvJhOTsbpGAHaL2?pid=ImgDet&rs=1",
        "https://tse1-mm.cn.bing.net/th/id/OIP-C.87j-d2NwuAlFve4DtRb9zQAAAA?pid=ImgDet&rs=1",
        "https://ts1.cn.mm.bing.net/th/id/R-C.0201cfe4695cb273004aeaf5cf427303?rik=zK92yS09xYPawQ&riu=http%3a%2f%2fnews.yxrb.net%2fuploadfile%2f2019%2f0416%2f20190416071259493.jpg&ehk=T5kppsFAhD690A7M3deHMtxhFNB5pd%2fCgwiiJGDs%2b6E%3d&risl=&pid=ImgRaw&r=0",
        "https://pic2.zhimg.com/v2-b2254b9facb4008002f0b43c0b150031_r.jpg",
        "https://i.hexuexiao.cn/up/0b/c1/86/445f806fc9d0f5e37d3ee4de8b86c10b.jpg"
    )
    var festivalPicture= listOf<String>(
        "https://img.zcool.cn/community/01630b5a43a355a8012197418bf117.jpg@1280w_1l_2o_100sh.jpg",
        "https://img.zcool.cn/community/0100ea586c7d6da8012060c8a2d282.jpg@1280w_1l_2o_100sh.jpg",
        "https://img.zcool.cn/community/017880575547ea32f875a4298e139a.jpg@1280w_1l_2o_100sh.jpg",
        "https://img.zcool.cn/community/01dbc35bd00c34a801213dea6085b1.jpg@1280w_1l_2o_100sh.jpg",
        "https://img.zcool.cn/community/013e7b5c2c55f4a80121df90e41ef9.jpg@1280w_1l_2o_100sh.jpg"
    )
    var cartoonPicture= listOf<String>(
        "https://ts1.cn.mm.bing.net/th/id/R-C.8e5cac6c8144528748972ca7d528de4b?rik=2M2EVv9IXHG35w&riu=http%3a%2f%2fpic.nipic.com%2f2007-07-16%2f2007716143447445_2.jpg&ehk=P9gGVPEZ7QDJ5LoRQD0w8UTfcrt3CkHMjhW%2bcNONeGE%3d&risl=&pid=ImgRaw&r=0",
        "https://ts1.cn.mm.bing.net/th/id/R-C.14319e48ccf1c494d89039032cab039d?rik=46efmo3JTu%2bXQA&riu=http%3a%2f%2fimg.juimg.com%2ftuku%2fyulantu%2f131228%2f328105-13122Q1221183.jpg&ehk=K6hRYbrwiZVdJigKBVC5NR%2bCjb8pOADjM12VV2skvDA%3d&risl=&pid=ImgRaw&r=0",
        "https://ts1.cn.mm.bing.net/th/id/R-C.769e942a93eba5edf173a39510a17289?rik=gHGwRW4EDV55DA&riu=http%3a%2f%2fpic20.nipic.com%2f20120504%2f8243992_184042640175_2.png&ehk=AcN0l7pkExqZaXVu7pbDbxs3MOi9qvk%2fgZfDfbAKHCg%3d&risl=&pid=ImgRaw&r=0",
        "https://ts1.cn.mm.bing.net/th/id/R-C.3c1da72cf683e0b24cf6ab63223e9bd5?rik=7KLQa2DfpQ4l5Q&riu=http%3a%2f%2fpic.nipic.com%2f2008-06-11%2f2008611920963_2.jpg&ehk=%2bEY4kN%2bCTVaPdS%2bQ5O1oRKv2YBdNtmog6pTzV8eCnIM%3d&risl=&pid=ImgRaw&r=0",
        "https://ts1.cn.mm.bing.net/th/id/R-C.52f6bb31eb6692879d7c553789a24569?rik=2gRanCyji%2b1FCA&riu=http%3a%2f%2fpic76.nipic.com%2ffile%2f20150906%2f4874506_090216476000_2.jpg&ehk=EPwMUTSFOrIkZa7lCguGkTwYcAM%2f70HV6qqdVlwqj4k%3d&risl=&pid=ImgRaw&r=0"
    )
    var simplePicture= listOf<String>(
        "https://pic4.zhimg.com/v2-acc5c1409c6a75876588ab117f8a165a_r.jpg?source=172ae18b",
        "https://ts1.cn.mm.bing.net/th/id/R-C.d3ae707dcc69a6e70811edf2fcc655dc?rik=0VjPOigCuFIbYw&riu=http%3a%2f%2fwww.kutoo8.com%2fupload%2fimage%2f29759371%2f1409021420906.jpg&ehk=2UL2Q7yAswaJqENAMRCyFP6wgi51QwlGh0yi5J2jeLk%3d&risl=&pid=ImgRaw&r=0",
        "https://img.tukuppt.com/ad_preview/00/16/25/5e9c0759b9aa6.jpg!/fw/980",
        "https://img.tukuppt.com/ad_preview/00/22/02/5c9a393ceadf6.jpg!/fw/980",
        "https://img.tukuppt.com/ad_preview/00/22/28/5c9a3f6edf6ef.jpg!/fw/980"
    )
    override fun getItemCount(): Int {

        if(style==1){//编辑精选
            return  selectionPicture.size
        }
        if (style==2){//明星
            return starsPicture.size
        }
        if (style==3){//节日
            return festivalPicture.size
        }
        if (style==4){//动漫
            return cartoonPicture.size
        }
        if (style==5){//简约
            return simplePicture.size
        }
        return simplePicture.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ActivityThemecolorChangeItemBinding.inflate(inflater)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        lateinit var pictureback: String
        if(style==1){//编辑精选
            pictureback=selectionPicture[position]
        }
        if (style==2){//明星
            pictureback=starsPicture[position]
        }
        if (style==3){//节日
           pictureback=festivalPicture[position]
        }
        if (style==4){
            pictureback=cartoonPicture[position]
        }
        if (style==5){
            pictureback=simplePicture[position]
        }
            holder.bind(pictureback)
    }
    class MyViewHolder(var binding: ActivityThemecolorChangeItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(picture:String){
             urlToDrawable(itemView.context,picture,binding.imageView2)
            binding.itemcolor.setOnClickListener {
               ThemechangeColorFragmentDirections.actionThemechangeColorFragmentToThemeColorFragment(
                   menuPicture(picture)).apply {
                   it.findNavController().navigate(this)
               }
            }
        }
        fun urlToDrawable(context: Context, url:String, fin: ImageView){
            Glide.with(context)
                .load(url)
                .into(fin);
        }


    }


}