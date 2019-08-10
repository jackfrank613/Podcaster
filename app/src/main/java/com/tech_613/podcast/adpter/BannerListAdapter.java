package com.tech_613.podcast.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tech_613.podcast.R;
import com.tech_613.podcast.model.BannerModel;

import java.util.ArrayList;

public class BannerListAdapter extends RecyclerView.Adapter<BannerListAdapter.ViewHolder> {
    Context context;
    ArrayList<BannerModel> bannerModels;
    public BannerListAdapter(Context context,ArrayList<BannerModel> bannerModels){
        this.context=context;
        this.bannerModels=bannerModels;

    }

    @NonNull
    @Override
    public BannerListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.banner_item,viewGroup,false);
        return new BannerListAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull BannerListAdapter.ViewHolder viewHolder, int i) {
       BannerModel bannerModel=bannerModels.get(i);
       viewHolder.banner.setImageResource(bannerModel.getBanner());
       if(i==2)viewHolder.banner.setVisibility(View.GONE);

    }

    @Override
    public int getItemCount() {
        return bannerModels.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

         ImageView banner;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            banner=itemView.findViewById(R.id.banner_image);
        }
    }
}
