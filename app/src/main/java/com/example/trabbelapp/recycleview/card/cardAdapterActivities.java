package com.example.trabbelapp.recycleview.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabbelapp.R;
import com.example.trabbelapp.models.Activities.Datum;
import com.squareup.picasso.Picasso;

import java.util.List;

public class cardAdapterActivities extends RecyclerView.Adapter<cardViewHolder> {

    List<Datum> activityList;
    Context context;
    ClickListener listenerEvent;

    public cardAdapterActivities(List<Datum> list, Context context, ClickListener listen) {
        this.activityList = list;
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
        holder.name.setText(activityList.get(position).getName());
        Picasso.get().load(activityList.get(position).getPictures().get(0)).into(holder.image);
        holder.view.setOnClickListener(view -> listenerEvent.click(index));
    }

    @Override
    public int getItemCount() {
        return activityList.size();
    }

    @Override
    public void onAttachedToRecyclerView(
            @NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
