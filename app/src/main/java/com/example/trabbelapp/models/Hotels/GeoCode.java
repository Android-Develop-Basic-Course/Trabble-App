package com.example.trabbelapp.models.Hotels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GeoCode implements Parcelable {

    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;

    protected GeoCode(Parcel in) {
        latitude = in.readString();
        longitude = in.readString();
    }

    public static final Creator<GeoCode> CREATOR = new Creator<GeoCode>() {
        @Override
        public GeoCode createFromParcel(Parcel in) {
            return new GeoCode(in);
        }

        @Override
        public GeoCode[] newArray(int size) {
            return new GeoCode[size];
        }
    };

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(latitude);
        parcel.writeString(longitude);
    }
}
