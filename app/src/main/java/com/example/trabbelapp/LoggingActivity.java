package com.example.trabbelapp;


import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.example.trabbelapp.services.FirebaseService;
import com.example.trabbelapp.utils.ViewTools;
import com.google.firebase.auth.FirebaseUser;

public class LoggingActivity extends AppCompatActivity {

    private final String TAG = "LoggingActivity";
    FirebaseService firebaseService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logging);

        ViewTools viewTools = new ViewTools();
        viewTools.hideSystemUI(getWindow().getDecorView());

        String email = "pruebas@gmail.com";
        String password = "pruebas";
        firebaseService = new FirebaseService(this, TAG);
        firebaseService.loggingFirebase(email, password);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = firebaseService.getmAuth().getCurrentUser();
        if(currentUser != null){
            Log.e(TAG, "signInWithEmail:continue failure");
        }
        else {
            Log.w(TAG, "signInWithEmail:continue");
        }
    }
}