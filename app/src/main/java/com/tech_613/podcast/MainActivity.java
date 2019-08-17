package com.tech_613.podcast;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.tech_613.podcast.fragment.LocalTop40Fragment;
import com.tech_613.podcast.fragment.PoadCastFragment;
import com.tech_613.podcast.fragment.ProfileFragment;
import com.tech_613.podcast.fragment.SearchFragment;
import com.tech_613.podcast.fragment.SubscriptionFragment;
import com.tech_613.podcast.ui.activity.EditCategoryActivity;
import com.tech_613.podcast.utils.PreferenceManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView bottom1,bottom2,bottom3,bottom4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(PreferenceManager.getThem()==1)
        {
            setContentView(R.layout.activity_dark_main);
        }
        else {
            setContentView(R.layout.activity_main);

        }

        initXml();
        Intent intent=getIntent();

        if(intent.getStringExtra("fragment")!=null)
            {
                FragmentTransaction transaction3 = getSupportFragmentManager().beginTransaction();
                transaction3.replace(R.id.frame_container, ProfileFragment.newInstance()).addToBackStack("tag").commit();
                onChangebutton(3);
            }
            else {
               FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
               transaction.replace(R.id.frame_container, PoadCastFragment.newInstance()).addToBackStack("tag").commit();
            }


    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
      finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==1000)
        {
            Log.d("profile","profile");
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    public void initXml(){
        bottom1=findViewById(R.id.bt1);
        bottom1.setOnClickListener(this);
        bottom2=findViewById(R.id.bt2);
        bottom2.setOnClickListener(this);
        bottom3=findViewById(R.id.bt3);
        bottom3.setOnClickListener(this);
        bottom4=findViewById(R.id.bt4);
        bottom4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bt1:
                onChangebutton(0);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, PoadCastFragment.newInstance()).addToBackStack("tag").commit();
                break;
            case R.id.bt2:
                onChangebutton(1);
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                transaction1.replace(R.id.frame_container, SearchFragment.newInstance()).addToBackStack("tag").commit();
                break;
            case R.id.bt3:
                onChangebutton(2);
                FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                transaction2.replace(R.id.frame_container, SubscriptionFragment.newInstance()).addToBackStack("tag").commit();
                break;
            case R.id.bt4:
                onChangebutton(3);
                FragmentTransaction transaction3 = getSupportFragmentManager().beginTransaction();
                transaction3.replace(R.id.frame_container, ProfileFragment.newInstance()).addToBackStack("tag").commit();
                break;
        }

    }
    public void onChangebutton(int p){

        switch (p)
        {
            case 0:

                if(PreferenceManager.getThem()==1)

                {
                    bottom1.setImageResource(R.drawable.ic_discover1);
                bottom2.setImageResource(R.drawable.ic_gdsearch);
                bottom3.setImageResource(R.drawable.ic_gdstar);
                bottom4.setImageResource(R.drawable.ic_gdprofile);
                }
                else {
                    bottom1.setImageResource(R.drawable.ic_compas);
                    bottom2.setImageResource(R.drawable.ic_gsearch);
                    bottom3.setImageResource(R.drawable.ic_gstar);
                    bottom4.setImageResource(R.drawable.ic_gprofile);
                }

                break;
            case 1:

                if(PreferenceManager.getThem()==1)
                {
                    bottom1.setImageResource(R.drawable.ic_gddiscover);
                    bottom2.setImageResource(R.drawable.ic_dsearch);
                    bottom3.setImageResource(R.drawable.ic_gdstar);
                    bottom4.setImageResource(R.drawable.ic_gdprofile);
                }
                else {
                    bottom1.setImageResource(R.drawable.ic_gcompas);
                    bottom2.setImageResource(R.drawable.ic_search);
                    bottom3.setImageResource(R.drawable.ic_gstar);
                    bottom4.setImageResource(R.drawable.ic_gprofile);
                }



                break;
            case 2:
                if(PreferenceManager.getThem()==1)
                {
                    bottom1.setImageResource(R.drawable.ic_gddiscover);
                    bottom2.setImageResource(R.drawable.ic_gdsearch);
                    bottom3.setImageResource(R.drawable.ic_dstar);
                    bottom4.setImageResource(R.drawable.ic_gdprofile);
                }
                else {
                    bottom1.setImageResource(R.drawable.ic_gcompas);
                    bottom2.setImageResource(R.drawable.ic_gsearch);
                    bottom3.setImageResource(R.drawable.ic_star);
                    bottom4.setImageResource(R.drawable.ic_gprofile);
                }



                break;
            case 3:

                if(PreferenceManager.getThem()==1)
                {
                    bottom1.setImageResource(R.drawable.ic_gddiscover);
                    bottom2.setImageResource(R.drawable.ic_gdsearch);
                    bottom3.setImageResource(R.drawable.ic_gdstar);
                    bottom4.setImageResource(R.drawable.ic_dprofile);
                }
                else {
                    bottom1.setImageResource(R.drawable.ic_gcompas);
                    bottom2.setImageResource(R.drawable.ic_gsearch);
                    bottom3.setImageResource(R.drawable.ic_gstar);
                    bottom4.setImageResource(R.drawable.ic_profile);
                }

                break;
        }

    }
}
