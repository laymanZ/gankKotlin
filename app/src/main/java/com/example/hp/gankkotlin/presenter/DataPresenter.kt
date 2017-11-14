package com.example.hp.gankkotlin.presenter

import com.example.hp.gankkotlin.bean.PictureBean
import com.example.hp.gankkotlin.bean.VideoBean
import com.example.hp.gankkotlin.dynamic.ProxyHandler
import com.example.hp.gankkotlin.listener.DataListener
import com.example.hp.gankkotlin.net.RetrofitManager
import com.example.hp.gankkotlin.util.CacheUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class DataPresenter(private val mDataListener: DataListener) {


    fun getPictureData(count: Int) {
        val result = arrayListOf<PictureBean>()
        RetrofitManager
                .get()
                .initRetrofit(ProxyHandler.getInstance().getBaseUrl("PICTURE_BASE_URL"))
                .createRequest()
                .getPicture(count)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result.add(it) },
                        { mDataListener.onFailed(it.message!!) },
                        { mDataListener.onSuccessPicture(result) },
                        { CacheUtil.disposalCache.add(it) }
                )
    }


    fun getVideoData(count: Int) {
        val result = arrayListOf<VideoBean>()
        RetrofitManager
                .get()
                .initRetrofit(ProxyHandler.getInstance().getBaseUrl("VIDEO_BASE_URL"))
                .createRequest()
                .getVideo(count)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result.add(it) },
                        { mDataListener.onFailed(it.message!!) },
                        { mDataListener.onSuccessVideo(result) },
                        { CacheUtil.disposalCache.add(it) }
                )
    }

    fun getOEIndexData(){

    }
}
