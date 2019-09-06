package com.tech_613.podcast.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tech_613.podcast.R;
import com.tech_613.podcast.model.LocationModel;
import com.tech_613.podcast.utils.PreferenceManager;

import java.util.ArrayList;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ViewHolder> {

    Context context;
    ArrayList<LocationModel> locationModels;
    public LocationAdapter(Context context,ArrayList<LocationModel> locationModels){
        this.context=context;
        this.locationModels=locationModels;

    }

    @NonNull
    @Override
    public LocationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.top_location_item,viewGroup,false);
        return new LocationAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationAdapter.ViewHolder viewHolder, int i) {

        LocationModel locationModel=locationModels.get(i);
        viewHolder.flag_image.setImageResource(locationModel.getFlag());
        viewHolder.txt_country.setText(locationModel.getCountry());
        viewHolder.txt_word.setText(locationModel.getWord());
        if(PreferenceManager.getThem()==1)
        {
            viewHolder.txt_word.setTextColor(ContextCompat.getColor(context,R.color.white));
            viewHolder.txt_country.setTextColor(ContextCompat.getColor(context,R.color.white));
        }
        else {
            viewHolder.txt_word.setTextColor(ContextCompat.getColor(context,R.color.font_title));
            viewHolder.txt_country.setTextColor(ContextCompat.getColor(context,R.color.font_title));
        }

        if(i==2)
        {
            viewHolder.check_image.setImageResource(R.drawable.ic_check);
            viewHolder.check_image.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return locationModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


         ImageView flag_image,check_image;
         TextView txt_country,txt_word;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            flag_image=itemView.findViewById(R.id.top_image);
            check_image=itemView.findViewById(R.id.imageView12);
            txt_country=itemView.findViewById(R.id.textView38);
            txt_word=itemView.findViewById(R.id.textView39);
        }
    }
}
