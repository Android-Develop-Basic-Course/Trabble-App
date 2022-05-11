package com.example.trabbelapp.models.Flights;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PricingOptions {

    @SerializedName("fareType")
    @Expose
    private List<String> fareType = null;
    @SerializedName("includedCheckedBagsOnly")
    @Expose
    private Boolean includedCheckedBagsOnly;

    public List<String> getFareType() {
        return fareType;
    }

    public void setFareType(List<String> fareType) {
        this.fareType = fareType;
    }

    public Boolean getIncludedCheckedBagsOnly() {
        return includedCheckedBagsOnly;
    }

    public void setIncludedCheckedBagsOnly(Boolean includedCheckedBagsOnly) {
        this.includedCheckedBagsOnly = includedCheckedBagsOnly;
    }

}
