package com.tech_613.podcast.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.tech_613.podcast.R;

import com.tech_613.podcast.fragment.LocalTop40Fragment;

public class Top40Activity extends AppCompatActivity implements View.OnClickListener {

   private LinearLayout lin_click1,lin_click2;
   private View view1,view2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top40_page);
        initXml();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, LocalTop40Fragment.newInstance()).addToBackStack("tag").commit();


    }

    public void initXml(){

        lin_click1=(LinearLayout)findViewById(R.id.relative1);
        lin_click1.setOnClickListener(this);
        lin_click2=(LinearLayout)findViewById(R.id.relative2);
        lin_click2.setOnClickListener(this);
        view1=(View)findViewById(R.id.view1);
        view2=(View)findViewById(R.id.view2);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.relative1:
                view1.setVisibility(View.VISIBLE);
                view2.setVisibility(View.INVISIBLE);
                break;
            case R.id.relative2:
                view1.setVisibility(View.INVISIBLE);
                view2.setVisibility(View.VISIBLE);

                break;
        }
    }
}
