package com.example.trabbelapp.models.Flight;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Itinerary {

    @SerializedName("duration")
    @Expose
    private String duration;
    @SerializedName("segments")
    @Expose
    private List<Segment> segments = null;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public void setSegments(List<Segment> segments) {
        this.segments = segments;
    }

}
