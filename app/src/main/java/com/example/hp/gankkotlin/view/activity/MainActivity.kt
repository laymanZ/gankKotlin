package com.example.hp.gankkotlin.view.activity

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.example.hp.gankkotlin.R
import com.example.hp.gankkotlin.adapter.SimpleFragmentPagerAdapter
import com.example.hp.gankkotlin.view.fragment.PictureFragment
import com.example.hp.gankkotlin.view.fragment.VideoFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mData = mutableListOf<Fragment>()

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
    }
}
