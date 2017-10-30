package com.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class ActivityDetail extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String url = (String) intent.getExtras().get("url");
        WebView webView = (WebView) findViewById(R.id.web);
        webView.loadUrl(url);
    }



}
