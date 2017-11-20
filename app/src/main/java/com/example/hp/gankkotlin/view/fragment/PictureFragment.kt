package com.example.hp.gankkotlin.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.*
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
    private val mPictureCount = 10


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater!!.inflate(R.layout.activity_picture, container, false)
        init()
        return root
    }

    fun init() {
        mPresenter.getPictureData(mPictureCount)
        root.picture_refresh.setColorSchemeColors(resources.getColor(R.color.colorPrimary),
                resources.getColor(R.color.fab_hot_bg),
                resources.getColor(R.color.fab_more_bg))
        root.picture_refresh.setOnRefreshListener(this)
    }

    override fun onRefresh() {
        mPresenter.getPictureData(mPictureCount)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.picture_menu, menu)
    }

    override fun onSuccessPicture(data: List<PictureBean.ResultsBean>) {
        val pictureAdapter = PictureAdapter(activity)
        root.picture_recycler.adapter = pictureAdapter
        root.picture_recycler.layoutManager = LinearLayoutManager(activity)
        pictureAdapter.updateList(data)
        val anim = DefaultItemAnimator()
        anim.addDuration = 500
        root.picture_recycler.itemAnimator = anim
        if(root.picture_refresh.isRefreshing){
            root.picture_refresh.isRefreshing = false
        }
    }

    override fun onSuccessVideo(data: List<VideoBean>) {

    }

    override fun onFailed(msg: String) {
        Toast.makeText(activity!!, "Picture failed : $msg", Toast.LENGTH_SHORT).show()
    }
}