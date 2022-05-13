package com.example.trabbelapp.views.section.recycleview.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabbelapp.R;

public class cardViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    ImageView image;
    View view;

    public cardViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.cardName);
        image = itemView.findViewById(R.id.cardImage);
        view = itemView;
    }
}
