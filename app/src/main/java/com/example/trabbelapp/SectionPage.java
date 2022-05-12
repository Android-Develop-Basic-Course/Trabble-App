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
        Datum activityCity;
        activityCity = (Datum) viewTools.reciveSerializableMessageFromIntent(this, "activity");
        Log.e(TAG, activityCity.getName());
    }
}