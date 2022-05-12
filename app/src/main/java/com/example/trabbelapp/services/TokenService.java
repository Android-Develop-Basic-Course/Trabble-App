package com.example.trabbelapp.services;


import com.example.trabbelapp.models.Token;
import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface TokenService {
    @POST("security/oauth2/token")
    @FormUrlEncoded
    Single<Token> getToken(
            @Field("grant_type") String granType,
            @Field("client_id") String userId,
            @Field("client_secret") String userPassword
    );
}
