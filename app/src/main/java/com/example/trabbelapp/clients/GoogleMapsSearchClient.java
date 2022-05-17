package com.example.trabbelapp.clients;

import android.app.Activity;

import com.example.trabbelapp.models.GoogleMapsReviews.GoogleMapsReviews;
import com.example.trabbelapp.models.GoogleMapsSearch.GoogleMapsSearch;
import com.example.trabbelapp.services.GoogleMapsSearchService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class GoogleMapsSearchClient {

    Activity activity;

    public GoogleMapsSearchClient(){}

    public void getGoogleMapsSearch(Activity a, DisposableSingleObserver<GoogleMapsSearch> ds, String query) {
        this.activity = a;
        RetrofitClient retrofit = new RetrofitClient();
        GoogleMapsSearchService activitiesService = retrofit.getRetrofitSerpAPI().create(GoogleMapsSearchService.class);
        activitiesService.getGoogleMapsSearch(
                "google_maps",
                query,
                "search",
                RetrofitClient.getSerAPIToken()
        ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(ds);
    }

    public void getGoogleMapsReview(Activity a, String dataId, DisposableSingleObserver<GoogleMapsReviews> ds, String query) {
        this.activity = a;
        RetrofitClient retrofit = new RetrofitClient();
        GoogleMapsSearchService activitiesService = retrofit.getRetrofitSerpAPI().create(GoogleMapsSearchService.class);
        activitiesService.getGoogleMapsReviews(
                dataId,
                "google_maps_reviews",
                "es",
                RetrofitClient.getSerAPIToken()
        ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(ds);
    }

}
