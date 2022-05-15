package com.example.trabbelapp.views.section;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trabbelapp.R;
import com.squareup.picasso.Picasso;

public class sectionViewHolder{
    TextView title;
    TextView description;
    TextView rating;
    TextView address;
    TextView hours;
    TextView phone;
    TextView website;
    ImageView image;
    View view;

    public sectionViewHolder(View itemView) {
        Log.e("item get", "title");
        title = itemView.findViewById(R.id.sectionTitle);
        Log.e("item get", "description");
        description = itemView.findViewById(R.id.sectionDescription);
        Log.e("item get", "rating");
        rating = itemView.findViewById(R.id.sectionRating);
        Log.e("item get", "address");
        address = itemView.findViewById(R.id.sectionAddress);
        Log.e("item get", "hours");
        hours = itemView.findViewById(R.id.sectionHours);
        Log.e("item get", "phone");
        phone = itemView.findViewById(R.id.sectionPhone);
        Log.e("item get", "website");
        website = itemView.findViewById(R.id.sectionWebsite);
        Log.e("item get", "image");
        image = itemView.findViewById(R.id.sectionImage);
        view = itemView;
    }

    public TextView getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(!title.isEmpty())
            this.title.setText(title);
    }

    public TextView getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description!=null)
            this.description.setText(description);
    }

    public TextView getRating() {
        return rating;
    }

    public void setRating(String rating) {
        if(rating!=null)
            this.rating.setText(rating);
    }

    public TextView getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if(address!=null)
            this.address.setText(address);
    }

    public TextView getHours() {
        return hours;
    }

    public void setHours(String hours) {
        if(hours!=null)
        this.hours.setText(hours);
    }

    public TextView getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if(phone!=null)
            this.phone.setText(phone);
    }

    public TextView getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        if(website!=null)
            this.website.setText(website);
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(String imageUrl) {
        if(imageUrl!=null)
            Picasso.get().load(imageUrl).into(this.image);
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
