package com.example.recyclerview.Api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by TOMAS on 17.10.2017.
 */

public interface NewsImporter {

    @GET("/v1/articles")
    Call<NewsJson> news_article(@Query("source") String source, @Query("apikey") String API_key );

    @GET("/v1/sources")
    Call<SourcesJson> news_sources(@Query("language") String language);

}
