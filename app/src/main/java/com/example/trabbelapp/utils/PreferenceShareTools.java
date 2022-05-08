package com.example.trabbelapp.utils;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PreferenceShareTools {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public PreferenceShareTools(Activity activity) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);
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
