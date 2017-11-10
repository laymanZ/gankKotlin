package com.example.hp.gankkotlin.listener

import com.example.hp.gankkotlin.bean.PictureBean
import com.example.hp.gankkotlin.bean.VideoBean


interface DataListener {

    fun onSuccessVideo(data: List<VideoBean>)

    fun onSuccessPicture(data: List<PictureBean>)

    fun onFailed(msg: String)

}