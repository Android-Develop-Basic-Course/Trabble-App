package com.example.trabbelapp.models.GooglePlaceSearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ServiceOptions {

    @SerializedName("dine_in")
    @Expose
    private Boolean dineIn;
    @SerializedName("takeout")
    @Expose
    private Boolean takeout;
    @SerializedName("no_delivery")
    @Expose
    private Boolean noDelivery;
    @SerializedName("delivery")
    @Expose
    private Boolean delivery;
    @SerializedName("in_store_shopping")
    @Expose
    private Boolean inStoreShopping;
    @SerializedName("in_store_pickup")
    @Expose
    private Boolean inStorePickup;
    @SerializedName("curbside_pickup")
    @Expose
    private Boolean curbsidePickup;
    @SerializedName("no_contact_delivery")
    @Expose
    private Boolean noContactDelivery;

    public Boolean getDineIn() {
        return dineIn;
    }

    public void setDineIn(Boolean dineIn) {
        this.dineIn = dineIn;
    }

    public Boolean getTakeout() {
        return takeout;
    }

    public void setTakeout(Boolean takeout) {
        this.takeout = takeout;
    }

    public Boolean getNoDelivery() {
        return noDelivery;
    }

    public void setNoDelivery(Boolean noDelivery) {
        this.noDelivery = noDelivery;
    }

    public Boolean getDelivery() {
        return delivery;
    }

    public void setDelivery(Boolean delivery) {
        this.delivery = delivery;
    }

    public Boolean getInStoreShopping() {
        return inStoreShopping;
    }

    public void setInStoreShopping(Boolean inStoreShopping) {
        this.inStoreShopping = inStoreShopping;
    }

    public Boolean getInStorePickup() {
        return inStorePickup;
    }

    public void setInStorePickup(Boolean inStorePickup) {
        this.inStorePickup = inStorePickup;
    }

    public Boolean getCurbsidePickup() {
        return curbsidePickup;
    }

    public void setCurbsidePickup(Boolean curbsidePickup) {
        this.curbsidePickup = curbsidePickup;
    }

    public Boolean getNoContactDelivery() {
        return noContactDelivery;
    }

    public void setNoContactDelivery(Boolean noContactDelivery) {
        this.noContactDelivery = noContactDelivery;
    }

}
