package com.example.trabbelapp.utils;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ViewTools {

    public ViewTools(){}

    public void hideSystemUI(View decorView){
        decorView.setSystemUiVisibility(deleteSystemUI());
        decorView.setOnSystemUiVisibilityChangeListener(
                visibility -> {
                    if (visibility == 0){
                        decorView.setSystemUiVisibility(deleteSystemUI());
                    }
                }
        );
    }

    public int deleteSystemUI(){
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
    }

    public void changeView(AppCompatActivity actualActivity, Class<?> activity){
        Intent intent = new Intent(actualActivity, activity);
        actualActivity.startActivity(intent);
    }

    public void setMessageToIntent(AppCompatActivity actualActivity, Class<?> activity, String message){
        Intent intent = new Intent(actualActivity, activity);
        intent.setData(Uri.parse(message));
        actualActivity.startActivity(intent);
    }

    public String getMessageFromIntent(AppCompatActivity actualActivity){
        Intent intent = actualActivity.getIntent();
        Uri uri = intent.getData();
        return uri.toString();
    }
}
