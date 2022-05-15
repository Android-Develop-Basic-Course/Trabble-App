package com.example.trabbelapp.services;

import com.example.trabbelapp.models.GooglePlaceSearch.GooglePlaceDetails.GooglePlaceDetails;
import com.example.trabbelapp.models.GooglePlaceSearch.GooglePlaceSearch;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GooglePlaceService {
    @GET("search.json")
    Single<GooglePlaceSearch> getGooglePlaceSearch(
            @Query("tbm") String tbm,
            @Query("q") String query,
            @Query("api_key") String apiKey
    );

    @GET("search.json")
    Single<GooglePlaceDetails> getGooglePlaceDetails(
            @Query("engine") String engine,
            @Query("q") String query,
            @Query("type") String type,
            @Query("api_key") String apiKey
    );

    @GET("search.json")
    Single<GooglePlaceDetails> getGooglePlaceDetailsByURL(
            @Query("device") String device,
            @Query("engine") String engine,
            @Query("google_domain") String googleDomain,
            @Query("lsig") String lsig,
            @Query("ludocid") String ludocid,
            @Query("q") String query,
            @Query("tbm") String tbm,
            @Query("api_key") String apiKey
    );
}
