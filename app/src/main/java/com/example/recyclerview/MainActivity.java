package com.example.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.recyclerview.Api.Article;
import com.example.recyclerview.Api.NewsJson;
import com.example.recyclerview.Api.RetrofitHelper;
import com.example.recyclerview.Api.Source;
import com.example.recyclerview.Api.SourcesJson;
import com.example.recyclerview.RecyclerViewStuff.FeedItem;
import com.example.recyclerview.RecyclerViewStuff.MyAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<FeedItem> mArticleList = new ArrayList<>();
    private ArrayList<Source> mSourcesList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("News");
        mRecyclerView = findViewById(R.id.my_recycler_view);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter(mArticleList);
        mRecyclerView.setAdapter(mAdapter);

        startNetworkRequest_sources("en");

    }

    private void startNetworkRequest_sources(String language) {
        Call<SourcesJson> call = RetrofitHelper.getInstance().getSourcesCall(language);
        call.enqueue(new Callback<SourcesJson>() {
            @Override
            public void onResponse(Call<SourcesJson> call, Response<SourcesJson> response) {
                SourcesJson allTheSources = new SourcesJson(response.body());
                mSourcesList = allTheSources.getSources();
                mAdapter.notifyDataSetChanged();
                for (Source source: mSourcesList) {
                    startNetworkRequest_news(source.getName());
                }
            }

            @Override
            public void onFailure(Call<SourcesJson> call, Throwable t) {
                Log.e(TAG, "response error", t);
                Toast.makeText(MainActivity.this, "chyba bracho", Toast.LENGTH_LONG).show();
            }
        });
    }


    private void startNetworkRequest_news(String articleSource) {
        Call<NewsJson> call = RetrofitHelper.getInstance().getNewsCall(articleSource);
        call.enqueue(new Callback<NewsJson>() {
            @Override
            public void onResponse(Call<NewsJson> call, Response<NewsJson> response) {
                if (response.body() != null) {
                    NewsJson allTheNews = new NewsJson(response.body());
                    mArticleList.addAll(createDataset(allTheNews));
                    mAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<NewsJson> call, Throwable t) {
                Log.e(TAG, "response error", t);
                Toast.makeText(MainActivity.this, "chyba bracho2", Toast.LENGTH_LONG).show();
            }
        });

    }
    private ArrayList<FeedItem> createDataset(NewsJson json) {

        ArrayList<Article> articles = json.getArticles();
        Article articleNow;
        ArrayList<FeedItem> myDataset = new ArrayList<>();

        for (int i = 0; i < articles.size(); i++) {
            articleNow = articles.get(i);
            myDataset.add(new FeedItem(json.getSource(),articleNow.getTitle(),articleNow.getDescription(),articleNow.getUrlToImage(),articleNow.getURL()));
        }
        return myDataset;
    }
}

