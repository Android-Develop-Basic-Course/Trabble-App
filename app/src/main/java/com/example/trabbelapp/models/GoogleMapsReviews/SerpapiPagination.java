package com.example.trabbelapp.models.GoogleMapsReviews;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SerpapiPagination {

    @SerializedName("next")
    @Expose
    private String next;
    @SerializedName("next_page_token")
    @Expose
    private String nextPageToken;

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

}
