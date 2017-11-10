package com.example.recyclerview;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by TOMAS on 10.11.2017.
 */

public class SharedPreferencesHelper {
    private static SharedPreferencesHelper instance;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;


    private SharedPreferencesHelper(Context context) {
        prefs = context.getSharedPreferences(context.getString(R.string.shared_preferences_filename_sources), MODE_PRIVATE);
    }

    public static SharedPreferencesHelper getInstance(Context context) {
        if (instance == null) {
            return new SharedPreferencesHelper(context);
        } else {
            return instance;
        }
    }

    boolean isChosen(String name) {
        return prefs.getBoolean(name,true);
    }

    void addBoolean(String name, Boolean value) {
        editor = prefs.edit();
        editor.putBoolean(name,value);
        editor.apply();
    }

}
