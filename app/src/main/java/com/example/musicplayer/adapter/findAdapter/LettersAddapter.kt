package com.example.musicplayer.adapter.findAdapter
import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.R
import java.text.SimpleDateFormat
import java.util.*

class LettersAddapter: RecyclerView.Adapter<LettersAddapter.MyViewHolder>() {
    private var letterList = emptyList<Char>()
    private var mImgIds= arrayListOf<Int>(R.drawable.calendar1, R.drawable.fm, R.drawable.songlist,
        R.drawable.ranking, R.drawable.live, R.drawable.song, R.drawable.star,R.drawable.book
    )

    @SuppressLint("SimpleDateFormat")
    val sdf = SimpleDateFormat("dd")
    var currentDate = sdf.format(Date()).apply {
        changeServeCalender(this)
    }
    private var mIds:List<String> = listOf("每日推荐","私人FM","歌单","排行榜","直播","新歌","歌房","有声书")
    override fun getItemCount(): Int {
        return mImgIds.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.activity_funtion_gallery_item,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val letter = mImgIds[position]
        holder.letterview.apply {
            setImageResource(letter)

        }
        holder.lettertext.text = mIds[position]
    }

    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        var letterview = itemView.findViewById<ImageView>(R.id.id_index_gallery_item_image_function)
       var lettertext = itemView.findViewById<TextView>(R.id.text_item_function)
    }
    fun changeServeCalender(it: String){
        if (it.toInt()==1){
            mImgIds[0]=R.drawable.calendar1
        }
        if (it.toInt()==2){
            mImgIds[0]=R.drawable.calendar2
        }
        if (it.toInt()==3){
            mImgIds[0]=R.drawable.calendar3
        }
        if (it.toInt()==4){
            mImgIds[0]=R.drawable.calendar4
        }
        if (it.toInt()==5){
            mImgIds[0]=R.drawable.calendar5
        }
        if (it.toInt()==6){
            mImgIds[0]=R.drawable.calendar6
        }
        if (it.toInt()==7){
            mImgIds[0]=R.drawable.calendar7
        }
        if (it.toInt()==8){
            mImgIds[0]=R.drawable.calendar8
        }
        if (it.toInt()==9){
            mImgIds[0]=R.drawable.calendar9
        }
        if (it.toInt()==10){
            mImgIds[0]=R.drawable.calendar10
        }
        if (it.toInt()==11){
            mImgIds[0]=R.drawable.calendar11
        }
        if (it.toInt()==12){
            mImgIds[0]=R.drawable.calendar12
        }
        if (it.toInt()==13){
            mImgIds[0]=R.drawable.calendar13
        }
        if (it.toInt()==14){
            mImgIds[0]=R.drawable.calendar14
        }
        if (it.toInt()==15){
            mImgIds[0]=R.drawable.calendar15
        }
        if (it.toInt()==16){
            mImgIds[0]=R.drawable.calendar16
        }
        if (it.toInt()==17){
            mImgIds[0]=R.drawable.calendar17
        }
        if (it.toInt()==18){
            mImgIds[0]=R.drawable.calendar18
        }
        if (it.toInt()==19){
            mImgIds[0]=R.drawable.calendar19
        }
        if (it.toInt()==20){
            mImgIds[0]=R.drawable.calendar20
        }
        if (it.toInt()==21){
            mImgIds[0]=R.drawable.calendar21
        }
        if (it.toInt()==22){
            mImgIds[0]=R.drawable.calendar22
        }
        if (it.toInt()==23){
            mImgIds[0]=R.drawable.calendar23
        }
        if (it.toInt()==24){
            mImgIds[0]=R.drawable.calendar24
        }
        if (it.toInt()==25){
            mImgIds[0]=R.drawable.calendar25
        }
        if (it.toInt()==26){
            mImgIds[0]=R.drawable.calendar26
        }
        if (it.toInt()==27){
            mImgIds[0]=R.drawable.calendar27
        }
        if (it.toInt()==28){
            mImgIds[0]=R.drawable.calendar28
        }
        if (it.toInt()==29){
            mImgIds[0]=R.drawable.calendar29
        }
        if (it.toInt()==30){
            mImgIds[0]=R.drawable.calendar30
        }
        if (it.toInt()==31){
            mImgIds[0]=R.drawable.calendar31
        }


    }


}
