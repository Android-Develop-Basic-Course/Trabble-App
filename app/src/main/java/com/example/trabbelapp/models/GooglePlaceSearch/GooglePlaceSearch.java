package com.example.trabbelapp.models.GooglePlaceSearch;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GooglePlaceSearch {

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
    @SerializedName("pagination")
    @Expose
    private Pagination pagination;
    @SerializedName("serpapi_pagination")
    @Expose
    private SerpapiPagination serpapiPagination;

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

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public SerpapiPagination getSerpapiPagination() {
        return serpapiPagination;
    }

    public void setSerpapiPagination(SerpapiPagination serpapiPagination) {
        this.serpapiPagination = serpapiPagination;
    }
}

