package com.example.trabbelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.trabbelapp.models.Activities.Activities;
import com.example.trabbelapp.models.Activities.Datum;
import com.example.trabbelapp.utils.ViewTools;

public class SectionPage extends AppCompatActivity {

    private static final String TAG = "Section Page";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_page);
        ViewTools viewTools = new ViewTools();
        com.example.trabbelapp.models.Activities.Datum activityCity;
        com.example.trabbelapp.models.Hotels.Datum hotelCity;
        com.example.trabbelapp.models.PointsOfInterest.Datum pointofinterestCity;

        activityCity = (com.example.trabbelapp.models.Activities.Datum) viewTools
                .reciveSerializableMessageFromIntent(this, "activity");
        hotelCity = (com.example.trabbelapp.models.Hotels.Datum) viewTools
                .reciveSerializableMessageFromIntent(this, "hotel");
        pointofinterestCity = (com.example.trabbelapp.models.PointsOfInterest.Datum) viewTools
                .reciveSerializableMessageFromIntent(this, "pointofinterest");
        if(activityCity!=null){
            Log.e(TAG, activityCity.getName());

        }
        if (hotelCity!=null){
            Log.e(TAG, hotelCity.getName());
        }
        if (pointofinterestCity!=null){
            Log.e(TAG, pointofinterestCity.getName());
        }

    }

    public void setLayoutActivity(){

    }

    public void setLayoutHotel(){

    }

    public void setLayoutPointOfInterest(){

    }
}