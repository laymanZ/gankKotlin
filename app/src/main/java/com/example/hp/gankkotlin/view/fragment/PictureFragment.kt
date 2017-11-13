package com.example.hp.gankkotlin.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.hp.gankkotlin.R
import com.example.hp.gankkotlin.adapter.PictureAdapter
import com.example.hp.gankkotlin.bean.PictureBean
import com.example.hp.gankkotlin.bean.VideoBean
import com.example.hp.gankkotlin.listener.DataListener
import com.example.hp.gankkotlin.presenter.DataPresenter
import kotlinx.android.synthetic.main.activity_picture.view.*


class PictureFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener, DataListener {

    private lateinit var root: View
    private val mPresenter = DataPresenter(this)


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater!!.inflate(R.layout.activity_picture, container, false)
        init()
        return root
    }

    fun init() {
        mPresenter.getPictureData(10)
    }

    override fun onRefresh() {

    }

    override fun onSuccessPicture(data: List<PictureBean>) {
        root.picture_recycler.adapter = PictureAdapter(data, activity)
        root.picture_recycler.layoutManager = LinearLayoutManager(activity)
    }

    override fun onSuccessVideo(data: List<VideoBean>) {

    }

    override fun onFailed(msg: String) {
        Toast.makeText(activity!!, "Picture failed : $msg", Toast.LENGTH_SHORT).show()
    }
}