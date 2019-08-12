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
import com.tech_613.podcast.model.SubscriptionModel;

import java.util.ArrayList;

public class SubscriptionListAdapter extends RecyclerView.Adapter<SubscriptionListAdapter.ViewHolder> {

    Context context;
    ArrayList<SubscriptionModel> subscriptionModels;
    public SubscriptionListAdapter(Context context,ArrayList<SubscriptionModel> subscriptionModels){
        this.context=context;
        this.subscriptionModels=subscriptionModels;
    }
    @NonNull
    @Override
    public SubscriptionListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.subscript_item,viewGroup,false);
        return new SubscriptionListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubscriptionListAdapter.ViewHolder viewHolder, int i) {

        SubscriptionModel subscriptionModel=subscriptionModels.get(i);
        viewHolder.sub_image.setImageResource(subscriptionModel.getTop_image());
        viewHolder.txt_topic.setText(subscriptionModel.getTitle());
        viewHolder.txt_body.setText(subscriptionModel.getBody());
    }

    @Override
    public int getItemCount() {
        return subscriptionModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView sub_image;
        private TextView txt_topic;
        private TextView txt_body;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sub_image=itemView.findViewById(R.id.imageView2);
            txt_topic=itemView.findViewById(R.id.textView9);
            txt_body=itemView.findViewById(R.id.textView10);
        }
    }
}
