package com.example.trabbelapp.clients;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabbelapp.HomeActivity;
import com.example.trabbelapp.R;
import com.example.trabbelapp.models.Activities.Activities;
import com.example.trabbelapp.models.Activities.Datum;
import com.example.trabbelapp.models.Token;
import com.example.trabbelapp.recycleview.ClickListener;
import com.example.trabbelapp.recycleview.cardAdapter;
import com.example.trabbelapp.services.ActivitiesService;
import com.example.trabbelapp.utils.PreferenceShareTools;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivitiesClient {

    Activity activity;

    public ActivitiesClient(Activity a, DisposableSingleObserver<Activities> ds) {
        this.activity = a;
        RetrofitClient retrofit = new RetrofitClient();
        ActivitiesService activitiesService = retrofit.getRetrofit().create(ActivitiesService.class);
        activitiesService.getActivities(
                41.39, 2.16, 5,
                "Bearer "+ new PreferenceShareTools(this.activity).getString("API_TOKEN")
        ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(ds);
    }
}
