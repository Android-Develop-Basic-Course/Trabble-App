package com.example.trabbelapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.trabbelapp.models.PointsOfInterest.GeoCode;
import com.example.trabbelapp.utils.Geo;
import com.example.trabbelapp.utils.StringTools;
import com.example.trabbelapp.utils.ViewTools;


public class SectionPage extends AppCompatActivity {

    private static final String TAG = "Section Page";
    ViewTools viewTools;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_section_page);
        viewTools = new ViewTools();
        viewTools.hideSystemUI(getWindow().getDecorView());

        com.example.trabbelapp.models.Activities.Datum activityCity;
        com.example.trabbelapp.models.Hotels.Datum hotelCity;
        com.example.trabbelapp.models.PointsOfInterest.Datum pointofinterestCity;
        activityCity = (com.example.trabbelapp.models.Activities.Datum) viewTools
                .reciveParcelableMessageFromIntent(this, "activity");
        hotelCity = (com.example.trabbelapp.models.Hotels.Datum) viewTools
                .reciveParcelableMessageFromIntent(this, "hotel");
        pointofinterestCity = (com.example.trabbelapp.models.PointsOfInterest.Datum) viewTools
                .reciveParcelableMessageFromIntent(this, "pointofinterest");
        pointofinterestCity = (com.example.trabbelapp.models.PointsOfInterest.Datum) viewTools
                .reciveParcelableMessageFromIntent(this, "pointofinterest");

        findViewById(R.id.sectionBackButton).setOnClickListener(view -> {
            viewTools.changeView(this, HomeActivity.class);
        });

        if(activityCity!=null){
            com.example.trabbelapp.models.Activities.GeoCode geoCode =
                    (com.example.trabbelapp.models.Activities.GeoCode) viewTools
                            .reciveParcelableMessageFromIntent(this, "geocode");
            Log.e(TAG, activityCity.getName());
            double lat = -1;
            double lng = -1;
            if (geoCode!=null){
                lat = Double.parseDouble(geoCode.getLatitude());
                lng = Double.parseDouble(geoCode.getLongitude());
                Log.e("Geocode Long", geoCode.getLongitude());
            }
            Log.e("GeoCode", lat + " - " + lng);
            Log.e(TAG, activityCity.getName());
            setLayoutActivity(activityCity.getName() + " " + StringTools.strip(Geo.getCityByGeoCode(this, lat, lng)));
        }
        if (hotelCity!=null){
            com.example.trabbelapp.models.Hotels.GeoCode geoCode =
                    (com.example.trabbelapp.models.Hotels.GeoCode) viewTools
                            .reciveParcelableMessageFromIntent(this, "geocode");
            Log.e(TAG, hotelCity.getName());
            double lat = -1;
            double lng = -1;
            if (geoCode!=null){
                lat = Double.parseDouble(geoCode.getLatitude());
                lng = Double.parseDouble(geoCode.getLongitude());
                Log.e("Geocode Long", geoCode.getLongitude());
            }
            Log.e("GeoCode", lat + " - " + lng);
            setLayoutHotel(hotelCity.getName() + " " + StringTools.strip(Geo.getCityByGeoCode(this, lat, lng)));
        }
        if (pointofinterestCity!=null){
            com.example.trabbelapp.models.PointsOfInterest.GeoCode geoCode =
                    (com.example.trabbelapp.models.PointsOfInterest.GeoCode) viewTools
                            .reciveParcelableMessageFromIntent(this, "geocode");
            Log.e(TAG, pointofinterestCity.getName());
            double lat = -1;
            double lng = -1;
            if (geoCode!=null){
                lat = Double.parseDouble(geoCode.getLatitude());
                lng = Double.parseDouble(geoCode.getLongitude());
                Log.e("Geocode Long", geoCode.getLongitude());
            }
            Log.e("GeoCode", lat + " - " + lng);
            String city = StringTools.strip(Geo.getCityByGeoCode(this, lat, lng));
            setLayoutPointOfInterest(pointofinterestCity.getName() + " " + city);
        }

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        viewTools.hideSystemUI(getWindow().getDecorView());
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewTools.hideSystemUI(getWindow().getDecorView());
    }

    // Set Layouts para cada una de las actividades

    public void setLayoutActivity(String query){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.sectionFragmentContainerView, ActivityFragment.newInstance(query)).commit();
    }

    public void setLayoutHotel(String query){
        getSupportFragmentManager()
                .beginTransaction()
                        .replace(R.id.sectionFragmentContainerView, HotelFragment.newInstance(query)).commit();

    }

    public void setLayoutPointOfInterest(String query){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.sectionFragmentContainerView, PointOfInterestFragment.newInstance(query)).commit();
    }
}