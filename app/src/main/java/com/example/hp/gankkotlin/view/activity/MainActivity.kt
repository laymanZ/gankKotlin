package com.example.hp.gankkotlin.view.activity

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.OvershootInterpolator
import com.example.hp.gankkotlin.R
import com.example.hp.gankkotlin.adapter.SimpleFragmentPagerAdapter
import com.example.hp.gankkotlin.util.AnimatorUtil
import com.example.hp.gankkotlin.view.fragment.PictureFragment
import com.example.hp.gankkotlin.view.fragment.VideoFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mData = mutableListOf<Fragment>()
    private var mHasClick = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()
        initData()
        initTab()
        initControl()
    }

    private fun initData() {
        mData.apply {
            add(PictureFragment())
            add(VideoFragment())
        }
    }

    private fun initTab() {
        main_pager.adapter = SimpleFragmentPagerAdapter(supportFragmentManager, this, mData)
        main_tab.setupWithViewPager(main_pager)
        main_tab.tabMode = TabLayout.MODE_FIXED
    }

    private fun initControl() {

        main_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                if (positionOffsetPixels != 0) {
                    main_fab.rotation = 360 * positionOffset
                }
            }
        })


        main_fab.setOnClickListener {
            if (!mHasClick) {
                AnimatorUtil.fabAnim(main_fab_more, 300, OvershootInterpolator(), 0f, 1f)
                AnimatorUtil.fabAnim(main_fab_hot, 200, OvershootInterpolator(), 0f, 1f)
                main_fab_more.visibility = View.VISIBLE
                main_fab_hot.visibility = View.VISIBLE
                AnimatorUtil.revealAnim(main_cover_view, 350, mHasClick)
                main_cover_view.visibility = View.VISIBLE
                main_fab.apply {
                    animate().rotationBy(180f)
                            .setDuration(200)
                            .start()
                    setImageResource(R.drawable.ic_videocam_white_24dp)
                }
                mHasClick = true
            } else {
                hideFab()
            }

        }


        main_cover_view.setOnClickListener {
            hideFab()
        }

        main_fab_more.setOnClickListener {

        }

        main_fab_hot.setOnClickListener {

        }

    }

    private fun hideFab() {
        main_fab.apply {
            animate().rotationBy(-180f)
                    .setDuration(200)
                    .start()
            setImageResource(R.drawable.ic_add_white_24dp)
        }
        main_fab_more.visibility = View.GONE
        main_fab_hot.visibility = View.GONE
        main_cover_view.visibility = View.GONE
        mHasClick = false
    }
}
