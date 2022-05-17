package com.example.trabbelapp;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.trabbelapp.clients.GooglePlaceClient;
import com.example.trabbelapp.models.GooglePlaceSearch.GooglePlaceDetails.GooglePlaceDetails;
import com.example.trabbelapp.models.GooglePlaceSearch.GooglePlaceDetails.LocalResult;
import com.example.trabbelapp.models.GooglePlaceSearch.GooglePlaceSearch;
import com.example.trabbelapp.views.section.sectionGooglePlaceDetailsAdapter;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import io.reactivex.observers.DisposableSingleObserver;

public class PointOfInterestFragment extends Fragment {


    View view;
    private static final String queryARG = "QUERY";
    String query;
    Activity activity;

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
        activity = this.getActivity();
        new GooglePlaceClient()
                .getGooglePlaceSearch(activity, getObserverPlaceSearch(view, activity), query);
                //.getGooglePlaceDetails(this.getActivity(), getObserverPlaceDetails(view), query);
    }

    // Observers

    public DisposableSingleObserver<GooglePlaceSearch> getObserverPlaceSearch(View view, Activity activity) {
        return new DisposableSingleObserver<GooglePlaceSearch>() {
            @Override
            public void onSuccess(GooglePlaceSearch response) {
                Log.e("PoInterest Fragment", "SUCCESS response");
                Log.e("Pointerest Response", String.valueOf(response.getLocalResults()==null));
                if (response.getLocalResults()!=null){
                    String lsig = "";
                    String ludocid = "";
                    Uri uri = Uri.parse(response.getLocalResults().get(0).getPlaceIdSearch());
                    try {
                        lsig = URLDecoder.decode(uri.getQueryParameter("lsig"), "UTF-8");
                        ludocid = URLDecoder.decode(uri.getQueryParameter("ludocid"), "UTF-8");
                    } catch (UnsupportedEncodingException exception) {
                        Log.e("ERROR: ", exception.getMessage());
                    }
                    Log.e("Extract URL", lsig + " - " + ludocid);
                    new GooglePlaceClient().getGooglePlaceDetailsByULR(activity, getObserverPlaceDetails(view), lsig, ludocid, response.getSearchInformation().getQueryDisplayed());
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

    public DisposableSingleObserver<GooglePlaceDetails> getObserverPlaceDetails(View view) {
        return new DisposableSingleObserver<GooglePlaceDetails>() {
            @Override
            public void onSuccess(GooglePlaceDetails response) {
                Log.e("PoInterest Fragment", "SUCCESS response");
                Log.e("Pointerest Response", String.valueOf(response.getLocalResults()==null));
                if (response.getLocalResults()!=null){
                    new sectionGooglePlaceDetailsAdapter(view, response);
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