package com.example.trabbelapp.clients;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public RetrofitClient() {

    }

    public static String getSerAPIToken(){
        return "0d843a08005d47686a4d611f41c47c6ba395d4c738c75df1bd3973ac0a112d98";
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