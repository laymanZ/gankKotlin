package com.example.hp.gankkotlin.bean

import java.io.Serializable


class PictureBean : Serializable {


    /**
     * error : false
     * results : [{"_id":"59f9674c421aa90fe50c01c6","createdAt":"2017-11-01T14:18:52.937Z","desc":"11-1","publishedAt":"2017-11-01T14:20:59.209Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/20171101141835_yQYTXc_enakorin_1_11_2017_14_16_45_351.jpeg","used":true,"who":"daimajia"},{"_id":"59f7e677421aa90fe72535de","createdAt":"2017-10-31T10:56:55.988Z","desc":"10-31","publishedAt":"2017-10-31T12:25:55.217Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-10-31-nozomisasaki_official_31_10_2017_10_49_17_24.jpg","used":true,"who":"代码家"},{"_id":"59f2aabb421aa90fef2034d5","createdAt":"2017-10-27T11:40:43.793Z","desc":"10-27","publishedAt":"2017-10-27T12:02:30.376Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/20171027114026_v8VFwP_joanne_722_27_10_2017_11_40_17_370.jpeg","used":true,"who":"daimajia"},{"_id":"59f0054a421aa90fe2f02bf4","createdAt":"2017-10-25T11:30:18.697Z","desc":"2017-10-25","publishedAt":"2017-10-25T11:39:10.950Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/20171025112955_lmesMu_katyteiko_25_10_2017_11_29_43_270.jpeg","used":true,"who":"代码家"},{"_id":"59ee8adf421aa90fe50c019b","createdAt":"2017-10-24T08:35:43.61Z","desc":"10-24","publishedAt":"2017-10-24T11:50:49.1Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/20171024083526_Hq4gO6_bluenamchu_24_10_2017_8_34_28_246.jpeg","used":true,"who":"代码家"},{"_id":"59ed70a4421aa90fef2034bc","createdAt":"2017-10-23T12:31:32.639Z","desc":"10-23","publishedAt":"2017-10-23T12:44:23.660Z","source":"chrome","type":"福利","url":"https://img.gank.io/anri.kumaki_23_10_2017_12_27_30_151.jpg","used":true,"who":"代码家"},{"_id":"59e6aadf421aa90fef2034a0","createdAt":"2017-10-18T09:14:07.966Z","desc":"10-18","publishedAt":"2017-10-20T10:26:24.673Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/20171018091347_Z81Beh_nini.nicky_18_10_2017_9_13_35_727.jpeg","used":true,"who":"代码家"},{"_id":"59deaa0c421aa90fe7253583","createdAt":"2017-10-12T07:32:28.644Z","desc":"10-13","publishedAt":"2017-10-17T13:10:43.731Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/20171012073213_p4H630_joycechu_syc_12_10_2017_7_32_7_433.jpeg","used":true,"who":"daimajia"},{"_id":"59dea9cf421aa90fef203477","createdAt":"2017-10-12T07:31:27.363Z","desc":"10-12","publishedAt":"2017-10-16T12:19:20.311Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/20171012073108_0y12KR_anri.kumaki_12_10_2017_7_30_58_141.jpeg","used":true,"who":"daimajia"},{"_id":"59dd6a91421aa90fef20346c","createdAt":"2017-10-11T08:49:21.485Z","desc":"10-11","publishedAt":"2017-10-11T12:40:42.545Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/20171011084856_0YQ0jN_joanne_722_11_10_2017_8_39_5_505.jpeg","used":true,"who":"代码家"}]
     */

    var isError: Boolean = false
    var results: List<ResultsBean>? = null

    class ResultsBean {
        /**
         * _id : 59f9674c421aa90fe50c01c6
         * createdAt : 2017-11-01T14:18:52.937Z
         * desc : 11-1
         * publishedAt : 2017-11-01T14:20:59.209Z
         * source : chrome
         * type : 福利
         * url : http://7xi8d6.com1.z0.glb.clouddn.com/20171101141835_yQYTXc_enakorin_1_11_2017_14_16_45_351.jpeg
         * used : true
         * who : daimajia
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
