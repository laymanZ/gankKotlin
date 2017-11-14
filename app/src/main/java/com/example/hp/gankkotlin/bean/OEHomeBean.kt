package com.example.hp.gankkotlin.bean


data class OEHomeBean(
        val issueList: List<Issue>,
        val nextPageUrl: String, //http://baobab.kaiyanapp.com/api/v2/feed?date=1510448400000&num=2
        val nextPublishTime: Long, //1510707600000
        val newestIssueType: String, //morning
        val dialog: Any //null
)

data class Issue(
        val releaseTime: Long, //1510621200000
        val type: String, //morning
        val date: Long, //1510621200000
        val publishTime: Long, //1510621200000
        val itemList: List<HomeItem>,
        val count: Int //7
)

data class HomeItem(
        val type: String, //banner2
        val data: HomeData,
        val tag: Any //null
)

data class HomeData(
        val dataType: String, //Banner
        val id: Int, //0
        val title: String,
        val description: String,
        val image: String, //http://img.kaiyanapp.com/eef24aa10ab6cf17b5a512943ec22053.jpeg?imageMogr2/quality/60/format/jpg
        val actionUrl: String,
        val adTrack: Any, //null
        val shade: Boolean, //false
        val label: Any, //null
        val labelList: Any, //null
        val header: Any //null
)