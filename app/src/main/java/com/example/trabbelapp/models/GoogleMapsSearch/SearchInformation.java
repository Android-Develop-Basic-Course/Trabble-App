package com.example.trabbelapp.models.GoogleMapsSearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchInformation {

    @SerializedName("local_results_state")
    @Expose
    private String localResultsState;
    @SerializedName("query_displayed")
    @Expose
    private String queryDisplayed;

    public String getLocalResultsState() {
        return localResultsState;
    }

    public void setLocalResultsState(String localResultsState) {
        this.localResultsState = localResultsState;
    }

    public String getQueryDisplayed() {
        return queryDisplayed;
    }

    public void setQueryDisplayed(String queryDisplayed) {
        this.queryDisplayed = queryDisplayed;
    }

}
