package com.example.recyclerview;

import android.app.Activity;
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

    public static final int REQUEST_CODE_CHOOSE_SOURCE = 99;
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

        prefs = getSharedPreferences(getString(R.string.shared_preferences_filename_sources),MODE_PRIVATE);
        mRecyclerView = findViewById(R.id.sources_recycler_view);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        sources = convertToSourceChoiceItems(getIntent().getStringArrayListExtra(getString(R.string.EXTRA_sources_list_name)));
        mAdapter = new SourceChoiceAdapter(sources);
        mRecyclerView.setAdapter(mAdapter);
    }

    ArrayList<SourceChoiceItem> convertToSourceChoiceItems(ArrayList<String> sources) {
        ArrayList<SourceChoiceItem> ret = new ArrayList<>();
        for (String source : sources) {
            ret.add(new SourceChoiceItem(source, prefs.getBoolean(source,true)));
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
                editor = prefs.edit();
                for (SourceChoiceItem source: sources) {
                    editor.putBoolean(source.getName(),source.getAllowed());
                }
                editor.apply();
                setResult(Activity.RESULT_OK);
                finish();
                return true;

            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    static public void starter(Activity activity, ArrayList<String> sources) {
        Intent choiceIntent = new Intent(activity,SourceChooseActivity.class);
        choiceIntent.putStringArrayListExtra(activity.getString(R.string.EXTRA_sources_list_name),sources);
        activity.startActivityForResult(choiceIntent, REQUEST_CODE_CHOOSE_SOURCE);
    }
}
