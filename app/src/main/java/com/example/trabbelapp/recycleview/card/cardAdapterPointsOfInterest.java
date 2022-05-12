package com.example.trabbelapp.recycleview.card;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabbelapp.R;
import com.example.trabbelapp.clients.SearchPhotosClient;
import com.example.trabbelapp.models.PointsOfInterest.Datum;
import com.example.trabbelapp.utils.StringTools;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class cardAdapterPointsOfInterest extends RecyclerView.Adapter<cardViewHolder> {
    List<Datum> PointsOfInterestList;
    Context context;
    ClickListener listenerEvent;

    public cardAdapterPointsOfInterest(List<Datum> list, Context context, ClickListener listen) {
        this.PointsOfInterestList = list;
        this.context = context;
        this.listenerEvent = listen;
    }

    @NonNull
    @Override
    public cardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context
                = parent.getContext();
        LayoutInflater inflater
                = LayoutInflater.from(context);

        View cardView
                = inflater
                .inflate(R.layout.viewcard,
                        parent, false);

        return new cardViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull cardViewHolder holder, int position) {
        final int index = holder.getAbsoluteAdapterPosition();
        String name = PointsOfInterestList.get(position).getName();
        Double lat = PointsOfInterestList.get(position).getGeoCode().getLatitude();
        Double lng = PointsOfInterestList.get(position).getGeoCode().getLongitude();
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        List<Address> addresses = null;
        try {
            addresses = geocoder.getFromLocation(lat, lng, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String cityName = "";
        if (addresses != null) {
            cityName = addresses.get(0).getLocality();
        }
        holder.name.setText(name);
        new SearchPhotosClient(StringTools.strip(name) + " " + StringTools.strip(cityName), holder.image);
        holder.view.setOnClickListener(view -> listenerEvent.click(index));
    }

    @Override
    public int getItemCount() {
        return PointsOfInterestList.size();
    }

    @Override
    public void onAttachedToRecyclerView(
            @NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
