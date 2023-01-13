package com.example.musicplayer.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.leancloud.LCFile
import cn.leancloud.LCObject
import cn.leancloud.LCQuery
import com.bumptech.glide.Glide
import com.example.musicplayer.Onclick
import com.example.musicplayer.adapter.findAdapter.SongListAdapter
import com.example.musicplayer.databinding.FragmentSongListBinding
import com.example.musicplayer.viewModel.SharedViewModel
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class songListFragment : Fragment() {
    private lateinit var binding:FragmentSongListBinding
    private val args:songListFragmentArgs by navArgs()
    private lateinit var songListAdpter:SongListAdapter
    var songList_name:String?=null
    val sharedViewModel: SharedViewModel by activityViewModels()
    private var thisTurnSongList_array:List<*>?=null
    var mapSongs_model =mutableMapOf<String, String>()
    var mapSongLists_picture_model = mutableMapOf<String, String>()
    var mapSongLists_songs_model = mutableMapOf<String, List<*>>()

    //    private val songList:SongList by lazy {
//        val SongListArgs = SongListArgs.songList
//        model.NoewSongList.postValue(SongListArgs)
//        SongListArgs
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSongListBinding.inflate(layoutInflater, container, false)
        binding.sharemodel=sharedViewModel
        binding.lifecycleOwner=viewLifecycleOwner
        binding.click= Onclick()
        Log.v("kkkkkkkk",sharedViewModel.shouldShow_bottom_NavigationView.value.toString())
        songList_name = args.songList.songListName
        getLcAllSongs(songList_name!!)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        sharedViewModel.should_up_Show_play_View.postValue(false)
        sharedViewModel.shouldShow_bottom_NavigationView.postValue(false)
       binding.songListName.text=args.songList.songListName
        Glide.with(this)
            .load(args.songList.SongBackPicture)
            .into(binding.songPicture);
    }
    fun getUrl_song_back(songName:String):String=mapSongs_model[songName].toString()
    fun getLcAllSongLists(songListNameM:String){
        val query = LCQuery<LCObject>("SongsLists")
        query.findInBackground().subscribe(object : Observer<List<LCObject>> {
            override fun onSubscribe(d: Disposable) {

            }
            override fun onNext(t: List<LCObject>) {
                t.forEach {
                    mapSongLists_picture_model[it.get("name").toString()]=it.get("songlist_picture").toString()
                    mapSongLists_songs_model [it.get("name").toString()]= it.get("songs") as List<*>
                }
            }

            override fun onError(e: Throwable) {

            }

            override fun onComplete() {
                mapSongLists_songs_model.forEach{
                    if (it.key.toString()==songListNameM){
                        thisTurnSongList_array= it.value
                    }
                }//加载所有歌名
                var k =0
                songListAdpter = SongListAdapter(requireActivity()).apply {
                    thisTurnSongList_array?.forEach {
                        this.mSongList_names[k]=it.toString()
                        this.mSongList_song_url[k]=getUrl_song_back(it.toString())
                        k++
                    }

                }
                songListAdpter.setModelAndLifeCycleOwner(sharedViewModel,viewLifecycleOwner)
                binding.songList.apply {
                    adapter = songListAdpter
                    layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL,false)
                }
            }

        })
    }

    fun getLcAllSongs(songListNameM:String){
        val query = LCQuery<LCFile>("_File")
        query.findInBackground().subscribe(object : Observer<List<LCFile>> {
            override fun onSubscribe(d: Disposable) {

            }
            override fun onNext(t: List<LCFile>) {

                t.forEach {
                    mapSongs_model[it.name]=it.url
                }
            }
            override fun onError(e: Throwable) {
            }

            override fun onComplete() {
                getLcAllSongLists(songListNameM)
            }
        })


    }

}