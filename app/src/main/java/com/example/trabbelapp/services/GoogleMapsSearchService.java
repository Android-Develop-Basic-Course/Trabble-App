package com.example.trabbelapp.services;

import com.example.trabbelapp.models.GoogleMapsReviews.GoogleMapsReviews;
import com.example.trabbelapp.models.GoogleMapsSearch.GoogleMapsSearch;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GoogleMapsSearchService {
    @GET("search.json")
    Single<GoogleMapsSearch> getGoogleMapsSearch(
            @Query("engine") String engine,
            @Query("q") String query,
            @Query("type") String search,
            @Query("api_key") String hotelSource
    );

    @GET("search.json")
    Single<GoogleMapsReviews> getGoogleMapsReviews(
            @Query("data_id") String dataId,
            @Query("engine") String engine,
            @Query("hl") String language,
            @Query("api_key") String apiKey
    );
}
