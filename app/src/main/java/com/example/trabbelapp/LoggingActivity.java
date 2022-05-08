package com.example.trabbelapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.trabbelapp.utils.ViewTools;

public class LoggingActivity extends AppCompatActivity {
    ViewTools viewTools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logging);
        viewTools = new ViewTools();

        /*
         Eliminamos todos el sistema UI del movil que no se necesita
         de esta manera tenemos el sistema en pantalla completa
        */
        viewTools.hideSystemUI(getWindow().getDecorView());
    }
}