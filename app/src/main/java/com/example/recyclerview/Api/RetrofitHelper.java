package com.example.recyclerview.Api;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;
import static com.example.recyclerview.MainActivity.API_URL;

/**
 * Created by TOMAS on 17.10.2017.
 */

public class RetrofitHelper {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    String APIKEY = "6088427f16e14eb1923a64828952d8aa";
    NewsJson allTheNews;


    public void readArticles(final Context context) {
        NewsImporter hlasatel = retrofit.create(NewsImporter.class);
        Call<NewsJson> call = hlasatel.news_article("techcrunch",APIKEY);

        call.enqueue(new Callback<NewsJson>() {
            @Override
            public void onResponse(Call<NewsJson> call, Response<NewsJson> response) {
                allTheNews = new NewsJson(response.body());
                if (allTheNews== null) {
                    return;
                }
                Toast.makeText(context, allTheNews.source, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<NewsJson> call, Throwable t) {
                Log.e(TAG, "response error", t);
                Toast.makeText(context, "chyba bracho", Toast.LENGTH_LONG).show();
            }
        });

    }

    public NewsJson getAllTheNews() {
        return allTheNews;
    }
}


