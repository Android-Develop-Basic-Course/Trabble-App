package com.example.trabbelapp.models.GoogleMapsReviews;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchMetadata {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("json_endpoint")
    @Expose
    private String jsonEndpoint;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("processed_at")
    @Expose
    private String processedAt;
    @SerializedName("google_maps_reviews_url")
    @Expose
    private String googleMapsReviewsUrl;
    @SerializedName("raw_html_file")
    @Expose
    private String rawHtmlFile;
    @SerializedName("total_time_taken")
    @Expose
    private Double totalTimeTaken;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJsonEndpoint() {
        return jsonEndpoint;
    }

    public void setJsonEndpoint(String jsonEndpoint) {
        this.jsonEndpoint = jsonEndpoint;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getProcessedAt() {
        return processedAt;
    }

    public void setProcessedAt(String processedAt) {
        this.processedAt = processedAt;
    }

    public String getGoogleMapsReviewsUrl() {
        return googleMapsReviewsUrl;
    }

    public void setGoogleMapsReviewsUrl(String googleMapsReviewsUrl) {
        this.googleMapsReviewsUrl = googleMapsReviewsUrl;
    }

    public String getRawHtmlFile() {
        return rawHtmlFile;
    }

    public void setRawHtmlFile(String rawHtmlFile) {
        this.rawHtmlFile = rawHtmlFile;
    }

    public Double getTotalTimeTaken() {
        return totalTimeTaken;
    }

    public void setTotalTimeTaken(Double totalTimeTaken) {
        this.totalTimeTaken = totalTimeTaken;
    }

}
