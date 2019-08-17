package com.tech_613.podcast.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.tech_613.podcast.R;
import com.tech_613.podcast.utils.PreferenceManager;

public class SplashScreenActivity extends AppCompatActivity {


    private String refreshToken = "";
    private SyncStateContract.Constants constants;
    private ConstraintLayout background;
    int duration = 3000;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(PreferenceManager.getThem()==1){
            setContentView(R.layout.activity_dark_splashscreen);
        }
        else {
            setContentView(R.layout.activity_splashscreen);
        }

        background = (ConstraintLayout) findViewById(R.id.splashlayout);
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(duration);
        background.startAnimation(anim);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
               startActivity(new Intent(SplashScreenActivity.this,OnBoardingScreen.class));
               finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
