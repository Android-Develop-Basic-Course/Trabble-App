package com.example.trabbelapp.models.Hotels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum implements Parcelable {

    @SerializedName("chainCode")
    @Expose
    private String chainCode;
    @SerializedName("iataCode")
    @Expose
    private String iataCode;
    @SerializedName("dupeId")
    @Expose
    private Integer dupeId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("hotelId")
    @Expose
    private String hotelId;
    @SerializedName("geoCode")
    @Expose
    private GeoCode geoCode;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("distance")
    @Expose
    private Distance distance;


    protected Datum(Parcel in) {
        chainCode = in.readString();
        iataCode = in.readString();
        if (in.readByte() == 0) {
            dupeId = null;
        } else {
            dupeId = in.readInt();
        }
        name = in.readString();
        hotelId = in.readString();
        geoCode = in.readParcelable(GeoCode.class.getClassLoader());
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

    public String getChainCode() {
        return chainCode;
    }

    public void setChainCode(String chainCode) {
        this.chainCode = chainCode;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public Integer getDupeId() {
        return dupeId;
    }

    public void setDupeId(Integer dupeId) {
        this.dupeId = dupeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public GeoCode getGeoCode() {
        return geoCode;
    }

    public void setGeoCode(GeoCode geoCode) {
        this.geoCode = geoCode;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Distance getDistance() {
        return distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(chainCode);
        parcel.writeString(iataCode);
        if (dupeId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(dupeId);
        }
        parcel.writeString(name);
        parcel.writeString(hotelId);
    }
}
