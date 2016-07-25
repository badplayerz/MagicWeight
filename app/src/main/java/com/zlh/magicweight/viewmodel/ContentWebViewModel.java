package com.zlh.magicweight.viewmodel;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zlh.magicweight.interf.ContentWebInterf;

/**
 * Created by sdbean-zlh on 16/7/7.
 */
public class ContentWebViewModel implements ContentWebInterf.MainView{

    private String webUrl;

    public String getWebUrl() {
        return webUrl;
    }

    public ContentWebViewModel(String url) {
        webUrl = url;
    }

    @BindingAdapter({"webLoadUrl"})
    public static void loadWebView(WebView webView, String url){
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    public Context getContext() {
        return null;
    }
}
