package com.example.trabbelapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.trabbelapp.utils.ViewTools;

public class MainActivity extends AppCompatActivity {

    ViewTools viewTools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewTools = new ViewTools();

        /*
         Eliminamos todos el sistema UI del movil que no se necesita
         de esta manera tenemos el sistema en pantalla completa
        */
        viewTools.hideSystemUI(getWindow().getDecorView());

    }

    @Override
    protected void onResume() {
        super.onResume();
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
}