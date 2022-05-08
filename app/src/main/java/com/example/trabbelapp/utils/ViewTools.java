package com.example.trabbelapp.utils;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trabbelapp.MainActivity;

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

    public void changeView(MainActivity actualActivity, Class<?> activity){
        Intent intent = new Intent(actualActivity, activity);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        actualActivity.startActivity(intent);
        actualActivity.finish();
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
