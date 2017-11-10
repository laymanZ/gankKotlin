package com.example.hp.gankkotlin.dynamic


class BaseUrlCacheInKotlin {

    companion object {
        private val pictureKey = "PICTURE_BASE_URL"
        private val videoKey = "VIDEO_BASE_URL"
        val mCache = mapOf(pictureKey to "http://gank.io/api/data/福利/",
                videoKey to "http://gank.io/api/random/data/休息视频/")
    }

}