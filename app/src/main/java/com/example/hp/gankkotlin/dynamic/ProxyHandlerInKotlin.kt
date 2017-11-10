package com.example.hp.gankkotlin.dynamic

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy


class ProxyHandlerInKotlin : InvocationHandler {

    private var target: Any? = null
    private var cached = mutableMapOf<String, Any>()


    private fun bind(target: Any): Any {
        this.target = target
        return Proxy.newProxyInstance(target::class.java.classLoader,
                target::class.java.interfaces,
                this)
    }

    override fun invoke(proxy: Any?, method: Method, args: Array<out Any>): Any {
        val types = method.typeParameters
        if (method.name matches Regex("get.+")
                && types.size == 1
                && types[0] == String::class.java) {
            val key = args[0].toString()
            var value = cached[key]
            if (value == null) {
                value = method.invoke(target, args)
                cached.put(key, value)
            }
            return value!!
        }
        return method.invoke(target, args)
    }
}