package com.example.trabbelapp.clients;

import android.app.Activity;

import com.example.trabbelapp.models.Activities.Activities;
import com.example.trabbelapp.services.ActivitiesService;
import com.example.trabbelapp.utils.PreferenceShareTools;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class ActivitiesClient {

    Activity activity;
    PreferenceShareTools preferenceShareTools;

    public ActivitiesClient(Activity a, DisposableSingleObserver<Activities> ds) {
        preferenceShareTools = new PreferenceShareTools(a);
        this.activity = a;
        RetrofitClient retrofit = new RetrofitClient();
        ActivitiesService activitiesService = retrofit.getRetrofitAmadeusV1().create(ActivitiesService.class);
        activitiesService.getActivities(
                Double.parseDouble(preferenceShareTools.getString("lat")),
                Double.parseDouble(preferenceShareTools.getString("lng")),
                5,
                "Bearer " + new PreferenceShareTools(this.activity).getString("API_TOKEN")
        ).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(ds);
    }
}
