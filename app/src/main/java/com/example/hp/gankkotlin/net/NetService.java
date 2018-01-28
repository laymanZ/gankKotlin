package com.example.hp.gankkotlin.net;

import com.example.hp.gankkotlin.bean.OEFindBean;
import com.example.hp.gankkotlin.bean.OEHomeBean;
import com.example.hp.gankkotlin.bean.OEHotBean;
import com.example.hp.gankkotlin.bean.PictureBean;
import com.example.hp.gankkotlin.bean.VideoBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface NetService {

    //gank视频
    @GET("{count}")
    Observable<VideoBean> getVideo(@Path("count") int count);


    //gank图片
    @GET("{count}")
    Observable<PictureBean> getPicture(@Path("count") int count);



    //获取开眼首页第一页数据
    @GET("v2/feed?num=2&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83")
    Observable<OEHomeBean> getOEHomeData();



    //获取开眼首页第一页之后的数据  ?date=1499043600000&num=2
    @GET("v2/feed")
    Observable<OEHomeBean> getOEHomeMoreData(@Query("date") String date,
                                             @Query("num") int num);


    //获取开眼发现频道信息
    @GET("v2/categories")
    Observable<List<OEFindBean>> getOEFindData(@Query("udid") String udid,
                                               @Query("vc") int vc);


    //获取开眼热门排行信息
    @GET("v3/ranklist")
    Observable<OEHotBean> getOEHotData(@Query("num") int num,
                                       @Query("strategy") String strategy,
                                       @Query("udid") String udid,
                                       @Query("vc") int vc);


    //获取开眼发现频道详情信息
    @GET("v3/videos")
    Observable<OEHotBean> getOEFindDetailData(@Query("categoryName") String categoryName,
                                              @Query("strategy") String strategy,
                                              @Query("udid") String udid,
                                              @Query("vc") int vc);


    //获取开眼发现详情加载更多消息
    @GET("v3/videos")
    Observable<OEHotBean> getOEFindDetailMoreData(@Query("start") int start,
                                                  @Query("num") int num,
                                                  @Query("categoryName") String categoryName,
                                                  @Query("strategy") String strategy);


    //获取开眼关键词搜索相关信息
    @GET("v1/search")
    Observable<OEHotBean> getOESearchData(@Query("num") int num,
                                          @Query("query") String query,
                                          @Query("start") int start);

}
