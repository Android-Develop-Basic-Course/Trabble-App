package com.example.trabbelapp.clients;

import android.app.Activity;

import com.example.trabbelapp.models.Flights.Flights;
import com.example.trabbelapp.services.FlightsService;
import com.example.trabbelapp.utils.PreferenceShareTools;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class FlightClient {

    Activity activity;

    public FlightClient(Activity a, DisposableSingleObserver<Flights> ds) {
        this.activity = a;
        RetrofitClient retrofit = new RetrofitClient();
        FlightsService activitiesService = retrofit.getRetrofitAmadeusV2().create(FlightsService.class);
        activitiesService.getFlights(
                "SYD",
                "BKK",
                "2022-11-01",
                1,
                1,
                0,
                "Bearer " + new PreferenceShareTools(this.activity).getString("API_TOKEN")
        ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(ds);
    }
}
