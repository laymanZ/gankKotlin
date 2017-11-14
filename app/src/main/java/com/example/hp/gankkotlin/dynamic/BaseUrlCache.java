package com.example.hp.gankkotlin.dynamic;

import java.util.HashMap;
import java.util.Map;


public enum BaseUrlCache {

    INSTANCE;

    private final Map<String, String> mCache = new HashMap<>();


    {
        mCache.put("PICTURE_BASE_URL", "http://gank.io/api/random/data/福利/");
        mCache.put("VIDEO_BASE_URL", "http://gank.io/api/random/data/休息视频/");
        mCache.put("OPEN_EYE_BASE_URL","http://baobab.kaiyanapp.com/api/");
    }


    public Map<String, String> getCache() {
        return mCache;
    }

}
