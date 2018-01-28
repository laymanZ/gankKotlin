package com.example.hp.gankkotlin.listener


interface BaseDataListener<in T> {

    fun onSuccess(data: List<T>)

    fun onFailed(msg: String)

}