package com.sun.dailyprj;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

/*
 * =====================================================================================
 * Summary:
 *
 * File: WebViewActivity.java
 * Author: Yanpeng.Sun
 * Create: 2019/4/26 18:02
 * =====================================================================================
 */
public class WebViewActivity extends AppCompatActivity{

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        webView = findViewById(R.id.webView);
        Intent intent = getIntent();
        if(intent.hasExtra(Constant.KEY_WEB_URL)){
            init(intent.getStringExtra(Constant.KEY_WEB_URL));
        }else
            finish();
    }

    private void init(String url){
        webView.loadUrl(url);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
    }
}
