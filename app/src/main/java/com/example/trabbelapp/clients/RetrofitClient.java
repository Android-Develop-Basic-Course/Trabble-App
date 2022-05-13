package com.example.trabbelapp.clients;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public RetrofitClient() {

    }

    public static String getSerAPIToken(){
        return "97bbe00a66166d1db8958dd6835e88ac884ae7fa1a6d5f6b9f5ae0a4905628a9";
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

    public Retrofit getRetrofitAmadeusV2() {
        return new Retrofit.Builder()
                .baseUrl("https://test.api.amadeus.com/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}