package com.example.hp.gankkotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.hp.gankkotlin.bean.VideoBean


class VideoAdapter(private val mData: List<VideoBean>,
                   private val mContext: Context) : RecyclerView.Adapter<VideoAdapter.VideoHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): VideoHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: VideoHolder?, position: Int) {

    }



    class VideoHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
}