package com.example.trabbelapp.services;

import com.example.trabbelapp.models.Hotels.Hotels;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface HotelsService {
    @GET("reference-data/locations/hotels/by-geocode")
    Single<Hotels> getHotels(
            @Query("latitude") double lat,
            @Query("longitude") double lng,
            @Query("radius") int radius,
            @Query("radiusUnit") String radiusUnits,  //"KM"
            @Query("hotelSource") String hotelSource, // "ALL"
            @Header("Authorization") String authBearer
    );
}
