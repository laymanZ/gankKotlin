package com.example.hp.gankkotlin.presenter

import com.example.hp.gankkotlin.bean.OEFindBean
import com.example.hp.gankkotlin.dynamic.ProxyHandler
import com.example.hp.gankkotlin.listener.VideoFindListener
import com.example.hp.gankkotlin.net.RetrofitManager
import com.example.hp.gankkotlin.util.CacheUtil
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class VideoFIndPresenter(private val mDataListener: VideoFindListener) {

    fun getVideoFind() {
        val result = arrayListOf<OEFindBean>()
        RetrofitManager
                .get()
                .initRetrofit(ProxyHandler.getInstance().getBaseUrl("OPEN_EYE_BASE_URL"))
                .createRequest()
                .oeFindData
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result.add(it) },
                        { mDataListener.onFailed(it.message!!) },
                        { mDataListener.onSuccess(result) },
                        { CacheUtil.disposalCache.add(it) }
                )
    }
}