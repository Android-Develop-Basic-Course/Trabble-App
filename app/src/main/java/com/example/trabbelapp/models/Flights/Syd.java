package com.example.trabbelapp.models.Flights;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Syd {

    @SerializedName("cityCode")
    @Expose
    private String cityCode;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

}
