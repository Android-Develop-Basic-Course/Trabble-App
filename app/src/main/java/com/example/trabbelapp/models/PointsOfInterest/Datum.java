package com.example.trabbelapp.models.PointsOfInterest;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Datum implements Parcelable{

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("subType")
    @Expose
    private String subType;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("self")
    @Expose
    private Self self;
    @SerializedName("geoCode")
    @Expose
    private GeoCode geoCode;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("rank")
    @Expose
    private Integer rank;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;

    protected Datum(Parcel in) {
        type = in.readString();
        subType = in.readString();
        id = in.readString();
        name = in.readString();
        category = in.readString();
        if (in.readByte() == 0) {
            rank = null;
        } else {
            rank = in.readInt();
        }
        tags = in.createStringArrayList();
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Self getSelf() {
        return self;
    }

    public void setSelf(Self self) {
        this.self = self;
    }

    public GeoCode getGeoCode() {
        return geoCode;
    }

    public void setGeoCode(GeoCode geoCode) {
        this.geoCode = geoCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(type);
        parcel.writeString(subType);
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(category);
        if (rank == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(rank);
        }
        parcel.writeStringList(tags);
    }
}
