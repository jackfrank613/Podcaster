package com.tech_613.podcast.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.tech_613.podcast.MainActivity;
import com.tech_613.podcast.R;
import com.tech_613.podcast.utils.PreferenceManager;

public class SignupActivity extends AppCompatActivity {

    private ImageView btn_facebook,btn_google;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(PreferenceManager.getThem()==1){
            setContentView(R.layout.activity_dark_signup);
        }
        else {
            setContentView(R.layout.activity_signup);
        }

        btn_facebook=(ImageView)findViewById(R.id.f_button);
        btn_google=(ImageView)findViewById(R.id.g_button);
        btn_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, CategoryActivity.class));
                finish();
            }
        });
        btn_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this,CategoryActivity.class));
                finish();
            }
        });

    }


}
