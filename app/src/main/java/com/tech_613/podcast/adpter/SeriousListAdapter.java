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
import com.tech_613.podcast.model.SeriousModel;
import com.tech_613.podcast.utils.PreferenceManager;

import java.util.ArrayList;

public class SeriousListAdapter extends RecyclerView.Adapter<SeriousListAdapter.ViewHolder>{

    public Context context;
    ArrayList<SeriousModel> seriousModels;
    public SeriousListAdapter(Context context,ArrayList<SeriousModel> seriousModels){
        this.context=context;
        this.seriousModels=seriousModels;

    }

    @NonNull
    @Override
    public SeriousListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.serious_category_item,viewGroup,false);
        return new SeriousListAdapter.ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull SeriousListAdapter.ViewHolder viewHolder, int i) {
        SeriousModel seriousModel=seriousModels.get(i);
        viewHolder.txt_body.setText(seriousModel.getS_body());
//        viewHolder.txt_body.setTextColor(Color.WHITE);
//        viewHolder.txt_body.setAlpha((float) 0.7);
        viewHolder.txt_title.setText(seriousModel.getS_title());
//        viewHolder.txt_title.setTextColor(Color.WHITE);
        viewHolder.imageView.setImageResource(seriousModel.getSerious_image());
        if(PreferenceManager.getThem()==1){
                    viewHolder.txt_body.setTextColor(Color.WHITE);
                    viewHolder.txt_title.setTextColor(Color.WHITE);
                    viewHolder.txt_body.setAlpha((float) 0.7);
        }
        else {
            viewHolder.txt_body.setTextColor(ContextCompat.getColor(context,R.color.font_title));
            viewHolder.txt_title.setTextColor(ContextCompat.getColor(context,R.color.font_title));
            viewHolder.txt_body.setAlpha((float) 0.7);
        }
    }

    @Override
    public int getItemCount() {
        return seriousModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView txt_title,txt_body;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView2);
            txt_title=itemView.findViewById(R.id.textView9);
            txt_body=itemView.findViewById(R.id.textView10);
        }
    }
}
