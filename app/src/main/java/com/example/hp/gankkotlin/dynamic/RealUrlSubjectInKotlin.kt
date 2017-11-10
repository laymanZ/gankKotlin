package com.example.hp.gankkotlin.dynamic


class RealUrlSubjectInKotlin : UrlSubjectInKotlin {

    override fun getBaseUrl(key: String): Any {
        return BaseUrlCacheInKotlin.mCache[key]!!
    }

}