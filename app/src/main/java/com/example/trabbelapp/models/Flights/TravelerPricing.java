package com.example.trabbelapp.models.Flights;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TravelerPricing {

    @SerializedName("travelerId")
    @Expose
    private String travelerId;
    @SerializedName("fareOption")
    @Expose
    private String fareOption;
    @SerializedName("travelerType")
    @Expose
    private String travelerType;
    @SerializedName("price")
    @Expose
    private Price__1 price;
    @SerializedName("fareDetailsBySegment")
    @Expose
    private List<FareDetailsBySegment> fareDetailsBySegment = null;

    public String getTravelerId() {
        return travelerId;
    }

    public void setTravelerId(String travelerId) {
        this.travelerId = travelerId;
    }

    public String getFareOption() {
        return fareOption;
    }

    public void setFareOption(String fareOption) {
        this.fareOption = fareOption;
    }

    public String getTravelerType() {
        return travelerType;
    }

    public void setTravelerType(String travelerType) {
        this.travelerType = travelerType;
    }

    public Price__1 getPrice() {
        return price;
    }

    public void setPrice(Price__1 price) {
        this.price = price;
    }

    public List<FareDetailsBySegment> getFareDetailsBySegment() {
        return fareDetailsBySegment;
    }

    public void setFareDetailsBySegment(List<FareDetailsBySegment> fareDetailsBySegment) {
        this.fareDetailsBySegment = fareDetailsBySegment;
    }

}
