package com.example.trabbelapp.clients;


import android.app.Activity;

import com.example.trabbelapp.models.PointsOfInterest.PointsOfInterest;
import com.example.trabbelapp.services.PointsOfInterestService;
import com.example.trabbelapp.utils.PreferenceShareTools;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class PointsOfInterestClient {

    Activity activity;

    public PointsOfInterestClient(Activity a, DisposableSingleObserver<PointsOfInterest> ds) {
        this.activity = a;
        RetrofitClient retrofit = new RetrofitClient();
        PointsOfInterestService pointsOfInterestService = retrofit.getRetrofitAmadeusV1().create(PointsOfInterestService.class);
        pointsOfInterestService.getPointsOfInterest(
                41.39, 2.16, 5,
                "Bearer "+ new PreferenceShareTools(this.activity).getString("API_TOKEN")
        ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(ds);
    }
}
