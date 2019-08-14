package com.tech_613.podcast.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.tech_613.podcast.MainActivity;
import com.tech_613.podcast.R;
import com.tech_613.podcast.fragment.ProfileFragment;

public class EditProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout lin_back;
    private LinearLayout name_lin,city_lin,country_lin,lan_lin;
    private EditText txt_name,txt_city,txt_country,txt_lang;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_page);
        initXml();


    }
    public void initXml(){
        lin_back=findViewById(R.id.backlinear);
        lin_back.setOnClickListener(this);
        name_lin=findViewById(R.id.name_layout);
        city_lin=findViewById(R.id.city_layout);
        country_lin=findViewById(R.id.country_layout);
        lan_lin=findViewById(R.id.lang_layout);
        txt_city=findViewById(R.id.txt_city);
        txt_city.setOnClickListener(this);
        txt_country=findViewById(R.id.txt_country);
        txt_country.setOnClickListener(this);
        txt_lang=findViewById(R.id.txt_lang);
        txt_lang.setOnClickListener(this);
        txt_name=findViewById(R.id.txt_name);
        txt_name.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.backlinear:
                Intent intent=new Intent(EditProfileActivity.this, MainActivity.class);
                intent.putExtra("fragment","Proffile");
                startActivity(intent);
                finish();
                break;
            case R.id.txt_city:
                onChangebackground(1);
                break;
            case R.id.txt_name:
                onChangebackground(0);
                break;
            case R.id.txt_country:
                onChangebackground(2);
                break;
            case R.id.txt_lang:
                onChangebackground(3);
                break;
        }
    }
    public void onChangebackground(int position){
        switch (position)
        {
            case 0:
                name_lin.setBackgroundResource(R.drawable.edit_focus_background);
                txt_name.setCursorVisible(true);
                break;
            case 1:
                city_lin.setBackgroundResource(R.drawable.edit_focus_background);
                txt_city.setCursorVisible(true);
                break;
            case 2:
                country_lin.setBackgroundResource(R.drawable.edit_focus_background);
                txt_country.setCursorVisible(true);
                break;
            case 3:
                lan_lin.setBackgroundResource(R.drawable.edit_focus_background);
                txt_lang.setCursorVisible(true);
                break;
        }

    }

}
