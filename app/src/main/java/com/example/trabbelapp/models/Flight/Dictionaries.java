package com.example.trabbelapp.models.Flight;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dictionaries {

    @SerializedName("locations")
    @Expose
    private Locations locations;
    @SerializedName("aircraft")
    @Expose
    private Aircraft__1 aircraft;
    @SerializedName("currencies")
    @Expose
    private Currencies currencies;
    @SerializedName("carriers")
    @Expose
    private Carriers carriers;

    public Locations getLocations() {
        return locations;
    }

    public void setLocations(Locations locations) {
        this.locations = locations;
    }

    public Aircraft__1 getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft__1 aircraft) {
        this.aircraft = aircraft;
    }

    public Currencies getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Currencies currencies) {
        this.currencies = currencies;
    }

    public Carriers getCarriers() {
        return carriers;
    }

    public void setCarriers(Carriers carriers) {
        this.carriers = carriers;
    }

}
