package com.example.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.recyclerview.Api.NewsJson;
import com.example.recyclerview.Api.RetrofitHelper;
import com.example.recyclerview.RecyclerViewStuff.FeedItem;
import com.example.recyclerview.RecyclerViewStuff.MyAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static final String API_URL = "https://newsapi.org/";
    private ArrayList<FeedItem> mArticleList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter(mArticleList);
        mRecyclerView.setAdapter(mAdapter);

        startNetworkRequest("techcrunch");

    }

    private void startNetworkRequest(String articleSource) {
        Call<NewsJson> call = RetrofitHelper.getInstance().getNewsCall(articleSource);
        call.enqueue(new Callback<NewsJson>() {
            @Override
            public void onResponse(Call<NewsJson> call, Response<NewsJson> response) {
                NewsJson allTheNews = new NewsJson(response.body());
                Toast.makeText(MainActivity.this, allTheNews.getSource(), Toast.LENGTH_LONG).show();

                mArticleList.addAll(createDataset(allTheNews));
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<NewsJson> call, Throwable t) {
                Log.e(TAG, "response error", t);
                Toast.makeText(MainActivity.this, "chyba bracho", Toast.LENGTH_LONG).show();
            }

        });

    }

    private ArrayList<FeedItem> createDataset(NewsJson json) {

        ArrayList<Article> articles = json.getArticles();
        Article articleNow;
        ArrayList<FeedItem> myDataset = new ArrayList<>();

        for (int i = 0; i < articles.size(); i++) {
            articleNow = articles.get(i);
            myDataset.add(new FeedItem(articleNow.getTitle(),articleNow.getDescription(),articleNow.getUrlToImage(),articleNow.getTitle()));
        }

        return myDataset;
    }
}

