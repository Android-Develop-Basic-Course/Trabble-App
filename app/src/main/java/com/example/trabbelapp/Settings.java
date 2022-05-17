package com.example.trabbelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trabbelapp.clients.FirebaseClient;
import com.example.trabbelapp.utils.PreferenceShareTools;
import com.example.trabbelapp.utils.ViewTools;
import com.google.firebase.auth.FirebaseUser;

public class Settings extends AppCompatActivity {

    PreferenceShareTools preferenceShareTools;
    EditText latitudInput;
    EditText longitudInput;
    EditText nameInput;
    EditText urlImageInput;
    Button saveButton;
    ViewTools viewTools;
    FirebaseClient firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        preferenceShareTools = new PreferenceShareTools(this);
        viewTools = new ViewTools();
        firebase = new FirebaseClient(this, "Settings");

        latitudInput = findViewById(R.id.settingLatitudInput);
        longitudInput = findViewById(R.id.settingLongitudInput);
        nameInput = findViewById(R.id.settingNameInput);
        urlImageInput = findViewById(R.id.settingURLImageInput);

        String lat = preferenceShareTools.getString("lat");
        String lng = preferenceShareTools.getString("lng");
        if(!lat.isEmpty() && !lng.isEmpty()){
            latitudInput.setText(lat);
            longitudInput.setText(lng);
        }

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
        if(!nameInput.getText().toString().equals("")){
            String name = nameInput.getText().toString();
            preferenceShareTools.setString("nameUser", name);
            Log.e("IMAGE INPUT ", urlImageInput.getText().toString());
            if(!urlImageInput.getText().toString().equals(""))
                firebase.changeProfile(firebase.getmAuth().getCurrentUser(), name, urlImageInput.getText().toString());
            else
                firebase.changeProfile(firebase.getmAuth().getCurrentUser(), name, null);
            Toast.makeText(this, "Perfil guardado!", Toast.LENGTH_SHORT).show();
        }
        viewTools.changeView(this,HomeActivity.class);
    }
}