package com.tech_613.podcast.ui.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.method.SingleLineTransformationMethod;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.tech_613.podcast.R;
import com.tech_613.podcast.adpter.OnboardingViewpagerAdapter;
import com.tech_613.podcast.model.ScreenItem;
import com.tech_613.podcast.utils.PreferenceManager;

import java.util.ArrayList;
import java.util.List;

public class OnBoardingScreen extends AppCompatActivity implements View.OnClickListener {

    private ViewPager screenPager;
    OnboardingViewpagerAdapter onboardingViewpagerAdapter;
    private View rect1,rect2,rect3;
    private List<ScreenItem> mList;
    private List<View> rectList;
    private ImageView btn_image;
//    private TextView textView;
    int position;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if(PreferenceManager.getThem()==1){
//            setContentView(R.layout.activity_dark_firstscreen);
//        }
//        else {
//
//        }
        setContentView(R.layout.activity_firstscreen);
        //init xml setting
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
         btn_image=(ImageView)findViewById(R.id.btn_image);
         btn_image.setOnClickListener(this);
         rect1=findViewById(R.id.rec1);
         rect2=findViewById(R.id.rect2);
         rect3=findViewById(R.id.rect3);
//         textView=findViewById(R.id.txt_skip);
//         textView.setOnClickListener(this);
         mList=new ArrayList<>();
         mList.add(new ScreenItem(R.string.discover_fr,R.string.discover_am,R.drawable.ic_onb1_new));
         mList.add(new ScreenItem(R.string.listen_to_y,R.string.access_your,R.drawable.ic_onb_2new));
         mList.add(new ScreenItem(R.string.keep_track_,R.string.access_yours,R.drawable.ic_onb_3));

      //setup viewpager
        int dp_height=pxToDp(height);
        screenPager=findViewById(R.id.screen_viewpager);
        onboardingViewpagerAdapter =new OnboardingViewpagerAdapter(this,mList);
        screenPager.setAdapter(onboardingViewpagerAdapter);
//        screenPager.setMinimumHeight(dp_height);
        screenPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                Log.d("scrolled",String.valueOf(i));
                onSelectedPageChange(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_image:
                position =screenPager.getCurrentItem();
                Log.d("count",String.valueOf(position));
                onProcessfunction(position);
                onProcessIndicator(position);
                break;
//            case R.id.txt_skip:
//                skipFunction();
//                break;
        }
    }
    public void onProcessfunction(int position)
    {

        if(position<mList.size())
        {
            position++;
            screenPager.setCurrentItem(position);

        }
        if(position==mList.size()){
           skipFunction();
        }
    }

    public void onProcessIndicator(int position1){
        if(position1==0)
        {
            rect1.setAlpha((float) 0.3);
            rect2.setAlpha(1);
            rect3.setAlpha((float) 0.3);
        }
        else if(position1==1)
        {
            rect1.setAlpha((float) 0.3);
            rect2.setAlpha((float) 0.3);
            rect3.setAlpha(1);
        }
        else {
            rect1.setAlpha((float) 0.3);
            rect2.setAlpha((float) 0.3);
            rect3.setAlpha(1);
        }
    }
    public void onSelectedPageChange(int position)
    {
        if(position==0)
        {
            rect1.setAlpha(1);
            rect2.setAlpha((float) 0.3);
            rect3.setAlpha((float) 0.3);
        }
        else if(position==1)
        {
            rect1.setAlpha((float) 0.3);
            rect3.setAlpha((float) 0.3);
            rect2.setAlpha(1);
        }
        else {
            rect1.setAlpha((float) 0.3);
            rect2.setAlpha((float) 0.3);
            rect3.setAlpha(1);
        }

    }
    public void skipFunction(){
        Intent intent=new Intent(OnBoardingScreen.this, SignupActivity.class);
        startActivity(intent);
        finish();
    }
    public static int pxToDp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }
}
