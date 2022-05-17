package com.example.trabbelapp.clients;

import android.app.Activity;

import com.example.trabbelapp.models.Hotels.Hotels;
import com.example.trabbelapp.services.HotelsService;
import com.example.trabbelapp.utils.PreferenceShareTools;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class HotelsClient {

    Activity activity;
    PreferenceShareTools preferenceShareTools;

    public HotelsClient(Activity a, DisposableSingleObserver<Hotels> ds) {
        preferenceShareTools = new PreferenceShareTools(a);
        this.activity = a;
        RetrofitClient retrofit = new RetrofitClient();
        HotelsService hotelsService = retrofit.getRetrofitAmadeusV1().create(HotelsService.class);
        hotelsService.getHotels(
                Double.parseDouble(preferenceShareTools.getString("lat")),
                Double.parseDouble(preferenceShareTools.getString("lng")),
                5, "KM", "ALL",
                "Bearer " + new PreferenceShareTools(this.activity).getString("API_TOKEN")
        ).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(ds);
    }
}
