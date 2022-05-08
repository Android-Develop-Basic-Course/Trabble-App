package com.example.trabbelapp;


import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trabbelapp.models.User;
import com.example.trabbelapp.services.FirebaseService;
import com.example.trabbelapp.utils.ViewTools;
import com.google.firebase.auth.FirebaseUser;

public class LoggingActivity extends AppCompatActivity {

    private final String TAG = "LoggingActivity";
    FirebaseService firebaseService;
    TextView emailUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logging);

        ViewTools viewTools = new ViewTools();
        viewTools.hideSystemUI(getWindow().getDecorView());

        // Remember to add data
        String email = "{EMAIL}";
        String password = "{PASSWORD}";

        firebaseService = new FirebaseService(this, TAG);
        firebaseService.loggingFirebase(email, password);
        User currentUser = firebaseService.getUser();
        emailUser = (TextView) findViewById(R.id.emailUser);
        emailUser.setText(currentUser.getEmail());
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = firebaseService.getmAuth().getCurrentUser();
        if(currentUser != null){
            Log.w(TAG, "signInWithEmail: continue");
        }
        else {
            Log.e(TAG, "signInWithEmail: continue failure");
        }
    }
}