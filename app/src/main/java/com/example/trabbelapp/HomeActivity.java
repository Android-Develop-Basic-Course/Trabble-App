package com.example.trabbelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.trabbelapp.clients.ActivitiesClient;
import com.example.trabbelapp.clients.HotelsClient;
import com.example.trabbelapp.models.Activities.Activities;
import com.example.trabbelapp.models.Hotels.Hotels;
import com.example.trabbelapp.models.Token;
import com.example.trabbelapp.clients.FirebaseClient;
import com.example.trabbelapp.recycleview.card.ClickListener;
import com.example.trabbelapp.recycleview.card.cardAdapterActivities;
import com.example.trabbelapp.recycleview.card.cardAdapterHotels;
import com.example.trabbelapp.utils.PreferenceShareTools;
import com.example.trabbelapp.utils.ViewTools;

import io.reactivex.observers.DisposableSingleObserver;

public class HomeActivity extends AppCompatActivity {

    private final String TAG = "LoggingActivity";
    FirebaseClient firebaseClient;
    PreferenceShareTools preferenceShareTools;
    ViewTools viewTools;
    Token token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        preferenceShareTools = new PreferenceShareTools(this);
        firebaseClient = new FirebaseClient(this, TAG);
        viewTools = new ViewTools();

        viewTools.hideSystemUI(getWindow().getDecorView());
        token = new Token();
        token.setAccessToken(preferenceShareTools.getString("API_TOKEN"));
        Log.e("TOKEN-final", token.getAccessToken());

         new ActivitiesClient(this, getActivitiesObserver());
         new HotelsClient(this, getHotelsObserver());


    }

    public DisposableSingleObserver<Hotels> getHotelsObserver(){
        return new DisposableSingleObserver<Hotels>() {
            @Override
            public void onSuccess(Hotels response) {
                // todo - work with the resulting ...

                for(com.example.trabbelapp.models.Hotels.Datum d : response.getData()){
                    Log.e("ACTIVITIES", d.getName());
                }
                RecyclerView recyclerView = findViewById(R.id.cardsViewHotels);
                ClickListener listener = new ClickListener() {
                    @Override
                    public void click(int index){
                        Log.e("PLACE", index + " - " + response.getData().get(index).getName());
                    }
                };
                cardAdapterHotels cAdap = new cardAdapterHotels(response.getData(), getApplication(), listener);
                recyclerView.setAdapter(cAdap);
                LinearLayoutManager HorizontalLayout
                        = new LinearLayoutManager(
                        getApplication(),
                        LinearLayoutManager.HORIZONTAL,
                        false);
                recyclerView.setLayoutManager(HorizontalLayout);
                dispose();
            }

            @Override
            public void onError(Throwable e) {
                // todo - handle the error case ...
                Log.e("TOKEN", e.getMessage());
                dispose();
            }
        };
    }


    public DisposableSingleObserver<Activities> getActivitiesObserver(){
        return new DisposableSingleObserver<Activities>() {
            @Override
            public void onSuccess(Activities response) {
                // todo - work with the resulting ...

                for(com.example.trabbelapp.models.Activities.Datum d : response.getData()){
                    Log.e("ACTIVITIES", d.getName());
                }
                RecyclerView recyclerView = findViewById(R.id.cardsViewActivities);
                ClickListener listener = new ClickListener() {
                    @Override
                    public void click(int index){
                        Log.e("PLACE", index + " - " + response.getData().get(index).getName());
                    }
                };
                cardAdapterActivities cAdap = new cardAdapterActivities(response.getData(), getApplication(), listener);
                recyclerView.setAdapter(cAdap);
                LinearLayoutManager HorizontalLayout
                        = new LinearLayoutManager(
                        getApplication(),
                        LinearLayoutManager.HORIZONTAL,
                        false);
                recyclerView.setLayoutManager(HorizontalLayout);
                dispose();
            }

            @Override
            public void onError(Throwable e) {
                // todo - handle the error case ...
                Log.e("TOKEN", e.getMessage());
                dispose();
            }
        };
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "Destroy");
        //preferenceShareTools.setString("emailUser", "");
        //preferenceShareTools.setString("passwordUser", "");
        //firebaseService.signOutFirebase();
        finish();
    }
}