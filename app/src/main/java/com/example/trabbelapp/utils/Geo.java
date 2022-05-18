package com.example.trabbelapp.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import java.util.Locale;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.trabbelapp.HomeActivity;

import java.io.IOException;
import java.util.List;
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

    public static void getLocationByGPS(Activity activity){
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION)
        != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(activity, new String[] {
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, 100);
        }
        try{
            LocationManager locationManager = (LocationManager) activity
                    .getApplicationContext()
                    .getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    5000,
                    5,
                    (LocationListener) activity);
        }
        catch (Exception ex) {
            Log.e("ERROR", "Error " + ex.getMessage());
        }
    }

    public static void locationChange(Activity activity, Location location, Class<?> target){
        PreferenceShareTools preferenceShareTools = new PreferenceShareTools(activity);
        if(!String.valueOf(location.getLongitude()).equals(preferenceShareTools.getString("lng"))
            && !String.valueOf(location.getLatitude()).equals(preferenceShareTools.getString("lat"))){
            Log.e("Longitude", String.valueOf(location.getLongitude()));
            Log.e("Latitude", String.valueOf(location.getLatitude()));
            preferenceShareTools.setString("lat", String.valueOf(location.getLatitude()));
            preferenceShareTools.setString("lng", String.valueOf(location.getLongitude()));
            if(target!=null)
                new ViewTools().changeView(activity, target);
        }
    }

    public static void locationLastLocation(Activity activity){
        double lat = 0;
        double lng = 0;
        PreferenceShareTools preferenceShareTools = new PreferenceShareTools(activity);
        LocationManager locationManager = (LocationManager) activity
                .getApplicationContext()
                .getSystemService(Context.LOCATION_SERVICE);
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(activity, new String[] {
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, 100);
        }
        Location locationGPS = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (locationGPS != null) {
            lat = locationGPS.getLatitude();
            lng = locationGPS.getLongitude();
        }

        String latitude = String.valueOf(lat);
        String longitude = String.valueOf(lng);
        preferenceShareTools.setString("lat", latitude);
        preferenceShareTools.setString("lng", longitude);
    }

}
