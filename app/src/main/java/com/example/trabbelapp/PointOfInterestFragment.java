package com.example.trabbelapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.trabbelapp.clients.GoogleMapsSearchClient;
import com.example.trabbelapp.models.GoogleMapsSearch.GoogleMapsSearch;
import com.example.trabbelapp.models.GoogleMapsSearch.LocalResult;
import com.example.trabbelapp.views.section.sectionAdapter;

import io.reactivex.observers.DisposableSingleObserver;

public class PointOfInterestFragment extends Fragment {


    View view;
    private static final String queryARG = "QUERY";
    String query;

    public PointOfInterestFragment() {
        // Required empty public constructor
    }

    public static PointOfInterestFragment newInstance(String query) {
        PointOfInterestFragment fragment = new PointOfInterestFragment();
        Bundle args = new Bundle();
        args.putString(queryARG, query);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            query = getArguments().getString(queryARG);
            Log.e("PoInterest Fragment", "SUCCESS getArgs - " + query);
        }
        Log.e("PoInterest Fragment", "SUCCESS create - " + query);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_point_of_interest, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        view = getView();
        new GoogleMapsSearchClient().getGoogleMapsSearch(this.getActivity(), getObserver(view), query);
    }

    // Observer

    public DisposableSingleObserver<GoogleMapsSearch> getObserver(View view) {
        return new DisposableSingleObserver<GoogleMapsSearch>() {
            @Override
            public void onSuccess(GoogleMapsSearch response) {
                Log.e("PoInterest Fragment", "SUCCESS response");
                if (response.getLocalResults()!=null){
                    if (!response.getLocalResults().isEmpty()){
                        LocalResult d = response.getLocalResults().get(0);
                        new sectionAdapter(view, d);
                    }
                }
                dispose();
            }

            @Override
            public void onError(Throwable e) {
                // todo - handle the error case ...
                Log.e("ERROR", e.getMessage());
                dispose();
            }
        };
    }
}