package com.tech_613.podcast.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tech_613.podcast.R;
import com.tech_613.podcast.model.SubitemModel;

import java.util.ArrayList;

public class SubitemListAdapter extends RecyclerView.Adapter<SubitemListAdapter.ViewHolder> {

    Context context;
    ArrayList<SubitemModel> subitemModels;
    private SeriousListAdapter seriousListAdapter;
    public SubitemListAdapter(Context context,ArrayList<SubitemModel> subitemModels)
    {
        this.context=context;
        this.subitemModels=subitemModels;

    }
    @NonNull
    @Override
    public SubitemListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view= LayoutInflater.from(context).inflate(R.layout.subcategories_item,viewGroup,false);
       return new SubitemListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubitemListAdapter.ViewHolder viewHolder, int i) {

        SubitemModel subitemModel=subitemModels.get(i);
        viewHolder.sub_title.setText(subitemModel.getTitle());
        seriousListAdapter=new SeriousListAdapter(context,subitemModel.getSeriousModel());
        GridLayoutManager gridLayoutManager=new GridLayoutManager(context,3);
        viewHolder.serious_recyclerview.setLayoutManager(gridLayoutManager);
        viewHolder.serious_recyclerview.setAdapter(seriousListAdapter);

    }

    @Override
    public int getItemCount() {
        return subitemModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView sub_title;
        RecyclerView serious_recyclerview;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sub_title=itemView.findViewById(R.id.textView8);
            serious_recyclerview=itemView.findViewById(R.id.item_subcategory);
        }
    }
}
