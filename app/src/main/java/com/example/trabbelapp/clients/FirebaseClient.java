package com.example.trabbelapp.clients;

import android.app.Activity;
import android.util.Log;
import android.widget.EditText;

import com.example.trabbelapp.HomeActivity;
import com.example.trabbelapp.R;
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

    public FirebaseClient(Activity activity, String TAG) {
        this.mAuth = FirebaseAuth.getInstance();
        this.user = null;
        this.TAG = TAG;
        this.activity = activity;
        FirebaseApp.initializeApp(this.activity);
    }

    public void loggingFirebase(Activity activity, String email, String password) {
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
                        EditText emailUser = activity.findViewById(R.id.loggingEmailInput);
                        EditText passwordUser = activity.findViewById(R.id.loggingPasswordInput);
                        emailUser.setHint("Re-enter your email");
                        emailUser.setText("");
                        passwordUser.setHint("Re-enter your password");
                        passwordUser.setText("");
                    }
                });
    }

    public void updateUI(Boolean ack) {
        if (ack) {
            PreferenceShareTools preferenceShareTools;
            preferenceShareTools = new PreferenceShareTools(this.activity);
            preferenceShareTools.setString("emailUser", this.user.getEmail());
            preferenceShareTools.setString("passwordUser", this.user.getPassword());
            ViewTools viewTools = new ViewTools();
            viewTools.changeView(this.activity, HomeActivity.class);
        } else {
            setUser("unknown", "unknown");
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
