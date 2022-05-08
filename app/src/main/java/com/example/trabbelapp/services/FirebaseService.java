package com.example.trabbelapp.services;

import android.app.Activity;
import android.util.Log;

import com.example.trabbelapp.models.User;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FirebaseService {

    private FirebaseAuth mAuth;
    private FirebaseUser user;
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
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this.activity, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.w(this.TAG, "signInWithEmail:success");
                        // todo: updateUI(user);
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.e(this.TAG, "signInWithEmail:failure", task.getException());
                        // todo: updateUI(null);
                    }
                });
    }

    public User getUser() {
        user = this.getmAuth().getCurrentUser();
        assert user != null;
        return new User(user.getEmail(), user.getUid(), user);
    }

    public FirebaseAuth getmAuth() {
        return mAuth;
    }

    public void setmAuth(FirebaseAuth mAuth) {
        this.mAuth = mAuth;
    }
}
