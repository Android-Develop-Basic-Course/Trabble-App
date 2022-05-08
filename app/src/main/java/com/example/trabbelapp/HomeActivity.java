package com.example.trabbelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.example.trabbelapp.services.FirebaseService;
import com.example.trabbelapp.utils.PreferenceShareTools;
import com.example.trabbelapp.utils.ViewTools;

public class HomeActivity extends AppCompatActivity {

    private final String TAG = "LoggingActivity";
    FirebaseService firebaseService;
    PreferenceShareTools preferenceShareTools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        preferenceShareTools = new PreferenceShareTools(this);
        firebaseService = new FirebaseService(this, TAG);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "Destroy");
        preferenceShareTools.setString("emailUser", "");
        preferenceShareTools.setString("passwordUser", "");
        firebaseService.signOutFirebase();
        finish();
    }
}