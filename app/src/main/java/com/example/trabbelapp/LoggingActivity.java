package com.example.trabbelapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trabbelapp.services.FirebaseService;
import com.example.trabbelapp.utils.PreferenceShareTools;
import com.example.trabbelapp.utils.ViewTools;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.atomic.AtomicInteger;

public class LoggingActivity extends AppCompatActivity {

    private final String TAG = "LoggingActivity";
    FirebaseService firebaseService;
    EditText emailUser;
    EditText passwordUser;
    PreferenceShareTools preferenceShareTools;
    String email;
    String password;
    ViewTools viewTools;
    AtomicInteger statusCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewTools = new ViewTools();
        preferenceShareTools = new PreferenceShareTools(this);
        firebaseService = new FirebaseService(this, TAG);

        viewTools.hideSystemUI(getWindow().getDecorView());

        emailUser = null;
        passwordUser = null;

        // Comprobar que no hay usuario registrado
        email = preferenceShareTools.getString("emailUser");
        password = preferenceShareTools.getString("passwordUser");
        Log.e(TAG, "InitialSP: " + email + " - "  + password);

        if (email.isEmpty() || password.isEmpty()){
            Log.w(TAG, "sharepreference: no");
            setContentView(R.layout.activity_logging);
        }
        else {
            Log.w(TAG, "sharepreference: yes");
            viewTools.changeView(this, HomeActivity.class);
        }

    }

    public void  logIn(View v){

        emailUser = findViewById(R.id.loggingEmailInput);
        passwordUser = findViewById(R.id.loggingPasswordInput);

        email = emailUser.getText().toString();
        password = passwordUser.getText().toString();

        firebaseService.loggingFirebase(email, password);

        emailUser.setHint("Re-enter your email");
        emailUser.setText("");
        passwordUser.setHint("Re-enter your password");
        passwordUser.setText("");
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = firebaseService.getmAuth().getCurrentUser();
        if(currentUser != null){
            Log.w(TAG, "currentUser: logged");
        }
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