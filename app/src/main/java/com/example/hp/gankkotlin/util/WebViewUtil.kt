package com.example.hp.gankkotlin.util

import android.content.Context
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient


object WebViewUtil {

    private lateinit var mContext: Context

    private val mWV by lazy {
        WebView(mContext)
    }

    private val mWVSettings by lazy {
        mWV.settings
    }

    fun initWebViewUtil(context: Context): WebViewUtil {
        mContext = context
        initWebView()
        return this
    }

    fun play(url: String) {

    }

    private fun initWebView() {
        mWVSettings.defaultTextEncodingName = "utf-8"
        mWVSettings.javaScriptEnabled = true
        mWVSettings.domStorageEnabled = true
        mWV.webChromeClient = WebChromeClient()
        mWV.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url!!.startsWith("intent") || url.startsWith("youku")) {
                    return true
                } else {
                    return super.shouldOverrideUrlLoading(view, url)
                }
            }
        }
    }
}