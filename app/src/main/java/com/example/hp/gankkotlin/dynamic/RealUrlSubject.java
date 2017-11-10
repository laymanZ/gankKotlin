package com.example.hp.gankkotlin.dynamic;


public class RealUrlSubject implements UrlSubject {

    @Override
    public Object getBaseUrl(String key) {
        return BaseUrlCache.INSTANCE.getCache().get(key);
    }
}
