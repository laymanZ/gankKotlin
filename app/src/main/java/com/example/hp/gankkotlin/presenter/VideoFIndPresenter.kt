package com.example.hp.gankkotlin.presenter

import com.example.hp.gankkotlin.bean.OEFindBean
import com.example.hp.gankkotlin.dynamic.ProxyHandler
import com.example.hp.gankkotlin.listener.VideoFindListener
import com.example.hp.gankkotlin.net.RetrofitManager
import com.example.hp.gankkotlin.util.CacheUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class VideoFIndPresenter(private val mDataListener: VideoFindListener) {

    fun getVideoFind() {
        val result = arrayListOf<OEFindBean>()
        RetrofitManager
                .get()
                .initRetrofit(ProxyHandler.getInstance().getBaseUrl("OPEN_EYE_BASE_URL"))
                .createRequest()
                .getOEFindData("26868b32e808498db32fd51fb422d00175e179df", 83)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { mDataListener.onSuccess(it) },
                        { mDataListener.onFailed(it.message!!) },
                        { },
                        { CacheUtil.disposalCache.add(it) }
                )
    }
}