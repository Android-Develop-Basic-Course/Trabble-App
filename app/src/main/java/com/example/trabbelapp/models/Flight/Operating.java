package com.example.trabbelapp.models.Flight;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Operating {

    @SerializedName("carrierCode")
    @Expose
    private String carrierCode;

    public String getCarrierCode() {
        return carrierCode;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

}
