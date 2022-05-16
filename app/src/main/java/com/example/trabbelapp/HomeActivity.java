package com.example.trabbelapp;

import android.app.Activity;
import android.content.Intent;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabbelapp.clients.ActivitiesClient;
import com.example.trabbelapp.clients.FirebaseClient;
import com.example.trabbelapp.clients.HotelsClient;
import com.example.trabbelapp.clients.PointsOfInterestClient;
import com.example.trabbelapp.models.Activities.Activities;
import com.example.trabbelapp.models.Hotels.Hotels;
import com.example.trabbelapp.models.PointsOfInterest.PointsOfInterest;
import com.example.trabbelapp.models.Token;
import com.example.trabbelapp.utils.Geo;
import com.example.trabbelapp.views.recyclerview.card.ClickListener;
import com.example.trabbelapp.views.recyclerview.card.cardAdapterActivities;
import com.example.trabbelapp.views.recyclerview.card.cardAdapterHotels;
import com.example.trabbelapp.views.recyclerview.card.cardAdapterPointsOfInterest;
import com.example.trabbelapp.utils.PreferenceShareTools;
import com.example.trabbelapp.utils.ViewTools;

import io.reactivex.observers.DisposableSingleObserver;

public class HomeActivity extends AppCompatActivity implements LocationListener {

    private final String TAG = "Home Activity";
    FirebaseClient firebaseClient;
    PreferenceShareTools preferenceShareTools;
    ViewTools viewTools;
    Token token;
    boolean dropdownButton;
    LinearLayout layoutDropDown;
    Animation dropdown;
    Animation dropup;
    Activity actual;
    Button themeModeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        actual = this;
        viewTools = new ViewTools();
        viewTools.hideSystemUI(getWindow().getDecorView());
        Geo.getLocationByGPS(this);

        dropdown = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.dropdown);
        dropup = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.dropup);
        setAnimations();

        findViewById(R.id.homeProfileButton).setOnClickListener(view -> dropdown());
        findViewById(R.id.homeSignOut).setOnClickListener(view -> signOut());
        findViewById(R.id.homeSetting).setOnClickListener(view -> viewTools.changeView(this, Settings.class));

        themeModeButton = findViewById(R.id.homeThemeMode);
        themeModeButton.setOnClickListener(view -> themeMode());

        dropdownButton = false;
        layoutDropDown = findViewById(R.id.homeProfileOptionsLinearLayout);

        preferenceShareTools = new PreferenceShareTools(this);
        firebaseClient = new FirebaseClient(this, TAG);

        token = new Token();
        token.setAccessToken(preferenceShareTools.getString("API_TOKEN"));

        new ActivitiesClient(this, getActivitiesObserver());
        new PointsOfInterestClient(this, getPointsOfInterestObserver());
        new HotelsClient(this, getHotelsObserver());
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

    @Override
    public void onLocationChanged(Location location){
        Geo.locationChange(this, location);
    }

    public DisposableSingleObserver<Activities> getActivitiesObserver() {
        return new DisposableSingleObserver<Activities>() {
            @Override
            public void onSuccess(Activities response) {
                RecyclerView recyclerView = findViewById(R.id.cardsViewActivities);
                ClickListener listener = new ClickListener() {
                    @Override
                    public void click(int index) {
                        Log.e(TAG, "PLACE: " + index + " - " + response.getData().get(index).getName());
                        Intent intent = new Intent(actual, SectionPage.class);
                        intent.putExtra("activity", response.getData().get(index));
                        intent.putExtra("geocode", response.getData().get(index).getGeoCode());
                        actual.startActivity(intent);
                    }
                };

                cardAdapterActivities cAdap;
                if(response.getData().size()>8)
                    cAdap = new cardAdapterActivities(response.getData().subList(0, 7), getApplication(), listener);
                else
                    cAdap = new cardAdapterActivities(response.getData(), getApplication(), listener);

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

    public DisposableSingleObserver<PointsOfInterest> getPointsOfInterestObserver() {
        return new DisposableSingleObserver<PointsOfInterest>() {
            @Override
            public void onSuccess(PointsOfInterest response) {

                RecyclerView recyclerView = findViewById(R.id.homeCardViewPointsOfInterest);
                ClickListener listener = new ClickListener() {
                    @Override
                    public void click(int index) {
                        Log.e(TAG, "PLACE: " + index + " - " + response.getData().get(index).getName());
                        Intent intent = new Intent(actual, SectionPage.class);
                        intent.putExtra("pointofinterest", response.getData().get(index));
                        intent.putExtra("geocode", response.getData().get(index).getGeoCode());
                        actual.startActivity(intent);
                    }
                };
                cardAdapterPointsOfInterest cAdap;
                if(response.getData().size()>8)
                    cAdap = new cardAdapterPointsOfInterest(response.getData().subList(0, 7), getApplication(), listener);
                else
                    cAdap = new cardAdapterPointsOfInterest(response.getData(), getApplication(), listener);
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
                Log.e(TAG, "ERROR: " + e.getMessage());
                dispose();
            }
        };
    }

    public DisposableSingleObserver<Hotels> getHotelsObserver() {
        return new DisposableSingleObserver<Hotels>() {
            @Override
            public void onSuccess(Hotels response) {
                RecyclerView recyclerView = findViewById(R.id.cardsViewHotels);
                ClickListener listener = new ClickListener() {
                    @Override
                    public void click(int index) {
                        Log.e("PLACE", index + " - " + response.getData().get(index).getName());
                        Intent intent = new Intent(actual, SectionPage.class);
                        intent.putExtra("hotel", response.getData().get(index));
                        intent.putExtra("geocode", response.getData().get(index).getGeoCode());
                        actual.startActivity(intent);
                    }
                };

                cardAdapterHotels cAdap;
                if(response.getData().size()>8)
                    cAdap = new cardAdapterHotels(response.getData().subList(0, 7), getApplication(), listener);
                else
                    cAdap = new cardAdapterHotels(response.getData(), getApplication(), listener);

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
    }

    public void signOut() {
        System.err.println("SignOut");
        preferenceShareTools.setString("emailUser", "");
        preferenceShareTools.setString("passwordUser", "");
        firebaseClient.signOutFirebase();
        finish();
        viewTools.changeView(this, MainActivity.class);
    }

    public void dropdown() {
        if (!dropdownButton) {
            layoutDropDown.startAnimation(dropdown);
        } else {
            layoutDropDown.startAnimation(dropup);
        }
        dropdownButton = !dropdownButton;
    }

    public void themeMode(){
        System.err.println("themeMode");
        String mode = preferenceShareTools.getString("themeMode");
        if (mode.isEmpty() || mode.equals("light")){
            preferenceShareTools.setString("themeMode", "dark");
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        }
        else {
            preferenceShareTools.setString("themeMode", "light");
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    public void setAnimations() {
        dropup.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //When the animation was finished, set gone to the view
                layoutDropDown.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        dropdown.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //When the animation start, set visible to the view
                layoutDropDown.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                layoutDropDown.setTranslationY(0f);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}