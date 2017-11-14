package com.example.hp.gankkotlin.bean


data class OEHotBean(
        val itemList: List<HotItem>,
        val count: Int, //35
        val total: Int, //0
        val nextPageUrl: Any //null
)

data class HotItem(
        val type: String, //video
        val data: HotData,
        val tag: Any //null
)

data class HotData(
        val dataType: String, //VideoBeanForClient
        val id: Int, //59930
        val title: String, //特条 | 「五十度飞」官方虐恋预告
        val slogan: String, //三部曲终章，无禁之爱
        val description: String, //「Fifty Shades Freed」作为全美畅销成人小说的第三部，将继续由 Jamie Dornan 和 Dakota Johnson 主演，并由纸牌屋的导演 James Foley 指导，将于 2018 年 2 月 9 日在美国上映。
        val provider: Provider,
        val category: String, //预告
        val author: Author,
        val cover: Cover,
        val playUrl: String, //http://baobab.kaiyanapp.com/api/v1/playUrl?vid=59930&editionType=default&source=qcloud
        val thumbPlayUrl: Any, //null
        val duration: Int, //142
        val webUrl: WebUrl,
        val releaseTime: Long, //1510024462000
        val library: String, //DAILY
        val playInfo: List<PlayInfo>,
        val consumption: Consumption,
        val campaign: Any, //null
        val waterMarks: Any, //null
        val adTrack: Any, //null
        val tags: List<Tag>,
        val type: String, //NORMAL
        val titlePgc: Any, //null
        val descriptionPgc: Any, //null
        val remark: String,
        val idx: Int, //0
        val shareAdTrack: Any, //null
        val favoriteAdTrack: Any, //null
        val webAdTrack: Any, //null
        val date: Long, //1510024462000
        val promotion: Any, //null
        val label: Any, //null
        val labelList: List<Any>,
        val descriptionEditor: String, //「Fifty Shades Freed」作为全美畅销成人小说的第三部，将继续由 Jamie Dornan 和 Dakota Johnson 主演，并由纸牌屋的导演 James Foley 指导，将于 2018 年 2 月 9 日在美国上映。
        val collected: Boolean, //false
        val played: Boolean, //false
        val subtitles: List<Any>,
        val lastViewTime: Any, //null
        val playlists: Any //null
)

data class Provider(
        val name: String, //YouTube
        val alias: String, //youtube
        val icon: String //http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png
)

data class WebUrl(
        val raw: String, //http://www.eyepetizer.net/detail.html?vid=59930
        val forWeibo: String //http://www.eyepetizer.net/detail.html?vid=59930
)

data class Tag(
        val id: Int, //128
        val name: String, //污
        val actionUrl: String, //eyepetizer://tag/128/?title=%E6%B1%A1
        val adTrack: Any, //null
        val desc: Any, //null
        val bgPicture: String, //http://img.kaiyanapp.com/4bb010aab06fe32397359def83e4e47c.jpeg?imageMogr2/quality/60/format/jpg
        val headerImage: String, //http://img.kaiyanapp.com/5897def623ef2313849502049047dea1.jpeg?imageMogr2/quality/60/format/jpg
        val tagRecType: String //NORMAL
)

data class Consumption(
        val collectionCount: Int, //986
        val shareCount: Int, //1647
        val replyCount: Int //31
)

data class Cover(
        val feed: String, //http://img.kaiyanapp.com/e83de7eeb9568891faa03df306a32ac3.jpeg?imageMogr2/quality/60/format/jpg
        val detail: String, //http://img.kaiyanapp.com/e83de7eeb9568891faa03df306a32ac3.jpeg?imageMogr2/quality/60/format/jpg
        val blurred: String, //http://img.kaiyanapp.com/a935d459ac5912d05e22d5ba2e5c9584.jpeg?imageMogr2/quality/60/format/jpg
        val sharing: Any, //null
        val homepage: String //http://img.kaiyanapp.com/e83de7eeb9568891faa03df306a32ac3.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim
)

data class PlayInfo(
        val height: Int, //480
        val width: Int, //854
        val urlList: List<Url>,
        val name: String, //标清
        val type: String, //normal
        val url: String //http://baobab.kaiyanapp.com/api/v1/playUrl?vid=59930&editionType=normal&source=qcloud
)

data class Url(
        val name: String, //qcloud
        val url: String, //http://baobab.kaiyanapp.com/api/v1/playUrl?vid=59930&editionType=normal&source=qcloud
        val size: Int //10367589
)

data class Author(
        val id: Int, //358
        val icon: String, //http://img.kaiyanapp.com/5da448993aa2b737c6eeb2a9f993a3a6.jpeg?imageMogr2/quality/60
        val name: String, //环球影业
        val description: String, //环球影业（Universal Pictures）是全球最大的电影、电视制片厂之一，也是好莱坞最悠久的公司之一。
        val link: String,
        val latestReleaseTime: Long, //1510024462000
        val videoNum: Int, //51
        val adTrack: Any, //null
        val follow: Follow,
        val shield: Shield,
        val approvedNotReadyVideoCount: Int, //0
        val ifPgc: Boolean //true
)

data class Follow(
        val itemType: String, //author
        val itemId: Int, //358
        val followed: Boolean //false
)

data class Shield(
        val itemType: String, //author
        val itemId: Int, //358
        val shielded: Boolean //false
)