package com.example.recyclerview;

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

    ArrayList<SourceChoiceItem> sources = new ArrayList<>();;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    SourceChoiceAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source_choice);
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }
        setTitle("From where");

        mRecyclerView = findViewById(R.id.sources_recycler_view);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        sources = convertToSourceChoiceItems(getIntent().getStringArrayListExtra("sourcesList"));

        mAdapter = new SourceChoiceAdapter(sources);
        mRecyclerView.setAdapter(mAdapter);
    }

    ArrayList<SourceChoiceItem> convertToSourceChoiceItems(ArrayList<String> sources) {
        ArrayList<SourceChoiceItem> ret = new ArrayList<>();
        for (String source:sources ) {
            ret.add(new SourceChoiceItem(source,true));
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
                saveIntent.putStringArrayListExtra("sourcesList",transformToOutputSources(sources));
                startActivity(saveIntent);
                return true;

            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<String> transformToOutputSources(ArrayList<SourceChoiceItem> sources) { //THIS needs to work
        ArrayList<String> ret = new ArrayList<>();

        return ret;
    }


    //TODO switching switches should change the sources array


}
