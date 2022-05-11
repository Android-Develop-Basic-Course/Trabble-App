package com.example.trabbelapp.models.Flights;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Locations {

    @SerializedName("BKK")
    @Expose
    private Bkk bkk;
    @SerializedName("MNL")
    @Expose
    private Mnl mnl;
    @SerializedName("SYD")
    @Expose
    private Syd syd;

    public Bkk getBkk() {
        return bkk;
    }

    public void setBkk(Bkk bkk) {
        this.bkk = bkk;
    }

    public Mnl getMnl() {
        return mnl;
    }

    public void setMnl(Mnl mnl) {
        this.mnl = mnl;
    }

    public Syd getSyd() {
        return syd;
    }

    public void setSyd(Syd syd) {
        this.syd = syd;
    }

}
