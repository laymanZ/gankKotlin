package com.example.hp.gankkotlin.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;


public class ProxyHandler implements InvocationHandler {

    private Object target;
    private Map<String, Object> cached = new HashMap<>();


    private ProxyHandler() {
    }

    public String getBaseUrl(String key) {
        return String.valueOf(((UrlSubject) bind(new RealUrlSubject())).getBaseUrl(key));
    }

    public static ProxyHandler getInstance() {
        return ProxyHolder.proxyHandler;
    }

    private static class ProxyHolder {
        private static final ProxyHandler proxyHandler = new ProxyHandler();
    }


    private Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Type[] types = method.getTypeParameters();
        if (method.getName().matches("get.+")
                && types.length == 1
                && types[0] == String.class) {
            String key = (String) args[0];
            Object value = cached.get(key);
            if (value == null) {
                value = method.invoke(target, args);
                cached.put(key, value);
            }
            return value;
        }
        return method.invoke(target, args);
    }
}
