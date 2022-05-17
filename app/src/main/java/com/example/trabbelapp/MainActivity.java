package com.example.trabbelapp;


import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.trabbelapp.clients.TokenClient;
import com.example.trabbelapp.utils.Geo;
import com.example.trabbelapp.utils.PreferenceShareTools;
import com.example.trabbelapp.utils.ViewTools;

import io.reactivex.annotations.NonNull;

public class MainActivity extends AppCompatActivity {

    ViewTools viewTools;
    PreferenceShareTools preferenceShareTools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferenceShareTools = new PreferenceShareTools(this);
        viewTools = new ViewTools();
        Geo.getLocationByGPS(this);
        themeMode();
        if(preferenceShareTools.getString("lng").isEmpty())
            Geo.locationLastLocation(this);
        /*
         Eliminamos todos el sistema UI del movil que no se necesita
         de esta manera tenemos el sistema en pantalla completa
        */
        viewTools.hideSystemUI(getWindow().getDecorView());
        new Handler().postDelayed(this::process, 3000);
    }

    private void process(){
        new TokenClient(this);
        viewTools.changeView(this, LoggingActivity.class);
    }

    @Override
    protected void onStop() {
        super.onStop();
        viewTools.hideSystemUI(getWindow().getDecorView());
    }

    public void themeMode(){
        System.err.println("themeMode");
        String mode = preferenceShareTools.getString("themeMode");
        if (mode.isEmpty() || mode.equals("light")){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        }
        else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
    }
}