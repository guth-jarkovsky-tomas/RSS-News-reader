package com.example.recyclerview;

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

    void retrofitFun(final Context context) {


        IPImporter imp = retrofit.create(IPImporter.class);
        Call<IPJson> call = imp.ip_adress();
        call.enqueue(new Callback<IPJson>() {
            @Override
            public void onResponse(Call<IPJson> call, Response<IPJson> response) {
                IPJson ipAdresses = response.body();
                if (ipAdresses == null) {
                    return;
                }
                Toast.makeText(context, ipAdresses.ip, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<IPJson> call, Throwable t) {
                Log.e(TAG, "response error", t);
                Toast.makeText(context, "chyba bracho", Toast.LENGTH_LONG).show();
            }
        });
    }

}
