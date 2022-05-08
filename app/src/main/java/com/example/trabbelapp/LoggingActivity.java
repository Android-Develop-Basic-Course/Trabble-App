package com.example.trabbelapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.trabbelapp.models.User;
import com.example.trabbelapp.services.FirebaseService;
import com.example.trabbelapp.utils.PreferenceShareTools;
import com.example.trabbelapp.utils.ViewTools;
import com.google.firebase.auth.FirebaseUser;

public class LoggingActivity extends AppCompatActivity {

    private final String TAG = "LoggingActivity";
    FirebaseService firebaseService;
    TextView emailUser;
    PreferenceShareTools preferenceShareTools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(null);
        setContentView(R.layout.activity_logging);

        ViewTools viewTools = new ViewTools();
        preferenceShareTools = new PreferenceShareTools(this);
        firebaseService = new FirebaseService(this, TAG);

        viewTools.hideSystemUI(getWindow().getDecorView());


        String email;
        String password;
        User currentUser;


        // Comprobar que no hay usuario registrado
        email = preferenceShareTools.getString("emailUser");
        password = preferenceShareTools.getString("passwordUser");
        Log.e(TAG, "InitialSP: " + email + " - "  + password);

        if (email.isEmpty() || password.isEmpty()){
            Log.w(TAG, "sharepreference: no");

            // Recuerda añadir los datos para probarlo
            email = "{USER_EMAIL}";
            password = "{USER_PASSWORD}";
            firebaseService.loggingFirebase(email, password);
        }
        else {
            Log.w(TAG, "sharepreference: yes");
        }

        currentUser = new User(email, password);


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
        preferenceShareTools.setString("emailUser", "");
        preferenceShareTools.setString("passwordUser", "");
        firebaseService.signOutFirebase();
        finish();
    }
}