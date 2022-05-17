package com.example.trabbelapp.models.GoogleMapsSearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchParameters {

    @SerializedName("engine")
    @Expose
    private String engine;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("q")
    @Expose
    private String q;
    @SerializedName("google_domain")
    @Expose
    private String googleDomain;
    @SerializedName("hl")
    @Expose
    private String hl;

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getHl() {
        return hl;
    }

    public void setHl(String hl) {
        this.hl = hl;
    }

}
