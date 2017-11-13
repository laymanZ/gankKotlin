package com.example.hp.gankkotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hp.gankkotlin.R
import com.example.hp.gankkotlin.bean.PictureBean
import com.example.hp.gankkotlin.util.AnimatorUtil
import com.example.hp.gankkotlin.util.ImageUtil
import kotlinx.android.synthetic.main.activity_picture_item.view.*


class PictureAdapter(private val mData: List<PictureBean>,
                     private val mContext: Context) : RecyclerView.Adapter<PictureAdapter.PictureHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PictureHolder {
        return PictureHolder(LayoutInflater.from(mContext).inflate(R.layout.activity_picture_item, parent, false))
    }

    override fun onBindViewHolder(holder: PictureHolder, position: Int) {
        ImageUtil.loadLargeImg(mContext, holder.itemView.major_img, mData[0].results!![position].url)
        ImageUtil.loadCircleImg(mContext, holder.itemView.picture_user_img, mData[0].results!![position].url)
        holder.itemView.picture_user_name.text = mData[0].results!![position].who
        holder.itemView.picture_create_time.text = filterStr(mData[0].results!![position].createdAt!!)
        AnimatorUtil.showItemAnim(holder.itemView, position)
    }

    override fun getItemCount(): Int {

        return mData[0].results!!.size
    }

    private fun filterStr(str: String): String {
        val temp: List<String> = str.split("T")
        return temp[0]
    }

    class PictureHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
}