package com.example.hp.gankkotlin.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.hp.gankkotlin.R
import com.example.hp.gankkotlin.bean.PictureBean
import com.example.hp.gankkotlin.bean.VideoBean
import com.example.hp.gankkotlin.listener.DataListener


class VideoFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener, DataListener {


    private lateinit var root: View

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater!!.inflate(R.layout.activity_picture, container, false)
        return root
    }

    override fun onRefresh() {

    }

    override fun onSuccessVideo(data: List<VideoBean>) {

    }

    override fun onSuccessPicture(data: List<PictureBean>) {

    }

    override fun onFailed(msg: String) {
        Toast.makeText(activity, "Video failed : $msg", Toast.LENGTH_SHORT).show()
    }

}