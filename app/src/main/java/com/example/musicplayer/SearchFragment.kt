package com.example.musicplayer

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
import com.example.musicplayer.adapter.findAdapter.SearchSongListAdpater
import com.example.musicplayer.adapter.findAdapter.SearchSongsAdapter
import com.example.musicplayer.databinding.FragmentSearchBinding
import com.example.musicplayer.viewModel.SharedViewModel
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class SearchFragment : Fragment() {
    private lateinit var binding:FragmentSearchBinding
    private val args:SearchFragmentArgs by navArgs()//
    private lateinit var searchSongsAdapter:SearchSongsAdapter
    private lateinit var searchSongListAdpater: SearchSongListAdpater
    var mapSongs =mutableMapOf<String, String>()
    var mapSongLists = mutableMapOf<String, String>()
    var Mmap =mutableMapOf<String, String>()
    val MmapSongs =mutableMapOf<Int, String>()
//    var MmapSongList =mutableMapOf<Int, String>()
    var MmapSongUrl = mutableMapOf<Int, String>()//搜索获得的
    var MmapSongListName = mutableMapOf<Int, String>()
    var MmapSongListPicture_Url = mutableMapOf<Int, String>()
    val sharemodel: SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        binding.sharemodel=sharemodel
        binding.lifecycleOwner=viewLifecycleOwner
        binding.click=Onclick()
        Log.v("k123",sharemodel.shouldShow_bottom_NavigationView.value.toString())
        var searchContent = args.search.searchText
        getLcAllSongs(searchContent)
        getLcAllSongLists(searchContent)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.searchthings.setOnClickListener {
            if(binding.searchsongSecond.text.toString()!=""){
                MmapSongs.clear()
                MmapSongUrl.clear()
                MmapSongListPicture_Url.clear()
                MmapSongListName.clear()
                getAllSongsHaveThis((binding.searchsongSecond.text.toString()))
                getAllSongListsHaveThis((binding.searchsongSecond.text.toString()))
                Log.v("wpwpwp",MmapSongs.toString())
            }
        }
        Log.v("wh1","$mapSongs")
        Log.v("wh12","$Mmap")
        var searchContent = args.search.searchText
        Log.v("wh",searchContent)
    }
    fun getLcAllSongLists(tag: String){
        val query = LCQuery<LCObject>("SongsLists")
       query.findInBackground().subscribe(object :Observer<List<LCObject>>{
           override fun onSubscribe(d: Disposable) {

           }

           override fun onNext(t: List<LCObject>) {
            t.forEach {
                mapSongLists[it.get("name").toString()]=it.get("songlist_picture").toString()
                Log.v("ooo",it.get("songlist_picture").toString())
            }
           }

           override fun onError(e: Throwable) {

           }

           override fun onComplete() {
              getAllSongListsHaveThis(tag)
           }

       })
    }

    fun getLcAllSongs(tag:String){
        val query = LCQuery<LCFile>("_File")

        query.findInBackground().subscribe(object : Observer<List<LCFile>> {
            override fun onSubscribe(d: Disposable) {

            }
            override fun onNext(t: List<LCFile>) {

                t.forEach {
                   mapSongs[it.name]=it.url
                }
            }
            override fun onError(e: Throwable) {
            }

            override fun onComplete() {
                Log.v("wh666","$mapSongs")
                getAllSongsHaveThis(tag)
            }
        })


    }
    fun getAllSongListsHaveThis(tag: String){
        var k=0
        Log.v("op", mapSongLists.toString())
        mapSongLists.forEach{
            if(it.key.contains(tag)){
                MmapSongListName[k]=it.key
                MmapSongListPicture_Url[k]=it.value
                Log.v("whh",it.value)
                k++
            }
        }
        Log.v("whh",MmapSongListPicture_Url.toString())

        searchSongListAdpater = SearchSongListAdpater(requireActivity()).apply {
            this.mapsongLists_name = MmapSongListName
            this.mapsongLists_picture_url = MmapSongListPicture_Url
            Log.v("op", this.mapsongLists_name.toString())
            Log.v("op",this.mapsongLists_picture_url.toString())
        }
        searchSongListAdpater.setModelAndLifeCycleOwner(sharemodel,viewLifecycleOwner)
        binding.searchSongLists.apply {
            adapter = searchSongListAdpater
            layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL,false)
        }
    }
    fun getAllSongsHaveThis(tag:String){
        var k=0
        mapSongs.forEach{
            if(it.key.contains(tag)){
                MmapSongs[k]=it.key
                MmapSongUrl[k]=it.value
                k++
            }
        }
        searchSongsAdapter= SearchSongsAdapter(requireActivity()).apply {
//            this.mapSinger = MmapSinger
            this.mapSongsUrl=MmapSongUrl
            this.mapsongs =MmapSongs

        }
        searchSongsAdapter.setModelAndLifeCycleOwner(sharemodel,viewLifecycleOwner)
        binding.searchSongs.apply {
            adapter=searchSongsAdapter
            layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL,false)
        }
    }
//    fun findOneSingsContainsThis(tag:String){
//        val query = LCQuery<LCFile>("_File")
//        query.whereEqualTo("name", "tag")
//        query.findInBackground().subscribe(object : Observer<List<LCFile>> {
//            override fun onSubscribe(d: Disposable) {}
//
//            override fun onNext(t: List<LCFile>) {
//                //添加到数组里面去
//                t.find {
//                    songsForSearch.add(it.url)
//                    true
//                }
//            }
//
//            override fun onError(e: Throwable) {}
//
//            override fun onComplete() {}
//        })
//    }


}