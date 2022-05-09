package com.example.trabbelapp.services;

import com.example.trabbelapp.models.Activities.Activities;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ActivitiesService {

    @GET("shopping/activities")
    Single<Activities> getActivities(
            @Query("latitude") double lat,
            @Query("longitude") double lng,
            @Query("radius") int radius,
            @Header("Authorization") String authBearer
    );
}
