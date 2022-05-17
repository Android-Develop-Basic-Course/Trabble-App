package com.example.trabbelapp.models.GooglePlaceSearch.GooglePlaceDetails;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GooglePlaceDetails {

    @SerializedName("search_metadata")
    @Expose
    private SearchMetadata searchMetadata;
    @SerializedName("search_parameters")
    @Expose
    private SearchParameters searchParameters;
    @SerializedName("search_information")
    @Expose
    private SearchInformation searchInformation;
    @SerializedName("local_results")
    @Expose
    private List<LocalResult> localResults = null;

    public SearchMetadata getSearchMetadata() {
        return searchMetadata;
    }

    public void setSearchMetadata(SearchMetadata searchMetadata) {
        this.searchMetadata = searchMetadata;
    }

    public SearchParameters getSearchParameters() {
        return searchParameters;
    }

    public void setSearchParameters(SearchParameters searchParameters) {
        this.searchParameters = searchParameters;
    }

    public SearchInformation getSearchInformation() {
        return searchInformation;
    }

    public void setSearchInformation(SearchInformation searchInformation) {
        this.searchInformation = searchInformation;
    }

    public List<LocalResult> getLocalResults() {
        return localResults;
    }

    public void setLocalResults(List<LocalResult> localResults) {
        this.localResults = localResults;
    }

}

