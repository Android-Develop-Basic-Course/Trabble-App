package com.example.trabbelapp.services;

import com.example.trabbelapp.models.PointsOfInterest.PointsOfInterest;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface PointsOfInterestService {

    @GET("reference-data/locations/pois")
    Single<PointsOfInterest> getPointsOfInterest(
            @Query("latitude") double lat,
            @Query("longitude") double lng,
            @Query("radius") int radius,
            @Header("Authorization") String authBearer
    );
}
