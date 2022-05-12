package com.example.trabbelapp;

import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trabbelapp.clients.FirebaseClient;
import com.example.trabbelapp.utils.PreferenceShareTools;
import com.example.trabbelapp.utils.ViewTools;
import com.google.firebase.auth.FirebaseUser;

public class LoggingActivity extends AppCompatActivity {

    private final String TAG = "LoggingActivity";
    FirebaseClient firebaseClient;
    EditText emailUser;
    EditText passwordUser;
    PreferenceShareTools preferenceShareTools;
    String email;
    String password;
    ViewTools viewTools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewTools = new ViewTools();
        preferenceShareTools = new PreferenceShareTools(this);
        firebaseClient = new FirebaseClient(this, TAG);

        viewTools.hideSystemUI(getWindow().getDecorView());

        findViewById(R.id.loggingLogInButton).setOnClickListener(view -> logIn());

        emailUser = null;
        passwordUser = null;

        // Comprobar que no hay usuario registrado
        email = preferenceShareTools.getString("emailUser");
        password = preferenceShareTools.getString("passwordUser");
        Log.e(TAG, "InitialSP: " + email + " - " + password);

        if (email.isEmpty() || password.isEmpty()) {
            Log.w(TAG, "sharepreference: no");
            setContentView(R.layout.activity_logging);
        } else {
            Log.w(TAG, "sharepreference: yes");
            viewTools.changeView(this, HomeActivity.class);
        }

    }


    public void logIn() {
        emailUser = findViewById(R.id.loggingEmailInput);
        passwordUser = findViewById(R.id.loggingPasswordInput);

        email = emailUser.getText().toString();
        password = passwordUser.getText().toString();

        firebaseClient.loggingFirebase(email, password);

        emailUser.setHint("Re-enter your email");
        emailUser.setText("");
        passwordUser.setHint("Re-enter your password");
        passwordUser.setText("");
        viewTools.hideSystemUI(getWindow().getDecorView());
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = firebaseClient.getmAuth().getCurrentUser();
        if (currentUser != null) {
            Log.w(TAG, "currentUser: logged");
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "Destroy");
        finish();
    }
}