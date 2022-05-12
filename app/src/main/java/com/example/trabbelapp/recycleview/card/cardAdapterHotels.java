package com.example.trabbelapp.recycleview.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabbelapp.R;
import com.example.trabbelapp.clients.SearchPhotosClient;
import com.example.trabbelapp.models.Hotels.Datum;

import java.util.List;

public class cardAdapterHotels extends RecyclerView.Adapter<cardViewHolder> {

    List<Datum> hotelsList;
    Context context;
    ClickListener listenerEvent;

    public cardAdapterHotels(List<Datum> list, Context context, ClickListener listen) {
        this.hotelsList = list;
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
        String name = hotelsList.get(position).getName();
        holder.name.setText(name);
        new SearchPhotosClient(name, holder.image);
        holder.view.setOnClickListener(view -> listenerEvent.click(index));
    }

    @Override
    public int getItemCount() {
        return hotelsList.size();
    }

    @Override
    public void onAttachedToRecyclerView(
            @NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
