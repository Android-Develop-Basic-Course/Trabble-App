package com.example.trabbelapp.models.GoogleMapsSearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

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
    @SerializedName("data_id")
    @Expose
    private String dataId;
    @SerializedName("data_cid")
    @Expose
    private String dataCid;
    @SerializedName("reviews_link")
    @Expose
    private String reviewsLink;
    @SerializedName("photos_link")
    @Expose
    private String photosLink;
    @SerializedName("gps_coordinates")
    @Expose
    private GpsCoordinates gpsCoordinates;
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
    private String type = null;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("hours")
    @Expose
    private String hours;
    @SerializedName("amenities")
    @Expose
    private List<String> amenities = null;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("price")
    @Expose
    private String price;

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

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getDataCid() {
        return dataCid;
    }

    public void setDataCid(String dataCid) {
        this.dataCid = dataCid;
    }

    public String getReviewsLink() {
        return reviewsLink;
    }

    public void setReviewsLink(String reviewsLink) {
        this.reviewsLink = reviewsLink;
    }

    public String getPhotosLink() {
        return photosLink;
    }

    public void setPhotosLink(String photosLink) {
        this.photosLink = photosLink;
    }

    public GpsCoordinates getGpsCoordinates() {
        return gpsCoordinates;
    }

    public void setGpsCoordinates(GpsCoordinates gpsCoordinates) {
        this.gpsCoordinates = gpsCoordinates;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
