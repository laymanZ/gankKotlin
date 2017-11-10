package com.example.hp.gankkotlin.bean

import java.io.Serializable


class VideoBean : Serializable {


    /**
     * error : false
     * results : [{"_id":"577e5aa8421aa97c1bf466fa","createdAt":"2016-07-07T21:35:36.324Z","desc":"《本周看不看》:最诚实的观影指南，一周上八部，八部同一天，有毒！","publishedAt":"2016-07-19T12:13:10.925Z","source":"chrome","type":"休息视频","url":"http://www.miaopai.com/show/HR6eYCBBVELwo4f8NQYHSg__.htm","used":true,"who":"lxxself"},{"_id":"5884ba88421aa95ea9de7a11","createdAt":"2017-01-22T21:58:32.709Z","desc":"崔永元大闹周立波婚礼！这口才\u2026\u2026这很崔永元！[笑cry]","publishedAt":"2017-02-04T11:47:42.336Z","source":"chrome","type":"休息视频","url":"http://weibo.com/tv/v/E47qLyrAk?fid=1034:512da8ffd5cf5d468db998bc3227c4f4","used":true,"who":"lxxself"},{"_id":"591067c5421aa90c83a513fa","createdAt":"2017-05-08T20:42:45.664Z","desc":"在地下，拥有258平方公里的城区，上万居民，是世界10大奇景","publishedAt":"2017-05-11T12:03:09.581Z","source":"chrome","type":"休息视频","url":"http://www.bilibili.com/video/av10408797/","used":true,"who":"LHF"},{"_id":"571b4bcf67765974f5e27def","createdAt":"2016-04-23T18:17:51.24Z","desc":"励志滑板短片[梦想]","publishedAt":"2016-04-26T11:58:55.460Z","source":"chrome","type":"休息视频","url":"http://www.wandoujia.com/eyepetizer/detail.html?vid=5868","used":true,"who":"蒋朋"},{"_id":"57cb6e79421aa97cbd81c75f","createdAt":"2016-09-04T08:44:41.861Z","desc":"老师教2+2=5，坚持2+2=4何等不易!","publishedAt":"2016-09-05T11:32:16.999Z","source":"chrome","type":"休息视频","url":"http://www.miaopai.com/show/dSpYA0hMK4DRvsJqOxEpNw__.htm","used":true,"who":"代码家"},{"_id":"56cc6d1d421aa95caa707672","createdAt":"2015-05-31T13:19:25.616Z","desc":"珍爱生命，请远离损友！！","publishedAt":"2015-06-03T04:59:44.677Z","type":"休息视频","url":"http://video.weibo.com/show?fid=1034:d5a16ff3987a881dc4dfbcd3c772e5fb","used":true,"who":"LHF"},{"_id":"591ad331421aa92c73b6470c","createdAt":"2017-05-16T18:23:45.160Z","desc":"送给所有王者荣耀女大学生","publishedAt":"2017-05-23T11:14:05.141Z","source":"chrome","type":"休息视频","url":"https://www.bilibili.com/video/av9945667/","used":true,"who":"lxxself"},{"_id":"56cc6d1d421aa95caa707704","createdAt":"2015-07-16T03:43:41.559Z","desc":"带你了解冥王星。","publishedAt":"2015-07-16T03:58:00.509Z","type":"休息视频","url":"http://www.bilibili.com/video/av2579786/","used":true,"who":"代码家"},{"_id":"56cc6d26421aa95caa707f58","createdAt":"2015-12-03T15:22:58.362Z","desc":"碎片化的一生：被翻译成28国语言的哲理短片《死后的四十种生活》","publishedAt":"2015-12-04T04:00:24.517Z","type":"休息视频","url":"http://video.weibo.com/show?fid=1034:4d00c4ae6b062ce5cb95da683a14cc7d&ep=D6EcrzelR%2C2346404435%2CD6EcrzelR%2C2346404435&sudaref=m.weibo.cn","used":true,"who":"lxxself"},{"_id":"57d61b67421aa909815394f9","createdAt":"2016-09-12T11:05:11.184Z","desc":"性苦闷者的呐喊","publishedAt":"2016-09-12T11:34:31.135Z","source":"chrome","type":"休息视频","url":"http://v.youku.com/v_show/id_XMTcxODMzMjU2MA==.html?beta&","used":true,"who":"代码家"}]
     */

    var isError: Boolean = false
    var results: List<ResultsBean>? = null

    class ResultsBean {
        /**
         * _id : 577e5aa8421aa97c1bf466fa
         * createdAt : 2016-07-07T21:35:36.324Z
         * desc : 《本周看不看》:最诚实的观影指南，一周上八部，八部同一天，有毒！
         * publishedAt : 2016-07-19T12:13:10.925Z
         * source : chrome
         * type : 休息视频
         * url : http://www.miaopai.com/show/HR6eYCBBVELwo4f8NQYHSg__.htm
         * used : true
         * who : lxxself
         */

        var _id: String? = null
        var createdAt: String? = null
        var desc: String? = null
        var publishedAt: String? = null
        var source: String? = null
        var type: String? = null
        var url: String? = null
        var isUsed: Boolean = false
        var who: String? = null
    }
}
