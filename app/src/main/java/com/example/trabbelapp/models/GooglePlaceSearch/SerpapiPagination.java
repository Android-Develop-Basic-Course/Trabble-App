package com.example.trabbelapp.models.GooglePlaceSearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SerpapiPagination {

    @SerializedName("current")
    @Expose
    private Integer current;
    @SerializedName("next_link")
    @Expose
    private String nextLink;
    @SerializedName("next")
    @Expose
    private String next;
    @SerializedName("other_pages")
    @Expose
    private OtherPages otherPages;

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public String getNextLink() {
        return nextLink;
    }

    public void setNextLink(String nextLink) {
        this.nextLink = nextLink;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public OtherPages getOtherPages() {
        return otherPages;
    }

    public void setOtherPages(OtherPages otherPages) {
        this.otherPages = otherPages;
    }

}
