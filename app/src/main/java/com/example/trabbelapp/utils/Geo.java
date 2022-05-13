package com.example.trabbelapp.utils;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Geo {

    public static String getCityByGeoCode(Context context, double lat, double lng){
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        List<Address> addresses = null;
        try {
            if(lat>0 && lng>0)
                addresses = geocoder.getFromLocation(lat, lng, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String cityName = "";
        if (addresses != null) {
            cityName = addresses.get(0).getLocality();
        }
        return cityName;
    }


}
