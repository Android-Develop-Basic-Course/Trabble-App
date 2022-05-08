package com.example.trabbelapp.models;

import com.google.firebase.auth.FirebaseUser;

public class User {

    private String email;
    private String password;
    private FirebaseUser user;

    public User(String email, String password, FirebaseUser user) {
        this.email = email;
        this.password = password;
        this.user = user;
    }

    public User() {
        this.email = "";
        this.password = "";
        this.user = null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
