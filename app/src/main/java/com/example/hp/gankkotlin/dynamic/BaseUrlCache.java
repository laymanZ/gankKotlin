package com.example.hp.gankkotlin.dynamic;

import java.util.HashMap;
import java.util.Map;


public enum BaseUrlCache {

    INSTANCE;

    private final Map<String, String> mCache = new HashMap<>();


    {
        mCache.put("PICTURE_BASE_URL", "http://gank.io/api/random/data/福利/");
        mCache.put("VIDEO_BASE_URL", "http://gank.io/api/random/data/休息视频/");
    }


    public Map<String, String> getCache() {
        return mCache;
    }

}
