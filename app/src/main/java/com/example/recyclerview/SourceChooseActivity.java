package com.example.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.recyclerview.RecyclerViewStuff.SourceChoiceAdapter;
import com.example.recyclerview.RecyclerViewStuff.SourceChoiceItem;

import java.util.ArrayList;

public class SourceChooseActivity extends AppCompatActivity {

    ArrayList<String> sources = new ArrayList<>();;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    SourceChoiceAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source_choice);
        setTitle("From where");

        mRecyclerView = findViewById(R.id.sources_recycler_view);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        sources = getIntent().getStringArrayListExtra("sourcesList");

        mAdapter = new SourceChoiceAdapter(convertToSourceChoiceItems(sources));
        mRecyclerView.setAdapter(mAdapter);
    }

    ArrayList<SourceChoiceItem> convertToSourceChoiceItems(ArrayList<String> sources) {
        ArrayList<SourceChoiceItem> ret = new ArrayList<>();
        for (String source:sources ) {
            ret.add(new SourceChoiceItem(source,true));
        }
        return ret;
    }


}
