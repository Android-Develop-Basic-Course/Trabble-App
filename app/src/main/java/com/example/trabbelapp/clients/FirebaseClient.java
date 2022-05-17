package com.example.trabbelapp.clients;

import android.app.Activity;
import android.net.Uri;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trabbelapp.HomeActivity;
import com.example.trabbelapp.R;
import com.example.trabbelapp.models.User;
import com.example.trabbelapp.utils.PreferenceShareTools;
import com.example.trabbelapp.utils.ViewTools;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import java.util.concurrent.Executor;

import io.reactivex.annotations.NonNull;

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

    public void signUpFirebase(Activity activity, String name, String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this.activity, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        setUser(name, email, password);
                        changeProfile(user, name, null);
                        updateUI(true);
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                        Toast.makeText(activity, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }

                });
    }

    public void changeProfile(FirebaseUser user, String name, String urlPhoto){
        UserProfileChangeRequest profileUpdates;
        if(urlPhoto!=null)
            profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName(name)
                .setPhotoUri(Uri.parse("https://example.com/jane-q-user/profile.jpg"))
                .build();
        else
            profileUpdates = new UserProfileChangeRequest.Builder()
                    .setDisplayName(name)
                    .build();

        try {
            assert user != null;
            user.updateProfile(profileUpdates)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "User profile updated.");
                        }
                    });
        }
        catch (Exception e){
            Log.e("ERROR","User profile no updated.");
        }
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
                        if(activity!=null) {
                            EditText emailUser = activity.findViewById(R.id.loggingEmailInput);
                            EditText passwordUser = activity.findViewById(R.id.loggingPasswordInput);
                            emailUser.setHint("Re-enter your email");
                            emailUser.setText("");
                            passwordUser.setHint("Re-enter your password");
                            passwordUser.setText("");
                        }
                    }
                });
    }

    public void updateUI(Boolean ack) {
        if (ack) {
            PreferenceShareTools preferenceShareTools;
            preferenceShareTools = new PreferenceShareTools(this.activity);
            preferenceShareTools.setString("nameUser", this.user.getName());
            preferenceShareTools.setString("emailUser", this.user.getEmail());
            preferenceShareTools.setString("passwordUser", this.user.getPassword());
            ViewTools viewTools = new ViewTools();
            viewTools.changeView(this.activity, HomeActivity.class);
        } else {
            setUser("unknown", "unknown");
        }
    }

    public void signOutFirebase() {
        PreferenceShareTools preferenceShareTools;
        preferenceShareTools = new PreferenceShareTools(this.activity);
        System.err.println("SignOut");
        preferenceShareTools.setString("nameUser", "");
        preferenceShareTools.setString("emailUser", "");
        preferenceShareTools.setString("passwordUser", "");
        this.mAuth.signOut();
    }

    public void setUser(String email, String password) {
        this.user = new User(email, password);
    }

    public void setUser(String name, String email, String password) {
        this.user = new User(name, email, password);
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
