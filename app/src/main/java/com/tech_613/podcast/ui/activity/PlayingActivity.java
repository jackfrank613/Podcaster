package com.tech_613.podcast.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.tech_613.podcast.R;
import com.tech_613.podcast.utils.PreferenceManager;

public class PlayingActivity extends AppCompatActivity {

    private BottomSheetDialog mBottomSheetDialog;
    private ImageView description_iamge,play_button;
    private ImageView image_back;
    private boolean check=true;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(PreferenceManager.getThem()==1)
        {
            setContentView(R.layout.activity_dark_playing);

        }
        else {
            setContentView(R.layout.activity_now_playing);
        }
         description_iamge=findViewById(R.id.imageView28);
         play_button=findViewById(R.id.imageView22);
         image_back=findViewById(R.id.imageView20);
         play_button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if(check)
                 {
                     if(PreferenceManager.getThem()==1)
                     {
                         play_button.setImageResource(R.drawable.ic_yellow_pause);

                     }
                     else {
                         play_button.setImageResource(R.drawable.ic_pause_button);
                     }


                     check=false;
                 }
                 else {
                     if(PreferenceManager.getThem()==1){
                         play_button.setImageResource(R.drawable.ic_yellow_play);
                     }
                     else {
                         play_button.setImageResource(R.drawable.ic_paly_button);
                     }

                     check=true;
                 }
             }
         });


        description_iamge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View bottomSheetLayout = getLayoutInflater().inflate(R.layout.bottom_sheet_dialog, null);
                mBottomSheetDialog = new BottomSheetDialog(PlayingActivity.this);
                mBottomSheetDialog.setContentView(bottomSheetLayout);
                mBottomSheetDialog.show();
            }
        });

        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlayingActivity.this,PodcastChannelActivity.class));
                finish();
            }
        });

    }
}
