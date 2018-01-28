package com.example.hp.gankkotlin.presenter

import com.example.hp.gankkotlin.bean.PictureBean
import com.example.hp.gankkotlin.dynamic.ProxyHandler
import com.example.hp.gankkotlin.listener.PictureDataListener
import com.example.hp.gankkotlin.net.RetrofitManager
import com.example.hp.gankkotlin.util.CacheUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class PictureDataPresenter(private val mDataListener: PictureDataListener) {

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
                        { mDataListener.onSuccess(result[0].results!!) },
                        { CacheUtil.disposalCache.add(it) }
                )
    }

}
