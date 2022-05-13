package com.example.trabbelapp.models.Activities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Datum implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("self")
    @Expose
    private Self self;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("shortDescription")
    @Expose
    private String shortDescription;
    @SerializedName("geoCode")
    @Expose
    private GeoCode geoCode;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("pictures")
    @Expose
    private List<String> pictures = null;
    @SerializedName("bookingLink")
    @Expose
    private String bookingLink;
    @SerializedName("price")
    @Expose
    private Price price;

    protected Datum(Parcel in) {
        id = in.readString();
        type = in.readString();
        name = in.readString();
        shortDescription = in.readString();
        rating = in.readString();
        pictures = in.createStringArrayList();
        bookingLink = in.readString();
    }

    public static final Creator<Datum> CREATOR = new Creator<Datum>() {
        @Override
        public Datum createFromParcel(Parcel in) {
            return new Datum(in);
        }

        @Override
        public Datum[] newArray(int size) {
            return new Datum[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Self getSelf() {
        return self;
    }

    public void setSelf(Self self) {
        this.self = self;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public GeoCode getGeoCode() {
        return geoCode;
    }

    public void setGeoCode(GeoCode geoCode) {
        this.geoCode = geoCode;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

    public String getBookingLink() {
        return bookingLink;
    }

    public void setBookingLink(String bookingLink) {
        this.bookingLink = bookingLink;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(type);
        parcel.writeString(name);
        parcel.writeString(shortDescription);
        parcel.writeString(rating);
        parcel.writeStringList(pictures);
        parcel.writeString(bookingLink);
    }
}
