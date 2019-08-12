package com.tech_613.podcast.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tech_613.podcast.MainActivity;
import com.tech_613.podcast.R;

import com.tech_613.podcast.adpter.TopPagerAdapter;
import com.tech_613.podcast.fragment.GlobalTop40Fragment;
import com.tech_613.podcast.fragment.LocalTop40Fragment;

public class Top40Activity extends AppCompatActivity implements View.OnClickListener {

   private LinearLayout lin_click1,lin_click2;
   private View view1,view2;
   private TextView txt_local,txt_global;
   private ViewPager pager;
   private TopPagerAdapter topPagerAdapter;
   private LinearLayout image_arrow;
    @SuppressLint("ClickableViewAccessibility")
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
        txt_local=findViewById(R.id.local);
        txt_global=findViewById(R.id.global);
        image_arrow=findViewById(R.id.imageView6);
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
                transaction.replace(R.id.container, LocalTop40Fragment.newInstance()).addToBackStack("tag").commit();
                break;
            case R.id.relative2:
                view1.setVisibility(View.INVISIBLE);
                view2.setVisibility(View.VISIBLE);
                txt_global.setAlpha((float) 0.8);
                txt_local.setAlpha((float) 0.5);
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                transaction1.replace(R.id.container, GlobalTop40Fragment.newInstance()).addToBackStack("tag").commit();

                break;
            case R.id.imageView6:
                startActivity(new Intent(Top40Activity.this,MainActivity.class));
                finish();
                break;
        }
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(Top40Activity.this, MainActivity.class));
        finish();
    }

}
