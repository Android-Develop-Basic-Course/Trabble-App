package com.example.trabbelapp.models.GooglePlaceSearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links {

    @SerializedName("directions")
    @Expose
    private String directions;
    @SerializedName("website")
    @Expose
    private String website;

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

}
