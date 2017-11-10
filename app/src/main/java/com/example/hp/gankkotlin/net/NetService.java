package com.example.hp.gankkotlin.net;

import com.example.hp.gankkotlin.bean.PictureBean;
import com.example.hp.gankkotlin.bean.VideoBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface NetService {

    //  视频
    @GET("{count}")
    Observable<VideoBean> getVideo(@Path("count") int count);

    //   图片
    @GET("{count}")
    Observable<PictureBean> getPicture(@Path("count") int count);

}
