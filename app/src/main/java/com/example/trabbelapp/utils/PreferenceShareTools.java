package com.example.trabbelapp.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceShareTools {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public PreferenceShareTools(Activity activity) {
        sharedPreferences = activity.getPreferences(Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setString(String key, String value){
        editor.putString(key, value);
        editor.apply();
    }
    public void setInt(String key, int value){
        editor.putInt(key, value);
        editor.apply();
    }

    public void deletePreference(String key){
        editor.remove(key);
    }

    public String getString(String key){
        return sharedPreferences.getString(key, "");
    }
    public int getInt(String key){
        return sharedPreferences.getInt(key, 0);
    }

}
