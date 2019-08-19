package com.tech_613.podcast.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.pchmn.materialchips.ChipsInput;
import com.pchmn.materialchips.model.ChipInterface;
import com.tech_613.podcast.MainActivity;
import com.tech_613.podcast.R;
import com.tech_613.podcast.fragment.ProfileFragment;
import com.tech_613.podcast.model.ContactChip;
import com.tech_613.podcast.utils.PreferenceManager;

import java.util.ArrayList;
import java.util.List;

import static android.view.KeyEvent.KEYCODE_ENTER;

public class EditProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout lin_back;
    private LinearLayout name_lin,city_lin,country_lin,lan_lin;
    private TextInputEditText txt_name,txt_city,txt_country,txt_lang;
    ChipsInput chipsInput;
    ArrayList<ContactChip> languagelist ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(PreferenceManager.getThem()==1){
            setContentView(R.layout.activity_dark_editprofile);
        }else {
            setContentView(R.layout.activity_edit_profile_page);
        }

        initXml();

        txt_name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d("state","change");
                txt_name.setCursorVisible(true);
                if(PreferenceManager.getThem()==1)
                {
                    name_lin.setAlpha(1);
                    city_lin.setAlpha((float) 0.2);
                    country_lin.setAlpha((float) 0.2);
                }
               else {

                    name_lin.setBackgroundResource(R.drawable.edit_focus_background);
                    city_lin.setBackgroundResource(R.drawable.edit_background_two);
                    country_lin.setBackgroundResource(R.drawable.edit_background_two);
                }

            }
        });
        txt_city.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d("state","change");
                txt_city.setCursorVisible(true);
                if(PreferenceManager.getThem()==1)
                {
                    name_lin.setAlpha((float)0.2);
                    city_lin.setAlpha(1);
                    country_lin.setAlpha((float) 0.2);
                }
                else {
                    name_lin.setBackgroundResource(R.drawable.edit_background_two);
                    city_lin.setBackgroundResource(R.drawable.edit_focus_background);
                    country_lin.setBackgroundResource(R.drawable.edit_background_two);
                }


            }
        });
        txt_country.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d("state","change");
                txt_country.setCursorVisible(true);
                if(PreferenceManager.getThem()==1)
                {
                    name_lin.setAlpha((float)0.2);
                    city_lin.setAlpha((float)0.2);
                    country_lin.setAlpha(1);
                }
                else {
                    name_lin.setBackgroundResource(R.drawable.edit_background_two);
                    city_lin.setBackgroundResource(R.drawable.edit_background_two);
                    country_lin.setBackgroundResource(R.drawable.edit_focus_background);

                }

            }
        });

        txt_lang.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if(PreferenceManager.getThem()==1){
                    name_lin.setAlpha((float)0.2);
                    city_lin.setAlpha((float)0.2);
                    country_lin.setAlpha((float)0.2);
                }
                else {
                    name_lin.setBackgroundResource(R.drawable.edit_background_two);
                    city_lin.setBackgroundResource(R.drawable.edit_background_two);
                    country_lin.setBackgroundResource(R.drawable.edit_background_two);
                }

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(EditProfileActivity.this,MainActivity.class);
        intent.putExtra("fragment","editprofile");
        startActivity(intent);

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
        txt_name=findViewById(R.id.txt_name);
        txt_name.setOnClickListener(this);
        txt_lang=findViewById(R.id.txt_lang);
        txt_city.setCursorVisible(false);
        txt_name.setCursorVisible(false);
        txt_country.setCursorVisible(false);
        txt_lang.requestFocus();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
//        chipsInput = (ChipsInput) findViewById(R.id.chips_input);
//        chipsInput.addChip("French", "French");

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
                if(PreferenceManager.getThem()==1)
                {
                    onDarkChange(1);
                }
                else {
                    onChangebackground(1);
                }

                break;
            case R.id.txt_name:
                if(PreferenceManager.getThem()==1)
                {
                    onDarkChange(0);
                }
                else {
                    onChangebackground(0);
                }
                break;
            case R.id.txt_country:
                if(PreferenceManager.getThem()==1)
                {
                    onDarkChange(2);
                }
                else {
                    onChangebackground(2);
                }
                break;

        }
    }
    public void onChangebackground(int position){
        switch (position)
        {
            case 0:



                break;
            case 1:
//                txt_city.requestFocus();
//                city_lin.setBackgroundResource(R.drawable.edit_focus_background);

                break;
            case 2:
//                country_lin.setBackgroundResource(R.drawable.edit_focus_background);
//                txt_country.setCursorVisible(true);
                break;
            case 3:
                lan_lin.setBackgroundResource(R.drawable.edit_focus_background);
                txt_lang.setCursorVisible(true);
                break;
        }

    }

    public void onDarkChange(int position)
    {
        switch (position)
        {
            case 0:
                name_lin.setBackgroundResource(R.drawable.edit_dark_profile);
                txt_name.setCursorVisible(true);
                break;
            case 1:
                city_lin.setBackgroundResource(R.drawable.edit_dark_profile);
                txt_city.setCursorVisible(true);
                break;
            case 2:
                country_lin.setBackgroundResource(R.drawable.edit_dark_profile);
                txt_country.setCursorVisible(true);
                break;
            case 3:
                lan_lin.setBackgroundResource(R.drawable.edit_dark_profile);
                txt_lang.setCursorVisible(true);
                break;
        }
    }




}
