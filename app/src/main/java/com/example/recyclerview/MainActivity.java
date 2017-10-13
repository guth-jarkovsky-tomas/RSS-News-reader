package com.example.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter(createDataset());
        mRecyclerView.setAdapter(mAdapter);

        Toast.makeText(this,"Ahoj brambory!",Toast.LENGTH_LONG).show();
        Log.d("Main","Brambora double team");
    }

        private ArrayList<FeedItem> createDataset() {
            String url;
            ArrayList<FeedItem> myDataset =new ArrayList<>();
            for (int i = 0;i < 25; i++) {
                switch (i % 3) {
                    case 0: url = "http://i0.kym-cdn.com/photos/images/newsfeed/000/964/816/b7c.gif"; break;
                    case 1: url = "https://myanimelist.cdn-dena.com/r/360x360/images/characters/2/197117.jpg?s=4c675aa804c3b25d082761f337cb4e9c"; break;
                    case 2: url = "http://www.anime-planet.com/images/characters/potato-dono-13651.jpg"; break;
                    default: url = "https://myanimelist.cdn-dena.com/images/characters/13/57196.jpg";
                }
                if (i < 10) { url = "https://myanimelist.cdn-dena.com/images/characters/13/57196.jpg"; }
                myDataset.add(new FeedItem("Title number " + i, "Description number " +i,url,"URL number "+i ));
            }
            return myDataset;
        }

}