package com.tech_613.podcast.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tech_613.podcast.MainActivity;
import com.tech_613.podcast.R;
import com.tech_613.podcast.fragment.AboutFragment;
import com.tech_613.podcast.fragment.EpisodeFragment;
import com.tech_613.podcast.fragment.GlobalTop40Fragment;
import com.tech_613.podcast.fragment.LocalTop40Fragment;
import com.tech_613.podcast.fragment.PoadCastFragment;
import com.tech_613.podcast.utils.PreferenceManager;

public class PodcastChannelActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout lin_click1,lin_click2;
    private View view1,view2;
    private TextView txt_local,txt_global;
    private LinearLayout image_arrow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(PreferenceManager.getThem()==1)
        {
            setContentView(R.layout.podcastlist_dark_activity);
        }
        else {
            setContentView(R.layout.activity_channel);
        }
        initXml();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, EpisodeFragment.newInstance()).addToBackStack("tag").commit();

    }
    public void initXml(){
        lin_click1=(LinearLayout)findViewById(R.id.relative1);
        lin_click1.setOnClickListener(this);
        lin_click2=(LinearLayout)findViewById(R.id.relative2);
        lin_click2.setOnClickListener(this);
        view1=(View)findViewById(R.id.view1);
        view2=(View)findViewById(R.id.view2);
        txt_local=findViewById(R.id.local);
        txt_global=findViewById(R.id.global);
        image_arrow=findViewById(R.id.imageView15);
        image_arrow.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.relative1:
                view1.setVisibility(View.VISIBLE);
                txt_local.setAlpha((float) 0.8);
                txt_global.setAlpha((float) 0.5);
                view2.setVisibility(View.INVISIBLE);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, EpisodeFragment.newInstance()).addToBackStack("tag").commit();
                break;
            case R.id.relative2:
                view1.setVisibility(View.INVISIBLE);
                view2.setVisibility(View.VISIBLE);
                txt_global.setAlpha((float) 0.8);
                txt_local.setAlpha((float) 0.5);
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                transaction1.replace(R.id.container, AboutFragment.newInstance()).addToBackStack("tag").commit();

                break;
            case R.id.imageView15:
                 startActivity(new Intent(PodcastChannelActivity.this,MainActivity.class));
                 finish();
                break;

        }
    }
}
