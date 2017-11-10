package com.example.recyclerview;

import android.app.Activity;
import android.content.Intent;
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
    private ArrayList<SourceChoiceItem> sources = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private SourceChoiceAdapter mAdapter;
    private SharedPreferencesHelper prefsHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source_choice);
        setTitle(getString(R.string.sources_title));
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }

        prefsHelper = SharedPreferencesHelper.getInstance(SourceChooseActivity.this);
        mRecyclerView = findViewById(R.id.sources_recycler_view);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        sources = convertToSourceChoiceItems(getIntent().getStringArrayListExtra(getString(R.string.EXTRA_sources_list_name)));
        mAdapter = new SourceChoiceAdapter(sources);
        mRecyclerView.setAdapter(mAdapter);
    }

    private ArrayList<SourceChoiceItem> convertToSourceChoiceItems(ArrayList<String> sources) {
        ArrayList<SourceChoiceItem> ret = new ArrayList<>();
        for (String source : sources) {
            ret.add(new SourceChoiceItem(source, prefsHelper.isChosen(source)));
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

                for (SourceChoiceItem source: sources) {
                    prefsHelper.addBoolean(source.getName(),source.getAllowed());
                }

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
