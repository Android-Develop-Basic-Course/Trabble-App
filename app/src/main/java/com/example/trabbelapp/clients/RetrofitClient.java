package com.example.trabbelapp.clients;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public RetrofitClient() {

    }

    public static String getSerAPIToken(){
        return "bb2e707d974d173073cf6021d69a39d017732b43d8c6ef95280ba35aca49cb17";
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