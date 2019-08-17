package com.tech_613.podcast.adpter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tech_613.podcast.R;
import com.tech_613.podcast.fragment.DownloadFragment;
import com.tech_613.podcast.model.DownloadModel;
import com.tech_613.podcast.utils.PreferenceManager;

import java.util.ArrayList;

public class DownloadListAdapter extends RecyclerView.Adapter<DownloadListAdapter.ViewHolder> {

    Context context;
    ArrayList<DownloadModel> downloadModels;

    public DownloadListAdapter (Context context,ArrayList<DownloadModel> downloadModels){
        this.context=context;
        this.downloadModels=downloadModels;

    }
    @NonNull
    @Override
    public DownloadListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view= LayoutInflater.from(context).inflate(R.layout.download_item,viewGroup,false);

       return new DownloadListAdapter.ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull DownloadListAdapter.ViewHolder viewHolder, int i) {

        DownloadModel downloadModel=downloadModels.get(i);


        viewHolder.txt_body.setText(downloadModel.getTop_body());
        viewHolder.txt_topic.setText(downloadModel.getTop_topic());
        viewHolder.down_image.setImageResource(downloadModel.getTop_image());

        if(PreferenceManager.getThem()==1){
            viewHolder.txt_body.setTextColor(ContextCompat.getColor(context,R.color.white));
            viewHolder.txt_topic.setTextColor(ContextCompat.getColor(context,R.color.white));
            if(downloadModel.getCheck())
            {
                viewHolder.txt_time.setTextColor(ContextCompat.getColor(context, R.color.timecolor));
                viewHolder.txt_time.setText("44%");

            }
            else {
                viewHolder.txt_time.setTextColor(ContextCompat.getColor(context,R.color.white));
                viewHolder.txt_time.setAlpha((float) 0.7);
                viewHolder.txt_time.setText(downloadModel.getTop_number());
            }

        }
        else {
            viewHolder.txt_body.setTextColor(ContextCompat.getColor(context,R.color.font_title));
            viewHolder.txt_topic.setTextColor(ContextCompat.getColor(context,R.color.font_title));
            if(downloadModel.getCheck())
            {
                viewHolder.txt_time.setTextColor(ContextCompat.getColor(context, R.color.timecolor));
                viewHolder.txt_time.setText("44%");

            }
            else {
                viewHolder.txt_time.setTextColor(ContextCompat.getColor(context,R.color.font_title));
                viewHolder.txt_time.setAlpha((float) 0.7);
                viewHolder.txt_time.setText(downloadModel.getTop_number());
            }
        }

    }

    @Override
    public int getItemCount() {
        return downloadModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView down_image;
        private TextView txt_topic,txt_body,txt_time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            down_image=itemView.findViewById(R.id.top_image);
            txt_topic=itemView.findViewById(R.id.top_title);
            txt_body=itemView.findViewById(R.id.top_body);
            txt_time=itemView.findViewById(R.id.txt_ime);
        }
    }
}
