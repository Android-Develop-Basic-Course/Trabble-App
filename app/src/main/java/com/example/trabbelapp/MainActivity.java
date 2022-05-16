package com.example.trabbelapp;


import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.trabbelapp.clients.TokenClient;
import com.example.trabbelapp.utils.Geo;
import com.example.trabbelapp.utils.PreferenceShareTools;
import com.example.trabbelapp.utils.ViewTools;

import io.reactivex.annotations.NonNull;

public class MainActivity extends AppCompatActivity implements LocationListener {

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
        /*
         Eliminamos todos el sistema UI del movil que no se necesita
         de esta manera tenemos el sistema en pantalla completa
        */
        viewTools.hideSystemUI(getWindow().getDecorView());

    }

    @Override
    public void onLocationChanged(Location location){
        if(preferenceShareTools.getString("setLocation").equals("false"))
            Geo.locationChange(this, location);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new TokenClient(this);
        /*
         De esta manera mostraremos la pagina de inicio al usuario
         presentandole la app, cual es su nombre y su branding
        */
        new Thread(() -> {
            try {
                // Realizamos una espera de 2000, todo: posteriormente en este tiempo habra que cargar el api token
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            viewTools.changeView(this, LoggingActivity.class);
        }
        ).start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Logging", "Destroy");
        finish();
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

    @Override
    public void onProviderEnabled(@NonNull String provider) {

    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }
}