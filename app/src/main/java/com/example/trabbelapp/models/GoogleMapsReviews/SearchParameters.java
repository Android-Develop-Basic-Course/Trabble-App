package com.example.trabbelapp.models.GoogleMapsReviews;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchParameters {

    @SerializedName("engine")
    @Expose
    private String engine;
    @SerializedName("data_id")
    @Expose
    private String dataId;
    @SerializedName("hl")
    @Expose
    private String hl;

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getHl() {
        return hl;
    }

    public void setHl(String hl) {
        this.hl = hl;
    }

}
