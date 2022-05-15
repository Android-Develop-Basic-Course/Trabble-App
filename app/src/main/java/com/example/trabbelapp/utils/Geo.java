package com.example.trabbelapp.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class Geo {

    public static String getCityByGeoCode(Context context, double lat, double lng) {
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        List<Address> addresses = null;
        try {
            if (lat > 0 && lng > 0)
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

    public static Map<String, Double> getGeoCodeByMobile(Activity activity) {
        LocationManager locManager;
        Location location = null;
        double latitude = -1, longitude = -1;
        locManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            location = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        }
        if(location!=null)
        {

            latitude = location.getLatitude();
            longitude = location.getLongitude();
        }
        Map<String, Double> geoCode = new HashMap<>();
        geoCode.put("lat", latitude);
        geoCode.put("lng", longitude);
        return geoCode;
    }
}
