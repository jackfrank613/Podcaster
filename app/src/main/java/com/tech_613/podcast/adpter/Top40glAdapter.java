package com.tech_613.podcast.adpter;

import android.content.Context;
import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tech_613.podcast.R;
import com.tech_613.podcast.model.Top40glModel;

import java.util.ArrayList;

public class Top40glAdapter extends RecyclerView.Adapter<Top40glAdapter.ViewHolder> {

    Context context;
    ArrayList<Top40glModel> top40glModels;
    public Top40glAdapter(Context context,ArrayList<Top40glModel> top40glModels){
        this.context=context;
        this.top40glModels=top40glModels;
    }
    @NonNull
    @Override
    public Top40glAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view= LayoutInflater.from(context).inflate(R.layout.top40_gl_item,viewGroup,false);
       return new Top40glAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Top40glAdapter.ViewHolder viewHolder, int i) {

        Top40glModel top40glModel=top40glModels.get(i);
        viewHolder.top_image.setImageResource(top40glModel.getTop_image());
        viewHolder.txt_No.setText(top40glModel.getTop_number());
        viewHolder.txt_topic.setText(top40glModel.getTop_topic());
        viewHolder.txt_body.setText(top40glModel.getTop_body());

    }

    @Override
    public int getItemCount() {
        return top40glModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView top_image;
        TextView txt_No,txt_topic,txt_body;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_No=itemView.findViewById(R.id.number);
            top_image=itemView.findViewById(R.id.top_image);
            txt_topic=itemView.findViewById(R.id.top_title);
            txt_body=itemView.findViewById(R.id.top_body);

        }
    }
}
