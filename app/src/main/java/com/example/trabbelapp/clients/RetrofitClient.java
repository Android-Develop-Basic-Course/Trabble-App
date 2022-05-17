package com.example.trabbelapp.clients;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public RetrofitClient() {

    }

    public static String getSerAPIToken(){
        return "4683998cdbde090a55d178e68b8942220eb46dc9cfb31bd386347637f4cb8808";
    }

    public Retrofit getRetrofitSerpAPI() {
        return new Retrofit.Builder()
                .baseUrl("https://serpapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public Retrofit getRetrofitAmadeusV1() {
        return new Retrofit.Builder()
                .baseUrl("https://test.api.amadeus.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}