package com.example.trabbelapp.clients;

import android.app.Activity;
import android.util.Log;

import com.example.trabbelapp.HomeActivity;
import com.example.trabbelapp.models.User;
import com.example.trabbelapp.utils.PreferenceShareTools;
import com.example.trabbelapp.utils.ViewTools;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class FirebaseClient {

    private FirebaseAuth mAuth;
    private User user;
    private final Activity activity;
    private final String TAG;
    private int statusCode;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public FirebaseClient(Activity activity, String TAG) {
        this.mAuth = FirebaseAuth.getInstance();
        this.user = null;
        this.TAG = TAG;
        this.activity = activity;
        FirebaseApp.initializeApp(this.activity);
        this.statusCode = 201;
    }

    public void loggingFirebase(String email, String password) {
        setUser(email, password);
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this.activity, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.w(this.TAG, "logging:success");
                        updateUI(true);

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.e(this.TAG, "logging:failure", task.getException());
                        updateUI(false);
                    }
                });
    }

    public void updateUI(Boolean ack) {
        if (ack) {
            this.statusCode = 200;
            PreferenceShareTools preferenceShareTools;
            preferenceShareTools = new PreferenceShareTools(this.activity);
            preferenceShareTools.setInt("statusCode", this.statusCode);
            preferenceShareTools.setString("emailUser", this.user.getEmail());
            preferenceShareTools.setString("passwordUser", this.user.getPassword());
            ViewTools viewTools = new ViewTools();
            viewTools.changeView(this.activity, HomeActivity.class);
        } else {
            setUser("unknown", "unknown");
            this.statusCode = 304;
        }
    }

    public void signOutFirebase() {
        this.mAuth.signOut();
    }

    public void setUser(String email, String password) {
        this.user = new User(email, password);
    }

    public User getUser() {
        return this.user;
    }

    public FirebaseAuth getmAuth() {
        return mAuth;
    }

    public void setmAuth(FirebaseAuth mAuth) {
        this.mAuth = mAuth;
    }
}
