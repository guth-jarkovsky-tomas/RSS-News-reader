package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;


public class ActivityDetail extends AppCompatActivity  {

    static final private String ARG_URL = "url";
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }
        Intent intent = getIntent();
        url = (String) intent.getExtras().get(ARG_URL);
        WebView webView = (WebView) findViewById(R.id.web);
        webView.loadUrl(url);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_res, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            case R.id.menu_item_share:
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(Intent.EXTRA_TEXT,url);
                startActivity(sharingIntent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    static public void starter(String url,Context context) {
        Intent intent = new Intent(context, ActivityDetail.class);
        intent.putExtra(ARG_URL,url);
        context.startActivity(intent);
    }




}
