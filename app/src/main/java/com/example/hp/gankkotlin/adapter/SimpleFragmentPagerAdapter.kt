package com.example.hp.gankkotlin.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.hp.gankkotlin.R


class SimpleFragmentPagerAdapter(fm: FragmentManager,
                                 mContext: Context,
                                 private val mData: List<Fragment>) : FragmentPagerAdapter(fm) {

    private val tabTitles = arrayOf(mContext.getString(R.string.picture_name), mContext.getString(R.string.video_name))

    override fun getItem(position: Int): Fragment {
        return mData[position]
    }

    override fun getCount(): Int {
        return mData.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return tabTitles[position]
    }
}