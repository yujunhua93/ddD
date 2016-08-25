package com.example.e450c.myapplicationdemo.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.e450c.myapplicationdemo.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Stack;

public class Main11Activity extends AppCompatActivity {

    private WebView wv;

    private ProgressBar progressBar;

    private Stack<Main11Activity> stacks;

    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);
        wv = (WebView) findViewById(R.id.wv);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        init();



    }

    private void init() {

        if (stacks == null){
            stacks = new Stack<Main11Activity>();
        }
        stacks.push(this);

        url = getIntent().getStringExtra("url");

        WebSettings websettings = wv.getSettings();
        websettings.setJavaScriptEnabled(true);
        websettings.setUseWideViewPort(true);
        websettings.setLoadWithOverviewMode(true);
        websettings.setAllowFileAccess(true);
        websettings.setSupportZoom(true);
        websettings.setLoadsImagesAutomatically(true);
        websettings.setCacheMode(websettings.LOAD_NO_CACHE);

        wv.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100){
                    progressBar.setVisibility(View.GONE);
                }
                progressBar.setProgress(newProgress);
            }



        });

        wv.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Intent intent= new Intent(Main11Activity.this,Main11Activity.class);
                intent.putExtra("url", url);
                startActivity(intent);
                return  true;
            }
        });

        if (null != url ){
            wv.loadUrl(url);
        }else{
            wv.loadUrl("https://www.baidu.com/");
        }




    }




}
