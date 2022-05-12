package com.example.trabbelapp.models.Photos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Photos {

    @SerializedName("search_metadata")
    @Expose
    private SearchMetadata searchMetadata;
    @SerializedName("search_parameters")
    @Expose
    private SearchParameters searchParameters;
    @SerializedName("search_information")
    @Expose
    private SearchInformation searchInformation;
    @SerializedName("images_results")
    @Expose
    private List<ImagesResult> imagesResults = null;

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

    public List<ImagesResult> getImagesResults() {
        return imagesResults;
    }

    public void setImagesResults(List<ImagesResult> imagesResults) {
        this.imagesResults = imagesResults;
    }

}

