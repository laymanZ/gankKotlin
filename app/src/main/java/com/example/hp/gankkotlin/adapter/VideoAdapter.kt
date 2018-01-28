package com.example.hp.gankkotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.hp.gankkotlin.R
import com.example.hp.gankkotlin.bean.OEFindBean
import com.example.hp.gankkotlin.bean.VideoBean
import com.example.hp.gankkotlin.util.ImageUtil
import kotlinx.android.synthetic.main.activity_video_find_item.view.*


class VideoFindAdapter(private val mData: List<OEFindBean>,
                       private val mContext: Context) : RecyclerView.Adapter<VideoFindAdapter.VideoHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): VideoHolder {
        return VideoHolder(LayoutInflater.from(mContext).inflate(R.layout.activity_video_find_item, parent, false))
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: VideoHolder, position: Int) {
        ImageUtil.loadLargeImg(mContext,
                holder.itemView.video_find_item_img,
                mData[position].bgPicture)
        holder.itemView.video_find_item_tv.text = mData[position].name
    }


    class VideoHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
}