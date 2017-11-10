package com.example.recyclerview.Api;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by TOMAS on 17.10.2017.
 */

public class RetrofitHelper {

    private static RetrofitHelper instance = null;
    private static final String APIKEY = "6088427f16e14eb1923a64828952d8aa";
    private NewsImporter importer;
    private static final String API_URL = "https://newsapi.org/v1/";

    private RetrofitHelper() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        importer = retrofit.create(NewsImporter.class);
    }

    public static RetrofitHelper getInstance() {
        if (instance == null) {
            return new RetrofitHelper();
        } else {
            return instance;
        }
    }

    public Call<NewsJson> getNewsCall(String source) {
        return importer.news_article(source, APIKEY);
    }
    public Call<SourcesJson> getSourcesCall(String language) {
        return importer.news_sources(language);
    }
}


