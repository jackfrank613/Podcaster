package com.tech_613.podcast.adpter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.content.ContextCompat;
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
import com.tech_613.podcast.utils.PreferenceManager;

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

         viewHolder.txt_title.setText(episodeModel.getTitle());
         viewHolder.txt_time.setText(episodeModel.getTime());
         viewHolder.txt_author.setText(episodeModel.getAuthor());
         if(PreferenceManager.getThem()==1){

             viewHolder.txt_title.setTextColor(ContextCompat.getColor(context,R.color.white));
             viewHolder.txt_time.setTextColor(ContextCompat.getColor(context,R.color.white));
             viewHolder.txt_author.setTextColor(ContextCompat.getColor(context,R.color.white));
             viewHolder.img_down.setImageResource(R.drawable.yellow_download);
            // viewHolder.epi_item_background.setBackgroundColor(ContextCompat.getColor(context,R.color.dark));
         }
         else{
             viewHolder.txt_title.setTextColor(ContextCompat.getColor(context,R.color.dark));
             viewHolder.txt_time.setTextColor(ContextCompat.getColor(context,R.color.dark));
             viewHolder.txt_author.setTextColor(ContextCompat.getColor(context,R.color.dark));
             viewHolder.img_down.setImageResource(R.drawable.ic_d_load);
            // viewHolder.epi_item_background.setBackgroundColor(ContextCompat.getColor(context,R.color.white));
         }

         viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 final View bottomSheetLayout =LayoutInflater.from(context).inflate(R.layout.bottom_sheet_dialog, null);
                 final BottomSheetDialog mBottomSheetDialog = new BottomSheetDialog(context);
                 mBottomSheetDialog.setContentView(bottomSheetLayout);
                 ConstraintLayout layout=mBottomSheetDialog.findViewById(R.id.bottom_background);
                 TextView txt_descrition=mBottomSheetDialog.findViewById(R.id.textView43);
                 TextView txt_title=mBottomSheetDialog.findViewById(R.id.textView51);
                 TextView txt_web=mBottomSheetDialog.findViewById(R.id.textView54);
                 TextView txt_twiter=mBottomSheetDialog.findViewById(R.id.textView55);
                 View view=mBottomSheetDialog.findViewById(R.id.bottom_view);
                 ImageView image_play=mBottomSheetDialog.findViewById(R.id.imageView25);
                 if(PreferenceManager.getThem()==1)
                 {
                     layout.setBackgroundResource(R.drawable.bottom_dark_drawble);
                     txt_descrition.setTextColor(ContextCompat.getColor(context,R.color.white));
                     txt_title.setTextColor(ContextCompat.getColor(context,R.color.white));
                     txt_web.setTextColor(ContextCompat.getColor(context,R.color.yellow));
                     txt_twiter.setTextColor(ContextCompat.getColor(context,R.color.yellow));
                     view.setBackgroundColor(ContextCompat.getColor(context,R.color.white));
                     image_play.setImageResource(R.drawable.ic_yellow_play);
                 }
                 else {
                     layout.setBackgroundResource(R.drawable.bottom_background);
                     txt_descrition.setTextColor(ContextCompat.getColor(context,R.color.dark));
                     txt_title.setTextColor(ContextCompat.getColor(context,R.color.dark));
                     txt_web.setTextColor(ContextCompat.getColor(context,R.color.edit));
                     txt_twiter.setTextColor(ContextCompat.getColor(context,R.color.edit));
                     view.setBackgroundColor(ContextCompat.getColor(context,R.color.dark));
                     image_play.setImageResource(R.drawable.ic_paly_button);
                 }
                 mBottomSheetDialog.show();
//                 ImageView play=bottomSheetLayout.findViewById(R.id.imageView25);
                 image_play.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         context.startActivity(new Intent(context, PlayingActivity.class));
//                         ((Activity)context).finish();
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
        ImageView img_down;
        ConstraintLayout epi_item_background;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_title=itemView.findViewById(R.id.textView42);
            txt_author=itemView.findViewById(R.id.textView45);
            txt_time=itemView.findViewById(R.id.textView46);
            img_down=itemView.findViewById(R.id.imageView18);
            epi_item_background=itemView.findViewById(R.id.epi_item_background);
        }
    }
}
