package com.example.trabbelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trabbelapp.utils.PreferenceShareTools;
import com.example.trabbelapp.utils.ViewTools;

public class Settings extends AppCompatActivity {

    PreferenceShareTools preferenceShareTools;
    EditText latitudInput;
    EditText longitudInput;
    Button saveButton;
    ViewTools viewTools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        preferenceShareTools = new PreferenceShareTools(this);
        viewTools = new ViewTools();

        latitudInput = findViewById(R.id.settingLatitudInput);
        longitudInput = findViewById(R.id.settingLongitudInput);

        saveButton = findViewById(R.id.settingButton);
        saveButton.setOnClickListener(view -> saveChangeSettings());

        findViewById(R.id.sectionBackButton).setOnClickListener(view -> viewTools.changeView(this, HomeActivity.class));

    }

    private void saveChangeSettings(){
        if (!longitudInput.getText().toString().equals("")) {
            preferenceShareTools.setString("lng", longitudInput.getText().toString());
            preferenceShareTools.setString("lat", latitudInput.getText().toString());
            preferenceShareTools.setString("setLocation", "true");
            Toast.makeText(this, "Localizacion guardada!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Localizacion vacia!", Toast.LENGTH_SHORT).show();
            preferenceShareTools.setString("setLocation", "false");
        }
        viewTools.changeView(this,HomeActivity.class);
    }
}