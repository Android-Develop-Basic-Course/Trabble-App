package com.example.trabbelapp.models.Activities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Self {

    @SerializedName("href")
    @Expose
    private String href;
    @SerializedName("methods")
    @Expose
    private List<String> methods = null;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<String> getMethods() {
        return methods;
    }

    public void setMethods(List<String> methods) {
        this.methods = methods;
    }

}
