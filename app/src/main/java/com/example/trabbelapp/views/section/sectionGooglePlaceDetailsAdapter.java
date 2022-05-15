package com.example.trabbelapp.views.section;

import android.util.Log;
import android.view.View;
import com.example.trabbelapp.clients.SearchPhotosClient;
import com.example.trabbelapp.models.GooglePlaceSearch.GooglePlaceDetails.GooglePlaceDetails;
import com.example.trabbelapp.models.GooglePlaceSearch.GooglePlaceDetails.LocalResult;

public class sectionGooglePlaceDetailsAdapter extends sectionViewHolder{

    public sectionGooglePlaceDetailsAdapter(View itemView, GooglePlaceDetails details) {
        super(itemView);
        for(LocalResult result: details.getLocalResults()){
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
            if(result.getLinks().getWebsite()!=null)
                super.setWebsite(result.getLinks().getWebsite());
        }
        new SearchPhotosClient(details.getLocalResults().get(0).getTitle(), super.getImage());
        Log.e("Adapter activities", super.getTitle().toString());
    }

}
