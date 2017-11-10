package com.example.hp.gankkotlin.util;


import android.content.Context;
import android.os.Build;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewUtilOfJava {


    private static WebViewUtilOfJava webViewUtilOfJava;
    private WebView mWebView;

    public static WebViewUtilOfJava getInstance() {
        if (webViewUtilOfJava == null) {
            synchronized (WebViewUtilOfJava.class) {
                if (webViewUtilOfJava == null) {
                    webViewUtilOfJava = new WebViewUtilOfJava();
                }
            }
        }
        return webViewUtilOfJava;
    }

    private void initWebView(Context context) {
        if (mWebView == null) {
            mWebView = new WebView(context);
        }
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setPluginState(WebSettings.PluginState.ON);
        webSettings.setUseWideViewPort(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setSupportZoom(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                mWebView.loadUrl(url);
                return true;
            }
        });

        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public View getVideoLoadingProgressView() {
                return super.getVideoLoadingProgressView();
            }

            @Override
            public void onShowCustomView(View view, CustomViewCallback callback) {
                super.onShowCustomView(view, callback);
            }

            @Override
            public void onHideCustomView() {
                super.onHideCustomView();
            }
        });
    }

    public void play(Context context, String url) {
        initWebView(context);
        mWebView.loadUrl(url);
    }

}
