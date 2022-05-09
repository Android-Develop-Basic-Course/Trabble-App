package com.example.trabbelapp.clients;

import android.util.Log;
import android.widget.ImageView;

import com.example.trabbelapp.models.Photos.Photos;
import com.example.trabbelapp.services.SearchService;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class SearchPhotosClient {

    public SearchPhotosClient(String query, ImageView image) {


        Map<String, String> parameter = new HashMap<>();

        parameter.put("engine", "naver");
        parameter.put("where", "image");
        parameter.put("query", "Coffee");
        parameter.put("api_key", "7e0edca45847bf6ad380ae3dcb8c73bbd3164a5ddd752833bd5026b4c4508dea");

        RetrofitClient retrofit = new RetrofitClient();
        SearchService searchService = retrofit.getRetrofitSerpAPI().create(SearchService.class);
        Log.e("PHOTOS", "INITIALIZATION SERAPI - query: " + query);
        searchService.getSearchPhotos(
                "naver",
                "image",
                query,
                2,
                "ec9e3b8ff6e5443db7de345d0a551f5641e42d4df1a604ff690a0a2005460646"
        ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        get(image)
                );
    }

    public DisposableSingleObserver<Photos> get(ImageView image) {
        return new DisposableSingleObserver<Photos>() {
            @Override
            public void onSuccess(Photos response) {
                // todo - work with the resulting ...
                if (Integer.parseInt(response.getSearchInformation().getTotalResults()) > 0)
                    Picasso.get().load(response.getImagesResults().get(0).getThumbnail()).into(image);
                dispose();
            }

            @Override
            public void onError(Throwable e) {
                // todo - handle the error case ...
                Log.e("PHOTOS", e.getMessage());
                dispose();
            }
        };

    }
}
