package com.example.trabbelapp;

import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.trabbelapp.clients.FirebaseClient;
import com.example.trabbelapp.utils.PreferenceShareTools;
import com.example.trabbelapp.utils.ViewTools;
import com.google.firebase.auth.FirebaseUser;

public class LoggingActivity extends AppCompatActivity {

    private final String TAG = "Logging Activity";
    FirebaseClient firebaseClient;
    EditText emailUser;
    EditText passwordUser;
    PreferenceShareTools preferenceShareTools;
    String email;
    String password;
    ViewTools viewTools;
    Button visibilityPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewTools = new ViewTools();
        preferenceShareTools = new PreferenceShareTools(this);
        firebaseClient = new FirebaseClient(this, TAG);
        viewTools.hideSystemUI(getWindow().getDecorView());
        emailUser = null;
        passwordUser = null;

        // Comprobar que no hay usuario registrado
        email = preferenceShareTools.getString("emailUser");
        password = preferenceShareTools.getString("passwordUser");
        Log.e(TAG, "InitialSP: " + email + " - " + password);

        if (email.isEmpty() || password.isEmpty()) {
            setContentView(R.layout.activity_logging);
            findViewById(R.id.loggingPasswordVisibilityButton).setOnFocusChangeListener((v, hasFocus) -> {
                if (!hasFocus) {
                    viewTools.hideSystemUI(getWindow().getDecorView());
                }
            });
            Log.w(TAG, "sharepreference: no");
            findViewById(R.id.loggingLogInButton).setOnClickListener(view -> logIn());
            findViewById(R.id.loggingPasswordVisibilityButton).setOnClickListener(view -> setVisibilityPassword());
        } else {
            Log.w(TAG, "sharepreference: yes");
            viewTools.hideSystemUI(getWindow().getDecorView());
            viewTools.changeView(this, HomeActivity.class);
        }


    }

    public void setVisibilityPassword(){
        emailUser = findViewById(R.id.loggingEmailInput);
        passwordUser = findViewById(R.id.loggingPasswordInput);
        visibilityPassword = findViewById(R.id.loggingPasswordVisibilityButton);
        Log.e(TAG, "visibility -> " + passwordUser.getInputType());
        if (visibilityPassword.getContentDescription().equals("hide")){
            visibilityPassword.setContentDescription("show");
            visibilityPassword.setText(getResources()
                    .getString(R.string.icon_visibility_visible));
            passwordUser.setTransformationMethod(null);
        }
        else{
            visibilityPassword.setContentDescription("hide");
            visibilityPassword.setText(getResources()
                    .getString(R.string.icon_visibility_invisible));
            passwordUser.setTransformationMethod(new PasswordTransformationMethod());
        }
    }


    public void logIn() {
        emailUser = findViewById(R.id.loggingEmailInput);
        passwordUser = findViewById(R.id.loggingPasswordInput);

        email = emailUser.getText().toString();
        password = passwordUser.getText().toString();

        firebaseClient.loggingFirebase(this, email, password);
        viewTools.hideSystemUI(getWindow().getDecorView());
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = firebaseClient.getmAuth().getCurrentUser();
        if (currentUser != null) {
            Log.w(TAG, "currentUser: logged -> " + currentUser.getEmail());
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "Destroy");
        viewTools.hideSystemUI(getWindow().getDecorView());
    }
}