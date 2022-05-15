package com.example.trabbelapp.models.GooglePlaceSearch.GooglePlaceDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LocalResult {

    @SerializedName("position")
    @Expose
    private Integer position;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("place_id")
    @Expose
    private String placeId;
    @SerializedName("lsig")
    @Expose
    private String lsig;
    @SerializedName("place_id_search")
    @Expose
    private String placeIdSearch;
    @SerializedName("rating")
    @Expose
    private Double rating;
    @SerializedName("reviews")
    @Expose
    private Integer reviews;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("hours")
    @Expose
    private String hours;
    @SerializedName("gps_coordinates")
    @Expose
    private GpsCoordinates gpsCoordinates;
    @SerializedName("links")
    @Expose
    private Links links;
    @SerializedName("description")
    @Expose
    private String description;

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getLsig() {
        return lsig;
    }

    public void setLsig(String lsig) {
        this.lsig = lsig;
    }

    public String getPlaceIdSearch() {
        return placeIdSearch;
    }

    public void setPlaceIdSearch(String placeIdSearch) {
        this.placeIdSearch = placeIdSearch;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public GpsCoordinates getGpsCoordinates() {
        return gpsCoordinates;
    }

    public void setGpsCoordinates(GpsCoordinates gpsCoordinates) {
        this.gpsCoordinates = gpsCoordinates;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
