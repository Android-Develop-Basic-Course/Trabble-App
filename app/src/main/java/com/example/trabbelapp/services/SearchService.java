package com.example.trabbelapp.services;

import com.example.trabbelapp.models.Photos.Photos;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchService {
    @GET("search.json")
    Single<Photos> getSearchPhotos(
            @Query("engine") String engine,
            @Query("where") String where,
            @Query("query") String query,
            @Query("num") int num_queries,
            @Query("api_key") String api_key
    );
}
