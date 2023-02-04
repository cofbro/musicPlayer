package com.example.musicplayer.fragment
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.slidingpanelayout.widget.SlidingPaneLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.musicplayer.Onclick

import com.example.musicplayer.R
import com.example.musicplayer.SearchS
import com.example.musicplayer.adapter.findAdapter.*
import com.example.musicplayer.databinding.FragmentFindBinding
import com.example.musicplayer.service.BlackandWhiteContainer
import com.example.musicplayer.viewModel.SharedViewModel

import com.llw.dialog.CustomDialog
import kotlinx.coroutines.*
import java.util.*
import kotlin.concurrent.schedule


class FindFragment : Fragment() {
    private lateinit var binding: FragmentFindBinding
    lateinit var commendAdapter: commendAdapter
    lateinit var lettersAddapter: LettersAddapter
    lateinit var liveAdapter: liveAdapter
    lateinit var rankingAdapter: rankingAdapter
    lateinit var selectAdapter: selectAdapter
    lateinit var advertiseAdapter: AdvertiseAdapter
    lateinit var mSlidePaneLayout: SlidingPaneLayout
    private var showSlide = false
    private lateinit var job: Job
    private var currentIndex = 0

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private var mImgIds:List<Int> = listOf(R.drawable.calendar1, R.drawable.fm, R.drawable.songlist,
        R.drawable.ranking, R.drawable.live, R.drawable.song, R.drawable.star
    )
    private lateinit var linearLayoutManager: LinearLayoutManager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFindBinding.inflate(layoutInflater, container, false)
        binding.sharemodel=sharedViewModel
        binding.lifecycleOwner=viewLifecycleOwner
        binding.click= Onclick()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        liveAdapter = liveAdapter(requireActivity())
        sharedViewModel.isLastFragment_findFragment.postValue(true)
        binding.live.apply {
            adapter = liveAdapter
            layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL,false)
        }
        val srl_my_refresh :SwipeRefreshLayout =binding.srlMyRefresh
        srl_my_refresh.setColorSchemeColors(Color.parseColor("#ff0000"),Color.parseColor("#00ff00"));
        srl_my_refresh.setProgressBackgroundColorSchemeColor(Color.parseColor("#0000ff"));
        //监听 刷新是回调
        srl_my_refresh.setOnRefreshListener {
            srl_my_refresh.postDelayed({ srl_my_refresh.isRefreshing = false; }, 3000)
        }//下拉刷新

        advertiseAdapter = AdvertiseAdapter(requireActivity())
        linearLayoutManager= LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL,false)
        binding.advertistement1.apply {
            adapter = advertiseAdapter
            layoutManager =linearLayoutManager
        }
        binding.advertistement1.addOnScrollListener(object:RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE){
                    //获取当前是第几页
                    currentIndex = linearLayoutManager.findFirstVisibleItemPosition()
                }
            }
        })
        commendAdapter = commendAdapter(requireActivity())
        commendAdapter.setModelAndLifeCycleOwner(sharedViewModel,viewLifecycleOwner)
        binding.recommed.apply {
            adapter = commendAdapter
            layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL,false)
        }
        lettersAddapter = LettersAddapter().apply {
            Log.v("kkk",currentDate)
        }
        binding.function1.apply {
            adapter = lettersAddapter
            layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL,false)
        }
        rankingAdapter = rankingAdapter(requireActivity())
        binding.ranking.apply {
            adapter = rankingAdapter
            layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL,false)
        }
        selectAdapter = selectAdapter(requireActivity())
        binding.selection.apply {
            adapter = selectAdapter
            layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL,false)
        }
        binding.menubutton.setOnClickListener{
            FindFragmentDirections.actionFindFragmentToMenuFragment().apply {
                findNavController().navigate(this)
            }
        }
        var loadingDialog:CustomDialog?=null
        binding.search.setOnClickListener {
            sharedViewModel.should_up_Show_play_View.postValue(false)
            sharedViewModel.shouldShow_bottom_NavigationView.postValue(false)
            loadingDialog = CustomDialog(requireActivity())
            loadingDialog!!.show()
            FindFragmentDirections.actionFindFragmentToSearchFragment(SearchS(binding.searchText.text.toString())).apply {
                findNavController().navigate(this)
                Timer().schedule(3000){
                    loadingDialog!!.cancel()
                }
            }
        }
//        binding.singandcheck.setOnClickListener{
//            model.getMusicBinaryDataFromLC(requireContext())
//                val file = File(requireContext().filesDir.path+"mis")
//                val player = MediaPlayer.create(requireContext(), Uri.fromFile(file))
//                player.start()
//        }
        startPlaySlider()
    }
    fun startPlaySlider(){
        job = lifecycleScope.launch(Dispatchers.IO){
            while (true){
                delay(5000)
                withContext(Dispatchers.Main){
                    if (currentIndex + 1 >= mImgIds.size){
                        currentIndex = 0
                        linearLayoutManager.scrollToPosition(currentIndex)
                    }else{

                        currentIndex ++
                        linearLayoutManager.smoothScrollToPosition(
                            binding.advertistement1,
                            RecyclerView.State(),
                            currentIndex
                        )

                    }
                }
            }
        }
    }

}