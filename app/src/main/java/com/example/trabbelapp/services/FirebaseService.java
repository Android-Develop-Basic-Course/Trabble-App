package com.example.trabbelapp.services;

import android.app.Activity;
import android.util.Log;

import com.example.trabbelapp.models.User;
import com.example.trabbelapp.utils.PreferenceShareTools;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.atomic.AtomicReference;

public class FirebaseService {

    private FirebaseAuth mAuth;
    private User user;
    private final Activity activity;
    private final String TAG;

    public FirebaseService(Activity activity, String TAG){
        this.mAuth = FirebaseAuth.getInstance();
        this.user = null;
        this.TAG = TAG;
        this.activity = activity;
        FirebaseApp.initializeApp(this.activity);
    }

    public void loggingFirebase(String email, String password){
        setUser(email, password);
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this.activity, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.w(this.TAG, "logging:success");
                        // todo: updateUI(user);
                        updateUI(true);

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.e(this.TAG, "logging:failure", task.getException());
                        // todo: updateUI(null);
                        assert true;
                        updateUI(false);
                    }
                });
        
    }

    public void updateUI(Boolean ack) {
        if (ack) {
            PreferenceShareTools preferenceShareTools;
            preferenceShareTools = new PreferenceShareTools(this.activity);
            preferenceShareTools.setString("emailUser", this.user.getEmail());
            preferenceShareTools.setString("passwordUser", this.user.getPassword());
        } else {
            setUser("unknown", "unknown");
        }
    }

    public void signOutFirebase(){
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
