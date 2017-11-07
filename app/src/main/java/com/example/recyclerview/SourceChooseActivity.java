package com.example.recyclerview;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.recyclerview.RecyclerViewStuff.SourceChoiceAdapter;
import com.example.recyclerview.RecyclerViewStuff.SourceChoiceItem;

import java.util.ArrayList;

public class SourceChooseActivity extends AppCompatActivity {

    ArrayList<SourceChoiceItem> sources = new ArrayList<>();
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    SourceChoiceAdapter mAdapter;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source_choice);
        setTitle(getString(R.string.sources_title));
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }

        mRecyclerView = findViewById(R.id.sources_recycler_view);
        prefs = getSharedPreferences("SourcesAllowance", MODE_PRIVATE);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        sources = convertToSourceChoiceItems(getIntent().getStringArrayListExtra("sourcesList"));
        mAdapter = new SourceChoiceAdapter(sources);
        mRecyclerView.setAdapter(mAdapter);
    }

    ArrayList<SourceChoiceItem> convertToSourceChoiceItems(ArrayList<String> sources) {
        ArrayList<SourceChoiceItem> ret = new ArrayList<>();
        for (String source : sources) {
            ret.add(new SourceChoiceItem(source, prefs.getBoolean(source, true)));
        }
        return ret;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save_sources, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_save:
                Intent saveIntent = new Intent(this,MainActivity.class);
                editor = prefs.edit();
                for (SourceChoiceItem source: sources) {
                    editor.putBoolean(source.getName(),source.getAllowed());
                }
                editor.apply();
                startActivity(saveIntent);
                return true;

            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
