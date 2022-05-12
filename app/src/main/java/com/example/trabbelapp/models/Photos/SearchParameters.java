package com.example.trabbelapp.models.Photos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchParameters {

    @SerializedName("query")
    @Expose
    private String query;
    @SerializedName("engine")
    @Expose
    private String engine;
    @SerializedName("where")
    @Expose
    private String where;
    @SerializedName("num")
    @Expose
    private String num;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

}
