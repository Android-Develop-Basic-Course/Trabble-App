package com.example.trabbelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trabbelapp.clients.FirebaseClient;
import com.example.trabbelapp.utils.ViewTools;

public class SignUpActivity extends AppCompatActivity {

    ViewTools viewTools;
    FirebaseClient firebaseClient;

    EditText nameInput;
    EditText emailInput;
    EditText passwordInput;
    EditText passwordConfirmInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        viewTools = new ViewTools();
        firebaseClient = new FirebaseClient(this, "SignUp");
        viewTools.hideSystemUI(this.getWindow().getDecorView());

        nameInput = findViewById(R.id.signUpNameInput);
        emailInput = findViewById(R.id.signUpEmailInput);
        passwordInput = findViewById(R.id.signUpPasswordInput);
        passwordConfirmInput = findViewById(R.id.signUpConfirmPasswordInput);

        findViewById(R.id.signUpButton).setOnClickListener(view -> signUp());
        findViewById(R.id.signUpPasswordVisibilityButton).setOnClickListener(view -> setVisibility());
        findViewById(R.id.signUpConfirmPasswordVisibilityButton).setOnClickListener(view -> setVisibility());
        findViewById(R.id.signUpSignInLink).setOnClickListener(view ->
                viewTools.changeView(this, LoggingActivity.class));
    }

    private void setVisibility() {
        Button visibilityPassword = findViewById(R.id.signUpPasswordVisibilityButton);
        Button visibilityConfirmPassword = findViewById(R.id.signUpConfirmPasswordVisibilityButton);
        if (visibilityPassword.getContentDescription().toString().equals("hide") || visibilityPassword.getContentDescription().toString().isEmpty()){
            visibilityPassword.setContentDescription("show");
            visibilityConfirmPassword.setContentDescription("show");
            visibilityPassword.setText(getResources()
                    .getString(R.string.icon_visibility_visible));
            visibilityConfirmPassword.setText(getResources()
                    .getString(R.string.icon_visibility_visible));
            passwordInput.setTransformationMethod(null);
            passwordConfirmInput.setTransformationMethod(null);
        }
        else{
            visibilityPassword.setContentDescription("hide");
            visibilityConfirmPassword.setContentDescription("hide");
            visibilityPassword.setText(getResources()
                    .getString(R.string.icon_visibility_invisible));
            visibilityConfirmPassword.setText(getResources()
                    .getString(R.string.icon_visibility_invisible));
            passwordInput.setTransformationMethod(new PasswordTransformationMethod());
            passwordConfirmInput.setTransformationMethod(new PasswordTransformationMethod());
        }
    }

    private void signUp(){

        String name = nameInput.getText().toString();
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        if (password.equals(passwordConfirmInput.getText().toString())){
            //sign up
            Toast.makeText(this, "User Create: " + name + ", " + email, Toast.LENGTH_LONG).show();
            firebaseClient.signUpFirebase(this, name, email, password);
            viewTools.changeView(this, HomeActivity.class);
        }
        else {
            passwordInput.setText("");
            passwordInput.setHint("Passwords don't match");
            passwordInput.setHintTextColor(getResources().getColor(R.color.colorAccent));
            passwordConfirmInput.setText("");
            passwordConfirmInput.setHint("Passwords don't match");
            passwordConfirmInput.setHintTextColor(getResources().getColor(R.color.colorAccent));
        }
    }
}