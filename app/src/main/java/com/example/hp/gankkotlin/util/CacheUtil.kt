package com.example.hp.gankkotlin.util

import io.reactivex.disposables.CompositeDisposable


class CacheUtil {

    companion object {
        val disposalCache: CompositeDisposable = CompositeDisposable()
    }

}