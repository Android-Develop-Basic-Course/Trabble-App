package com.example.trabbelapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.trabbelapp.models.PointsOfInterest.PointsOfInterest;
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
                .reciveSerializableMessageFromIntent(this, "activity");
        hotelCity = (com.example.trabbelapp.models.Hotels.Datum) viewTools
                .reciveSerializableMessageFromIntent(this, "hotel");
        pointofinterestCity = (com.example.trabbelapp.models.PointsOfInterest.Datum) viewTools
                .reciveSerializableMessageFromIntent(this, "pointofinterest");


        findViewById(R.id.sectionBackButton).setOnClickListener(view -> {
            viewTools.changeView(this, HomeActivity.class);
        });

        if(activityCity!=null){
            Log.e(TAG, activityCity.getName());
            double lat = -1;
            double lng = -1;
            if (activityCity.getGeoCode()!=null){
                lat = Double.parseDouble(activityCity.getGeoCode().getLatitude());
                lng = Double.parseDouble(activityCity.getGeoCode().getLongitude());
            }
            Log.e(TAG, activityCity.getName());
            setLayoutActivity(activityCity.getName() + " " + StringTools.strip(Geo.getCityByGeoCode(this, lat, lng)));
        }
        if (hotelCity!=null){
            Log.e(TAG, hotelCity.getName());
            double lat = -1;
            double lng = -1;
            if (hotelCity.getGeoCode()!=null){
                lat = Double.parseDouble(hotelCity.getGeoCode().getLatitude());
                lng = Double.parseDouble(hotelCity.getGeoCode().getLongitude());
            }
            setLayoutHotel(hotelCity.getName() + " " + StringTools.strip(Geo.getCityByGeoCode(this, lat, lng)));
        }
        if (pointofinterestCity!=null){
            Log.e(TAG, pointofinterestCity.getName());
            double lat = -1;
            double lng = -1;
            if (pointofinterestCity.getGeoCode()!=null){
                lat = Double.parseDouble(pointofinterestCity.getGeoCode().getLatitude());
                lng = Double.parseDouble(pointofinterestCity.getGeoCode().getLongitude());
            }
            setLayoutPointOfInterest(pointofinterestCity.getName() + " " + StringTools.strip(Geo.getCityByGeoCode(this, lat, lng)));

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