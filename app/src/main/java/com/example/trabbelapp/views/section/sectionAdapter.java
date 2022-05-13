package com.example.trabbelapp.views.section;

import android.util.Log;
import android.view.View;

import com.example.trabbelapp.clients.SearchPhotosClient;
import com.example.trabbelapp.models.GoogleMapsSearch.LocalResult;


public class sectionAdapter extends sectionViewHolder {
    public sectionAdapter(View itemView, LocalResult result) {
        super(itemView);
        super.setTitle(result.getTitle());
        super.setDescription(result.getDescription());
        super.setRating(result.getRating().toString());
        super.setAddress(result.getAddress());
        super.setHours(result.getHours());
        super.setPhone(result.getPhone());
        super.setWebsite(result.getWebsite());
        new SearchPhotosClient(result.getTitle(), super.getImage());
        Log.e("Adapter activities", super.getTitle().toString());
    }
}
