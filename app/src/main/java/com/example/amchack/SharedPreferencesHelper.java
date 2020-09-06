package com.example.amchack;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.RadioGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SharedPreferencesHelper {
    public static final String SHARED_PREF_NAME = "SHARED_PREF_NAME";
    public static final String USERS_CHOICE = "USERS_CHOICE";
    public static final Type USERS_TYPE = new TypeToken<String>() {
    }.getType();

    private SharedPreferences mSharedPreferences;
    private Gson mGson = new Gson();

    public SharedPreferencesHelper(Context context) {
        mSharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    public void saveChoice(String choice) {
        mSharedPreferences
                .edit()
                .putString(USERS_CHOICE, mGson.toJson(String.valueOf(choice), USERS_TYPE))
                .apply();
    }

    public String getChoice() {
        String choice = mGson.fromJson(mSharedPreferences.getString(USERS_CHOICE, ""), USERS_TYPE);
        return choice;
    }
}


