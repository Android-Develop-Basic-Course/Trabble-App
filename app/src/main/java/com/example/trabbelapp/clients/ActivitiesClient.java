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

    public ActivitiesClient(Activity a, DisposableSingleObserver<Activities> ds) {
        this.activity = a;
        RetrofitClient retrofit = new RetrofitClient();
        ActivitiesService activitiesService = retrofit.getRetrofitV1().create(ActivitiesService.class);
        activitiesService.getActivities(
                41.39, 2.16, 5,
                "Bearer "+ new PreferenceShareTools(this.activity).getString("API_TOKEN")
        ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(ds);
    }
}
