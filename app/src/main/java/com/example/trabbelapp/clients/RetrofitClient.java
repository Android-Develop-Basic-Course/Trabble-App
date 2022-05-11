package com.example.trabbelapp.clients;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public RetrofitClient(){

    }

    public Retrofit getRetrofitV1(){
        return new Retrofit.Builder()
                .baseUrl("https://test.api.amadeus.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public Retrofit getRetrofitV2(){
        return new Retrofit.Builder()
                .baseUrl("https://test.api.amadeus.com/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}