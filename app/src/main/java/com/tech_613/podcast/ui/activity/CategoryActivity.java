package com.tech_613.podcast.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tech_613.podcast.MainActivity;
import com.tech_613.podcast.R;
import com.tech_613.podcast.adpter.EqualSpacingItemDecoration;
import com.tech_613.podcast.adpter.ImageListAdapter;
import com.tech_613.podcast.model.ImageModel;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView category_recy;
    private ArrayList<ImageModel> imageModelArrayList;
    private ImageListAdapter imageListAdapter;
    private Button btn_select;
    private int btn_count=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);
        category_recy=(RecyclerView)findViewById(R.id.recyclerView);
        btn_select=(Button)findViewById(R.id.button);
        imageListAdapter=new ImageListAdapter(this,imageList());
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(CategoryActivity.this, 2);
        category_recy.setLayoutManager(mGridLayoutManager);
        category_recy.addItemDecoration(new EqualSpacingItemDecoration(0, EqualSpacingItemDecoration.GRID));
//        category_recy.addItemDecoration(new EqualSpacingItemDecoration(17, EqualSpacingItemDecoration.VERTICAL));
        category_recy.setAdapter(imageListAdapter);

        btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn_count>=1)
                {
                    startActivity(new Intent(CategoryActivity.this, MainActivity.class));
                    finish();
                }
                else {
                    Toast.makeText(CategoryActivity.this,"Please,select your favorite podcasts.",Toast.LENGTH_SHORT).show();
                }
            }
        });
        imageListAdapter.setImageClickListener(new ImageListAdapter.OnImageListener() {
            @Override
            public void onImageClick(String path) {

            }

            @Override
            public void onSelectbutton(int count,int position) {
                Log.d("count",String.valueOf(count));
                Log.d("position",String.valueOf(position));
                btn_count=count;
                if(count >=1)
                {
                    btn_select.setBackgroundResource(R.drawable.button_background_pressed);

                }
                else {
                    btn_select.setBackgroundResource(R.drawable.button_background_default);
                }
            }
        });
    }

    private ArrayList<ImageModel> imageList(){

        imageModelArrayList= new ArrayList<>();

        for(int i = 0; i < 19; i++){

            ImageModel model=new ImageModel(R.drawable.music);
            imageModelArrayList.add(model);

        }

        return imageModelArrayList;
    }


}
