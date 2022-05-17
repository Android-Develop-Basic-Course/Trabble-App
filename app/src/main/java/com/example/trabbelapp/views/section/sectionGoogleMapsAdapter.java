package com.example.trabbelapp.views.section;

import android.util.Log;
import android.view.View;

import com.example.trabbelapp.clients.SearchPhotosClient;
import com.example.trabbelapp.models.GoogleMapsSearch.LocalResult;


public class sectionGoogleMapsAdapter extends sectionViewHolder {
    public sectionGoogleMapsAdapter(View itemView, LocalResult result) {
        super(itemView);
        if(result.getTitle()!=null)
            super.setTitle(result.getTitle());
        if(result.getDescription()!=null)
            super.setDescription(result.getDescription());
        if(result.getRating()!=null)
            super.setRating(result.getRating().toString());
        if(result.getAddress()!=null)
            super.setAddress(result.getAddress());
        if(result.getHours()!=null)
            super.setHours(result.getHours());
        if(result.getPhone()!=null)
            super.setPhone(result.getPhone());
        if(result.getWebsite()!=null)
            super.setWebsite(result.getWebsite());

        new SearchPhotosClient(result.getTitle(), super.getImage());
        Log.e("Adapter activities", super.getTitle().toString());
    }
}
