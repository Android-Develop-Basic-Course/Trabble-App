package com.example.trabbelapp.clients;

import android.app.Activity;

import com.example.trabbelapp.models.GooglePlaceSearch.GooglePlaceDetails.GooglePlaceDetails;
import com.example.trabbelapp.models.GooglePlaceSearch.GooglePlaceSearch;
import com.example.trabbelapp.services.GooglePlaceService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class GooglePlaceClient {
    Activity activity;

    public GooglePlaceClient() {
    }

    public void getGooglePlaceSearch(Activity a, DisposableSingleObserver<GooglePlaceSearch> ds, String query) {
        this.activity = a;
        RetrofitClient retrofit = new RetrofitClient();
        GooglePlaceService placeService = retrofit
                .getRetrofitSerpAPI()
                .create(GooglePlaceService.class);
        placeService.getGooglePlaceSearch(
                "lcl",
                query,
                RetrofitClient.getSerAPIToken()
        ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(ds);
    }

    public void getGooglePlaceDetails(Activity a, DisposableSingleObserver<GooglePlaceDetails> ds, String query) {
        this.activity = a;
        RetrofitClient retrofit = new RetrofitClient();
        GooglePlaceService placeService = retrofit
                .getRetrofitSerpAPI()
                .create(GooglePlaceService.class);
        placeService.getGooglePlaceDetails(
                "google_maps",
                query,
                "search",
                RetrofitClient.getSerAPIToken()
        ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(ds);
    }

    public void getGooglePlaceDetailsByULR(Activity a, DisposableSingleObserver<GooglePlaceDetails> ds, String lsig, String ludocid, String query) {
        this.activity = a;
        RetrofitClient retrofit = new RetrofitClient();
        GooglePlaceService placeService = retrofit
                .getRetrofitSerpAPI()
                .create(GooglePlaceService.class);
        placeService.getGooglePlaceDetailsByURL(
                "desktop",
                "google",
                "google.com",
                lsig,
                ludocid,
                query,
                "lcl",
                RetrofitClient.getSerAPIToken()
        ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(ds);
    }
}
