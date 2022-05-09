package com.example.trabbelapp.clients;


import android.app.Activity;
import android.util.Log;
import com.example.trabbelapp.models.Token;
import com.example.trabbelapp.services.TokenService;
import com.example.trabbelapp.utils.PreferenceShareTools;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class TokenClient {

    Activity activity;

    public TokenClient(Activity a) {
        RetrofitClient retrofit = new RetrofitClient();
        TokenService tokenService = retrofit.getRetrofit().create(TokenService.class);
        this.activity = a;
        tokenService.getToken(
                "client_credentials",
                "S8GyaQAlFk8babfQB4tuWPtpAJUwQGys",
                "eEOlNyfAEuQmGhMx"
        ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<Token>() {
                    @Override
                    public void onSuccess(Token token_response) {
                        // todo - work with the resulting ...
                        Log.e("TOKEN", token_response.getAccessToken());
                        setAccessCode(token_response.getAccessToken());
                        Log.e("TOKEN_TIME", token_response.getExpiresIn());
                        dispose();
                    }

                    @Override
                    public void onError(Throwable e) {
                        // todo - handle the error case ...
                        Log.e("TOKEN", e.getMessage());
                        dispose();
                    }
                });
    }

    public void setAccessCode(String code){
        PreferenceShareTools preferenceShareTools;
        preferenceShareTools = new PreferenceShareTools(this.activity);
        preferenceShareTools.setString("API_TOKEN", code);
    }
}
