package com.example.trabbelapp.models.GoogleMapsReviews;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlaceInfo {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("rating")
    @Expose
    private Double rating;
    @SerializedName("reviews")
    @Expose
    private Integer reviews;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getReviews() {
        return reviews;
    }

    public void setReviews(Integer reviews) {
        this.reviews = reviews;
    }

}
