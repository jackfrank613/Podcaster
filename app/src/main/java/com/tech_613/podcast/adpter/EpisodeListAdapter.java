package com.tech_613.podcast.adpter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tech_613.podcast.R;
import com.tech_613.podcast.model.EpisodeModel;
import com.tech_613.podcast.ui.activity.PlayingActivity;
import com.tech_613.podcast.ui.activity.PodcastChannelActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class EpisodeListAdapter extends RecyclerView.Adapter<EpisodeListAdapter.ViewHolder> {

    Context context;
    ArrayList<EpisodeModel> episodeModels;

    public EpisodeListAdapter(Context context,ArrayList<EpisodeModel> episodeModels){
        this.context=context;
        this.episodeModels=episodeModels;

    }
    @NonNull
    @Override
    public EpisodeListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_episode_item,viewGroup,false);
        return new EpisodeListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodeListAdapter.ViewHolder viewHolder, int i) {

         EpisodeModel episodeModel=episodeModels.get(i);

         viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 final View bottomSheetLayout =LayoutInflater.from(context).inflate(R.layout.bottom_sheet_dialog, null);
                 final BottomSheetDialog mBottomSheetDialog = new BottomSheetDialog(context);
                 mBottomSheetDialog.setContentView(bottomSheetLayout);
                 mBottomSheetDialog.show();
                 ImageView play=bottomSheetLayout.findViewById(R.id.imageView25);
                 play.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         context.startActivity(new Intent(context, PlayingActivity.class));
                         ((Activity)context).finish();
                         mBottomSheetDialog.dismiss();
                     }
                 });
             }
         });

    }

    @Override
    public int getItemCount() {
        return episodeModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txt_title,txt_author,txt_time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_title=itemView.findViewById(R.id.textView42);
            txt_author=itemView.findViewById(R.id.textView45);
            txt_time=itemView.findViewById(R.id.textView46);
        }
    }
}
