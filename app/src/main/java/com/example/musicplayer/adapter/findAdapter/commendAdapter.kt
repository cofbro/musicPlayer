package com.example.musicplayer.adapter.findAdapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicplayer.Onclick
import com.example.musicplayer.SongList
import com.example.musicplayer.databinding.ActivityCommendGalleryItemBinding
import com.example.musicplayer.fragment.FindFragmentDirections
import com.example.musicplayer.viewModel.SharedViewModel

class commendAdapter(val context: Context): RecyclerView.Adapter<commendAdapter.MyViewHolder>() {
    private var mImgIds:List<String> = listOf("https://img.zcool.cn/community/01299c5d06ef40a801205e4b15e0c2.jpg@1280w_1l_2o_100sh.jpg",
        "https://img.tukuppt.com/ad_preview/00/13/89/5c997f203b677.jpg!/fw/980",
        "https://p.qqan.com/up/2020-12/16069828411546125.jpg",
        "https://picb.zhimg.com/v2-bd148af81ffe930d0b3b8eb9c841d6bd_b.jpg",
        "https://pic.vjshi.com/2019-11-18/3b13adf9afba5e2453e05d6c1906a87f/00004.jpg?x-oss-process=style/watermark",
        "https://img.zcool.cn/community/0179355e57bd01a80120a8955cdf0b.jpg@1280w_1l_2o_100sh.jpg"
    )
    private lateinit var owner: LifecycleOwner
    private lateinit var binding:ActivityCommendGalleryItemBinding
    private lateinit var sharemodel: SharedViewModel
    private var mIds:List<String> = listOf("失恋","纯音乐精选","超火热门","好听的歌不需要完整","节奏控","好听到单曲循环")
    override fun getItemCount(): Int {
        return mImgIds.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding=ActivityCommendGalleryItemBinding.inflate(inflater)
//        val view = LayoutInflater
//            .from(parent.context)
//            .inflate(R.layout.activity_commend_gallery_item,parent,false)

        return MyViewHolder(binding)
    }
    class MyViewHolder(val binding:ActivityCommendGalleryItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(songList: SongList){
            val letter = songList.SongBackPicture
            Glide.with(itemView)
                .load(letter)
                .into(binding.idIndexGalleryItemImageCommend);
            binding.textItemCommend.text = songList.songListName
            binding.idIndexGalleryItemImageCommend.setOnClickListener{
                val action = FindFragmentDirections.actionFindFragmentToSongListFragment(songList)
                Log.v("wh","gogogo")
                it.findNavController().navigate(action)
            }
        }
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(SongList(mIds[position],mImgIds[position],true))
        binding.sharemodel=sharemodel
        binding.click= Onclick()
        binding.lifecycleOwner = owner
    }
    fun setModelAndLifeCycleOwner(aModel: SharedViewModel, aOwner:LifecycleOwner){
        sharemodel = aModel
        owner = aOwner
    }


}
