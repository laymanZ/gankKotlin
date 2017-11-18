package com.example.hp.gankkotlin.view.activity

import android.support.v7.app.AppCompatActivity
import com.example.hp.gankkotlin.util.CacheUtil


open class BaseActivity : AppCompatActivity() {

    override fun onDestroy() {
        super.onDestroy()
        CacheUtil.disposalCache.clear()
    }
}