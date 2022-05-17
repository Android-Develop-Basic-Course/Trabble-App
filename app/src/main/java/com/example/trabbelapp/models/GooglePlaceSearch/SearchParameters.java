package com.example.trabbelapp.models.GooglePlaceSearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchParameters {

    @SerializedName("engine")
    @Expose
    private String engine;
    @SerializedName("q")
    @Expose
    private String q;
    @SerializedName("google_domain")
    @Expose
    private String googleDomain;
    @SerializedName("device")
    @Expose
    private String device;
    @SerializedName("tbm")
    @Expose
    private String tbm;

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getGoogleDomain() {
        return googleDomain;
    }

    public void setGoogleDomain(String googleDomain) {
        this.googleDomain = googleDomain;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getTbm() {
        return tbm;
    }

    public void setTbm(String tbm) {
        this.tbm = tbm;
    }

}
