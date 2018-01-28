package com.example.hp.gankkotlin.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.widget.PopupMenu
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Toast
import com.example.hp.gankkotlin.R
import com.example.hp.gankkotlin.bean.PictureBean
import com.example.hp.gankkotlin.util.AnimatorUtil
import com.example.hp.gankkotlin.util.ImageUtil
import com.example.hp.gankkotlin.view.activity.PictureDetailActivity
import kotlinx.android.synthetic.main.activity_picture_item.view.*


class PictureAdapter(private val mContext: Context) : RecyclerView.Adapter<PictureAdapter.PictureHolder>() {

    private var mData = mutableListOf<PictureBean.ResultsBean>()


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PictureHolder {
        return PictureHolder(LayoutInflater.from(mContext).inflate(R.layout.activity_picture_item, parent, false))
    }

    override fun onBindViewHolder(holder: PictureHolder, position: Int) {
        ImageUtil.loadLargeImg(mContext, holder.itemView.major_img, mData[position].url)
        ImageUtil.loadCircleImg(mContext, holder.itemView.picture_user_img, mData[position].url)
        holder.itemView.picture_user_name.text = mData[position].who
        holder.itemView.picture_create_time.text = filterStr(mData[position].createdAt!!)
        holder.itemView.picture_favorite.setOnClickListener {
            var i = 1
            it.animate()
                    .rotationBy(360f)
                    .setDuration(500)
                    .setInterpolator(AccelerateDecelerateInterpolator())
                    .start()
            holder.itemView.text_favorite_count.apply {
                animate()
                        .rotationXBy(360f)
                        .setDuration(500)
                        .setInterpolator(AccelerateDecelerateInterpolator())
                        .setUpdateListener {
                            if (i == 10) {
                                holder.itemView.text_favorite_count.text = calculateStr(text.toString())
                            }
                            i++
                        }
                        .start()
            }
        }
        holder.itemView.major_img.setOnClickListener {
            val temp = mContext as Activity
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(temp, it,
                    mContext.resources.getString(R.string.transitionName)).toBundle()
            val intent = Intent(mContext, PictureDetailActivity::class.java)
            intent.putExtra("imgUrl", mData[position].url)
            ActivityCompat.startActivity(mContext, intent, options)

        }
        holder.itemView.picture_item_more.setOnClickListener {
            val mPopMenu = PopupMenu(mContext, it)
            mPopMenu.menuInflater.inflate(R.menu.picture_menu, mPopMenu.menu)
            mPopMenu.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.save_pic -> {
//                        ImageUtil.saveImageToGallery(mContext, mData[position].url)
                    }
                    else -> {
                        mPopMenu.dismiss()
                    }
                }
                false
            }
            mPopMenu.show()
        }
        AnimatorUtil.showItemAnim(holder.itemView, position)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    private fun filterStr(str: String): String {
        val temp: List<String> = str.split("T")
        return temp[0]
    }

    private fun calculateStr(str: String): String {
        val temp: List<String> = str.split(",")
        return "${temp[0]},${temp[1].toInt() + 1}"
    }

    fun updateList(temp: List<PictureBean.ResultsBean>) {
        mData.addAll(temp)
        notifyDataSetChanged()
        Toast.makeText(mContext, mContext.resources.getString(R.string.update), Toast.LENGTH_SHORT).show()
    }

    class PictureHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
}