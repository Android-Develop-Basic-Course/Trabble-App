package com.example.trabbelapp.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class ViewTools {

    public ViewTools() {
    }

    public void hideSystemUI(View decorView) {
        int uiOptions = decorView.getSystemUiVisibility();
        int newUiOptions = uiOptions;
        newUiOptions |= View.SYSTEM_UI_FLAG_LOW_PROFILE;
        newUiOptions |= View.SYSTEM_UI_FLAG_FULLSCREEN;
        newUiOptions |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        newUiOptions |= View.SYSTEM_UI_FLAG_IMMERSIVE;
        newUiOptions |= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(newUiOptions);
    }

    public void showSystemUI(View decorView) {
        int uiOptions = decorView.getSystemUiVisibility();
        int newUiOptions = uiOptions;
        newUiOptions &= ~View.SYSTEM_UI_FLAG_LOW_PROFILE;
        newUiOptions &= ~View.SYSTEM_UI_FLAG_FULLSCREEN;
        newUiOptions &= ~View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        newUiOptions &= ~View.SYSTEM_UI_FLAG_IMMERSIVE;
        newUiOptions &= ~View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(newUiOptions);
    }

    public void changeView(Activity actualActivity, Class<?> activity) {
        Intent intent = new Intent(actualActivity, activity);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        actualActivity.startActivity(intent);
        actualActivity.finish();
    }

    public void sendStringMessageToIntent(AppCompatActivity actualActivity, Class<?> activity, String message) {
        Intent intent = new Intent(actualActivity, activity);
        intent.setData(Uri.parse(message));
        actualActivity.startActivity(intent);
    }

    public String reciveStringMessageFromIntent(AppCompatActivity actualActivity) {
        Intent intent = actualActivity.getIntent();
        Uri uri = intent.getData();
        return uri.toString();
    }

    public void sendSerializableMessageToIntent(Activity actualActivity, Class<?> activity, String name_message, Parcelable message) {
        Intent intent = new Intent(actualActivity, activity);
        intent.putExtra(name_message, message);
        actualActivity.startActivity(intent);
    }

    public Parcelable reciveSerializableMessageFromIntent(Activity actualActivity, String name_message) {
        Intent intent = actualActivity.getIntent();
        return intent.getParcelableExtra(name_message);
    }
}