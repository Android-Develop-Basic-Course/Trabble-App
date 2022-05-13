package com.example.trabbelapp.models.GoogleMapsSearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SerpapiPagination {

    @SerializedName("next")
    @Expose
    private String next;

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

}
