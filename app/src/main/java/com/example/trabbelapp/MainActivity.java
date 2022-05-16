package com.example.trabbelapp;


import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.trabbelapp.clients.TokenClient;
import com.example.trabbelapp.utils.PreferenceShareTools;
import com.example.trabbelapp.utils.ViewTools;

public class MainActivity extends AppCompatActivity {

    ViewTools viewTools;
    PreferenceShareTools preferenceShareTools;
    ImageView logoPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        preferenceShareTools = new PreferenceShareTools(this);
        viewTools = new ViewTools();
        themeMode();
        /*
         Eliminamos todos el sistema UI del movil que no se necesita
         de esta manera tenemos el sistema en pantalla completa
        */
        viewTools.hideSystemUI(getWindow().getDecorView());

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
}