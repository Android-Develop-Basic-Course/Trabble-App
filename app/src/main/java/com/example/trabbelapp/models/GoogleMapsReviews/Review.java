package com.example.trabbelapp.models.GoogleMapsReviews;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Review {

    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("rating")
    @Expose
    private Double rating;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("snippet")
    @Expose
    private String snippet;
    @SerializedName("likes")
    @Expose
    private Integer likes;
    @SerializedName("images")
    @Expose
    private List<String> images = null;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

}
