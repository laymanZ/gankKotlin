package com.example.hp.gankkotlin.net

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitManager private constructor() {


    companion object {
        fun get(): RetrofitManager {
            return Inner.retrofitManager
        }
    }

    private object Inner {
        val retrofitManager = RetrofitManager()
    }

    private lateinit var mRetrofit: Retrofit

    fun initRetrofit(baseUrl: String): RetrofitManager {
        mRetrofit = Retrofit
                .Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        return this
    }

    fun createRequest(): NetService {
        return mRetrofit.create(NetService::class.java)
    }

}