package com.tech_613.podcast.adpter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tech_613.podcast.R;
import com.tech_613.podcast.fragment.EpisodeFragment;
import com.tech_613.podcast.model.TopModel;
import com.tech_613.podcast.ui.activity.PodcastChannelActivity;
import com.tech_613.podcast.utils.PreferenceManager;

import java.util.ArrayList;

import static android.content.Context.WINDOW_SERVICE;

public class TopListAdapter extends RecyclerView.Adapter<TopListAdapter.ViewHolder> {
    private static int ITEM_WIDTH = 0;
    private static int ITEM_HEIGHT = 0;
    public Context context;
    private ArrayList<TopModel> topModels;
    onItemClickListner onItemClickListner;

    public void setOnItemClickListner(onItemClickListner onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }

    public interface onItemClickListner{
        void onClick();//pass your object types.
    }


    public TopListAdapter(Context context,ArrayList<TopModel> topModels){
        this.context=context;
        this.topModels=topModels;

        WindowManager wm = (WindowManager) context.getSystemService(WINDOW_SERVICE);
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        ITEM_WIDTH = (displayMetrics.widthPixels-dp2px(context, (int)72))/3;
        ITEM_HEIGHT = (int) (ITEM_WIDTH*1.6);
    }

    @NonNull
    @Override
    public TopListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.top_category_item,viewGroup,false);
        return new TopListAdapter.ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull TopListAdapter.ViewHolder viewHolder, int i) {
        TopModel topModel=topModels.get(i);
        viewHolder.imageView.setImageResource(topModel.getTop_image());
        viewHolder.txt_title.setText(topModel.getTitle());
//        viewHolder.txt_title.setTextColor(Color.WHITE);
        viewHolder.txt_body.setText(topModel.getBody());
//        viewHolder.txt_body.setTextColor(Color.WHITE);
//        viewHolder.txt_body.setAlpha((float) 0.7);

         if(PreferenceManager.getThem()==1){
             viewHolder.txt_title.setTextColor(Color.WHITE);
             viewHolder.txt_body.setTextColor(Color.WHITE);
             viewHolder.txt_body.setAlpha((float) 0.7);
         }
         else {
             viewHolder.txt_title.setTextColor(ContextCompat.getColor(context,R.color.font_title));
             viewHolder.txt_body.setTextColor(ContextCompat.getColor(context,R.color.font_title));
             viewHolder.txt_body.setAlpha((float) 0.7);
         }

//        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) viewHolder.itemView.getLayoutParams();
//        layoutParams.width=ITEM_WIDTH;
//        layoutParams.height=ITEM_HEIGHT;
//        if(i==2)layoutParams.leftMargin=dp2px(context,12);
//        else if(i==1)layoutParams.leftMargin=dp2px(context,6);
//        viewHolder.itemView.setLayoutParams(layoutParams);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,"topchannel",Toast.LENGTH_SHORT).show();
//                context.startActivity(new Intent(context, PodcastChannelActivity.class));
//                ((Activity)context).finish();
                onItemClickListner.onClick();


            }
        });
    }

    @Override
    public int getItemCount() {
        return topModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

         private ImageView imageView;
         private TextView txt_title,txt_body;
         private ConstraintLayout constraintLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView2);
            txt_title=itemView.findViewById(R.id.textView9);
            txt_body=itemView.findViewById(R.id.textView10);
            constraintLayout=itemView.findViewById(R.id.contraintlayout);
        }
    }
    public static int dp2px(Context context, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics());
    }
}
