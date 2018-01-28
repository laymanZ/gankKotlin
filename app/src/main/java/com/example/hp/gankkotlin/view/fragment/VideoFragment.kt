package com.example.hp.gankkotlin.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hp.gankkotlin.R
import com.example.hp.gankkotlin.adapter.VideoFindAdapter
import com.example.hp.gankkotlin.bean.OEFindBean
import com.example.hp.gankkotlin.listener.VideoFindListener
import com.example.hp.gankkotlin.presenter.VideoFIndPresenter
import kotlinx.android.synthetic.main.activity_picture.view.*
import kotlinx.android.synthetic.main.activity_video_find.view.*


class VideoFragment : Fragment(), VideoFindListener {

    private lateinit var root: View
    private val mPresenter = VideoFIndPresenter(this)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater!!.inflate(R.layout.activity_video_find, container, false)
        init()
        return root
    }

    fun init(){
        mPresenter.getVideoFind()
    }


    override fun onSuccess(data: List<OEFindBean>) {
        val videoFindAdapter = VideoFindAdapter(data,activity)
        root.video_find_recycler.adapter = videoFindAdapter
        root.video_find_recycler.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
    }

    override fun onFailed(msg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



}