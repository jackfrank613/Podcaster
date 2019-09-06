package com.tech_613.podcast.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tech_613.podcast.R;
import com.tech_613.podcast.model.SearchModel;
import com.tech_613.podcast.utils.PreferenceManager;

import java.util.ArrayList;
import java.util.Collections;

public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.ViewHolder> {

    Context context;
    ArrayList<SearchModel> searchModels;

    public SearchListAdapter(Context context,ArrayList<SearchModel> searchModels){
        this.context=context;
        this.searchModels=searchModels;
    }

    public void setFilter(ArrayList<SearchModel> newList)
    {
            searchModels=new ArrayList<>();
            searchModels.addAll(newList);
            notifyDataSetChanged();

    }
    @NonNull
    @Override
    public SearchListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(context).inflate(R.layout.search_item,viewGroup,false);
        return new SearchListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchListAdapter.ViewHolder viewHolder, int i) {
        SearchModel searchModel=searchModels.get(i);
        viewHolder.top_image.setImageResource(searchModel.getTop_image());
        viewHolder.txt_topic.setText(searchModel.getTop_topic());
        viewHolder.txt_body.setText(searchModel.getTop_body());

        if(PreferenceManager.getThem()==1)
        {
            viewHolder.txt_body.setTextColor(ContextCompat.getColor(context,R.color.white));
            viewHolder.txt_topic.setTextColor(ContextCompat.getColor(context,R.color.white));

        }
        else {
            viewHolder.txt_body.setTextColor(ContextCompat.getColor(context,R.color.font_title));
            viewHolder.txt_topic.setTextColor(ContextCompat.getColor(context,R.color.font_title));
        }
    }

    @Override
    public int getItemCount() {
        return searchModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView top_image;
        TextView txt_topic,txt_body;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            top_image=itemView.findViewById(R.id.top_image);
            txt_topic=itemView.findViewById(R.id.top_title);
            txt_body=itemView.findViewById(R.id.top_body);

        }
    }
}
