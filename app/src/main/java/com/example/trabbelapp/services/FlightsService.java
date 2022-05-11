package com.example.trabbelapp.services;


import com.example.trabbelapp.models.Flights.Flights;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface FlightsService {

    @GET("shopping/flight-offers")
    Single<Flights> getFlights(
            @Query("originLocationCode") String originLocationCode,
            @Query("destinationLocationCode") String destinationLocationCode,
            @Query("departureDate") String departureDate,  // Format YYYY-MM-DD
            @Query("adults") int adults, // years old > 12
            @Query("children") int children, // 12 > years old > 2
            @Query("infants") int infants, // years old < 2
            @Header("Authorization") String authBearer
    );
}
