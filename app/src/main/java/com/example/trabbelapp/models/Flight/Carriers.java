package com.example.trabbelapp.models.Flight;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Carriers {

    @SerializedName("PR")
    @Expose
    private String pr;

    public String getPr() {
        return pr;
    }

    public void setPr(String pr) {
        this.pr = pr;
    }

}
