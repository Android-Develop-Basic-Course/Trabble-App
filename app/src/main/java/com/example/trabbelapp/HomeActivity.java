package com.example.trabbelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.trabbelapp.clients.ActivitiesClient;
import com.example.trabbelapp.clients.TokenClient;
import com.example.trabbelapp.models.Token;
import com.example.trabbelapp.clients.FirebaseClient;
import com.example.trabbelapp.utils.PreferenceShareTools;
import com.example.trabbelapp.utils.ViewTools;

public class HomeActivity extends AppCompatActivity {

    private final String TAG = "LoggingActivity";
    FirebaseClient firebaseClient;
    PreferenceShareTools preferenceShareTools;
    ViewTools viewTools;
    Token token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        preferenceShareTools = new PreferenceShareTools(this);
        firebaseClient = new FirebaseClient(this, TAG);
        viewTools = new ViewTools();

        viewTools.hideSystemUI(getWindow().getDecorView());
        token = new Token();
        token.setAccessToken(preferenceShareTools.getString("API_TOKEN"));
        Log.e("TOKEN-final", token.getAccessToken());

        ActivitiesClient activitiesClient = new ActivitiesClient(this);


    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "Destroy");
        //preferenceShareTools.setString("emailUser", "");
        //preferenceShareTools.setString("passwordUser", "");
        //firebaseService.signOutFirebase();
        finish();
    }
}