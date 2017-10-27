package com.example.recyclerview.Api;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.recyclerview.MainActivity.API_URL;

/**
 * Created by TOMAS on 17.10.2017.
 */

public class RetrofitHelper {

    private static RetrofitHelper instance = null;
    private String APIKEY = "6088427f16e14eb1923a64828952d8aa";
    private NewsJson allTheNews;
    private NewsImporter hlasatel;
    private Retrofit retrofit;


    private RetrofitHelper() {
        retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        hlasatel = retrofit.create(NewsImporter.class);
    }

    public static RetrofitHelper getInstance() {
        if (instance == null) {
            return new  RetrofitHelper();
        }
        else
        {
            return instance;
        }
    }

    public NewsImporter getNewsImporter() {
        return hlasatel;
    }

    public Call<NewsJson> getNewsCall(String source) {
        return hlasatel.news_article(source,APIKEY);
    }

    public NewsJson getAllTheNews() {
        return allTheNews;
    }
}


