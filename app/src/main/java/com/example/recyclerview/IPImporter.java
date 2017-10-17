package com.example.recyclerview;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by TOMAS on 17.10.2017.
 */

public interface IPImporter {
    @GET("dummy")
    Call<IPJson> ip_adress();
}

